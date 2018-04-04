package nju.wqy.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;

import nju.wqy.constants.Option;
import nju.wqy.constants.Question;
import nju.wqy.constants.QuestionSet;
import nju.wqy.dao.ExamDao;
import nju.wqy.model.AnswerVO;
import nju.wqy.model.Data;
import nju.wqy.model.ExamData;
import nju.wqy.model.ExamRecordData;
import nju.wqy.service.ExamService;
import nju.wqy.service.SendReportService;


@RestController
public class SendReportController {
	@Autowired
	SendReportService sendReportService;
	@Autowired
	ExamService examService; 
	@RequestMapping(value = "/sendReport/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody AnswerVO answervo, 	UriComponentsBuilder ucBuilder) {
		//第一步 计算成绩,
		ExamRecordData examRecord=examService.getExamRecord(answervo.uid, answervo.examID);
		//学生选择 
		String ans=answervo.options;
		ExamData exam=examService.getExam(answervo.examID);
		//原始顺序 
		String qjson=exam.getQJson();
		System.out.println("Fetching paper with qJson " + qjson);
		Gson gson = new Gson();
		QuestionSet qs=gson.fromJson(qjson,QuestionSet.class);
		List<Question> questions= qs.questions;
		//配置顺序
		ExamRecordData ed=examService.getExamRecord(answervo.uid, answervo.examID);
		//得到真正顺序
		String trueAns= getAnswer(questions,ed);
		String value=getValue(questions,ed);
		int score=getScore(ans,trueAns,value);
		System.out.println("score"+score);
		//第二步存储成绩
		examRecord.setAnswer(answervo.options);
		examRecord.setScore(score);
		sendReportService.updateExam(examRecord);
		//第三步发送到邮箱
		String email=answervo.email;
		sendEmail(email,answervo.sname,answervo.examName,score);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	//根据原始顺序和配置顺序，得到真正答案选项
	/**
	 * 
	 * @param questions  原始顺序
	 * @param ed 排序顺序
	 * @return
	 */
	String getAnswer(List<Question> questions,ExamRecordData ed) {

		String b=ed.getQuestion_order();
		String[] c=b.split("-");
		String trueAns="";
		String op=ed.getOption_order();
		//选项顺序
		String[] ooooop=op.split("-");
		//题目顺序
		int[] d=new int[c.length];
		for(int i=0;i<c.length;i++) {
			d[i]=Integer.parseInt(c[i])-1;

		}


		for(int i=0;i<c.length;i++) {
			//得到题目顺序
			Question q=questions.get(d[i]);
			//得到选项顺序
			List<Option> options=q.options;

			char[] f=ooooop[i].toCharArray();
			String answer="";
			for(int j=0;j<f.length;j++) {
				int index=f[j]-'A';
				Option option=options.get(index);
				if(option.isCorrect) {
					answer+=f[j];
				}
			}
			answer+="-";
			trueAns+=answer;
		}
		//去掉最后的－
		trueAns=trueAns.substring(0, trueAns.length()-1);
		return trueAns;
	}
	String getValue(List<Question> questions,ExamRecordData ed) {
		String value="";
		String b=ed.getQuestion_order();
		String[] c=b.split("-");

		String op=ed.getOption_order();
		//选项顺序
		String[] ooooop=op.split("-");
		//题目顺序
		int[] d=new int[c.length];
		for(int i=0;i<c.length;i++) {
			d[i]=Integer.parseInt(c[i])-1;
		}


		for(int i=0;i<c.length;i++) {
			//得到题目顺序
			Question q=questions.get(d[i]);
			//得到分值
			value+=q.score;
			value+='-';
		}

		return value.substring(0, value.length()-1);
	}
	/*
	 * answer学生选择
	 * trueAnswer真正答案
	 * values分值
	 */
	int getScore(String answer,String trueAnswer,String values) {
		System.out.println("useranswer"+answer);
		System.out.println("trueanswer"+trueAnswer);
		System.out.println(values);
		String[] a=answer.split("-");
		String[] b=trueAnswer.split("-");
		String[] c=values.split("-");
		int score=0;
		for(int i=0;i<a.length;i++) {
			if(a[i].equals(b[i])) {
				score+=Integer.parseInt(c[i]);
			}
		}
		return score;
	}
	/**
	 * 
	 * @param email 邮件
	 * @param name 学生姓名
	 * @param examName 考试名称
	 * @param score
	 */
	void sendEmail(String email,String name,String examName,int score) {
		Properties props = new Properties();  
		// 开启debug调试  
		props.setProperty("mail.debug", "true");  
		// 发送服务器需要身份验证  
		props.setProperty("mail.smtp.auth", "true");  
		// 设置邮件服务器主机名  
		props.setProperty("mail.host", "smtp.sina.com");  
		// 发送邮件协议名称  
		props.setProperty("mail.transport.protocol", "smtp");  

		// 设置环境信息  
		Session session = Session.getInstance(props);  

		// 创建邮件对象  
		Message msg = new MimeMessage(session);  
		try {
			msg.setSubject("成绩通知："+examName+"成绩");  
			// 设置邮件内容  
			msg.setText("亲爱的"+name+"同学您好：您的"+examName+"分数为"+score+"。");  
			// 设置发件人  
			msg.setFrom(new InternetAddress("examonlinetest@sina.com"));  

			Transport transport = session.getTransport();  
			// 连接邮件服务器  
			//使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
			transport.connect("examonlinetest", "examonline");  
			// 发送邮件  

			transport.sendMessage(msg, new Address[] {new InternetAddress(email)});
			// 关闭连接  
			transport.close();  
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 

		}
	}
}
