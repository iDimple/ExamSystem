package nju.wqy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;

import nju.wqy.constants.Option;
import nju.wqy.constants.Question;
import nju.wqy.constants.QuestionSet;
import nju.wqy.dao.ExamRecordDao;
import nju.wqy.model.Config;
import nju.wqy.model.ConfigData;
import nju.wqy.model.Course;
import nju.wqy.model.CourseData;
import nju.wqy.model.Data;
import nju.wqy.model.Exam;
import nju.wqy.model.ExamData;
import nju.wqy.model.ExamDetail;
import nju.wqy.model.ExamRecordData;
import nju.wqy.model.KeyDetail;
import nju.wqy.model.KeyRecordData;
import nju.wqy.model.OptionVO;
import nju.wqy.model.Paper;
import nju.wqy.model.QuestionVO;
import nju.wqy.model.Student;
import nju.wqy.model.User;
import nju.wqy.model.UserData;
import nju.wqy.service.ExamService;



@RestController
public class HelloWorldRestController {



	@Autowired
	ExamService examService; 


	@RequestMapping(value = "/paper/{key}", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Data> getPaper(@PathVariable("key") String key) {
		//第一步得到uid和examId
		System.out.println("Fetching detail with key " + key);
		//KeyDetail k=examService.findByKeyword(key);
		KeyRecordData k=examService.getKeyRecord(key);
		if(k==null){
			System.out.println("detail with key " + key+ " not found");
			return new ResponseEntity<Data>(HttpStatus.NOT_FOUND);
		}
		//第二步得到学生信息
		int uid=k.getUid();
		System.out.println("Fetching student with uid " + uid);
		//Student student=examService.findById(uid);
		UserData student=examService.getUser(uid);
		if(student==null){
			System.out.println("tudent with uid" + uid+ " not found");
			return new ResponseEntity<Data>(HttpStatus.NOT_FOUND);
		}
		//第三步得到exam表
		int examId=k.getExamId();
		System.out.println("Fetching exam with examId " + examId);
		//这里有试题
		ExamData exam=examService.getExam(examId);

		if(exam==null){
			System.out.println("exam with examId" + examId+ " not found");
			return new ResponseEntity<Data>(HttpStatus.NOT_FOUND);
		}
		String examName=exam.getName();
		//第四步得到试卷信息
		String qjson=exam.getQJson();
		System.out.println("Fetching paper with qJson " + qjson);
		Gson gson = new Gson();
		QuestionSet qs=gson.fromJson(qjson,QuestionSet.class);
		//Paper paper = examService.findByExamId(qfile);

		ExamRecordData examRecord=examService.getExamRecord(uid, examId);
		if(examRecord==null){
			System.out.println("Paper with qfile " + 1+ " not found");
			return new ResponseEntity<Data>(HttpStatus.NOT_FOUND);
		}
		String questionOrder =examRecord.getQuestion_order();
		String optionOrder=examRecord.getOption_order();
		Paper paper=getPaper(qs,questionOrder,optionOrder);
		//第五部得到课程名
		int courseId=exam.getCourseId();
		//Course course=examService.findCourse(courseId);
		CourseData course=examService.getCourse(courseId);
		//第六步得到开始时间结束时间
		int configId=exam.getConfigId();
		//Config config=examService.findConfig(configId);
		ConfigData config=examService.getConfig(configId);
		//第七部封装examdetail
		ExamDetail ed=new ExamDetail();
		ed.setEnd(config.getEndTime().toString());
		ed.setStart(config.getStartTime().toString());
		ed.setName(course.getName());
		ed.setExamName(examName);
		ed.setExamID(examId);
		//第八部总封装
		Data data=new Data();
		data.setPaper(paper);
		data.setUserData(student);
		data.setExamDetail(ed);
		return new ResponseEntity<Data>(data,HttpStatus.OK);
	}

	//得到排好顺序的试题
	Paper getPaper(QuestionSet quest,String questionOrder,String optionOrder) {
		ArrayList<QuestionVO> qs=new ArrayList<QuestionVO>();
		Paper a=new Paper();
		List<Question> questions= quest.questions;
		//试题顺序,从1开始
		String[] orders=questionOrder.split("-");
		String[] options=optionOrder.split("-");
		for(int i=0;i<orders.length;i++) {
			int order=Integer.parseInt(orders[i])-1;
			Question q=questions.get(order);
			QuestionVO qv=getQuestionVO(q,options[i]);
			qs.add(qv);
		}
		a.setQuestions(qs);
		return a;
	}
	//排好选项
	QuestionVO getQuestionVO(Question ques,String optionOrder) {
		List<Option> options=ques.options;
		QuestionVO qv=new QuestionVO();
		qv.setTitle(ques.title);
		qv.setSingleOption(ques.isSingleOption);
		qv.setValue(ques.score);
		//选项顺序从A开始
		char[] orders=optionOrder.toCharArray();
		
		List<OptionVO> optionVOs=new ArrayList<OptionVO>();
		for(int i=0;i<orders.length;i++) {
			int order=orders[i]-'A';
			Option o=options.get(order);
			OptionVO ovo=new OptionVO();
			ovo.content=o.content;
			optionVOs.add(ovo);
		}
		qv.setOptionVOs(optionVOs);
		return qv;
	}
}
