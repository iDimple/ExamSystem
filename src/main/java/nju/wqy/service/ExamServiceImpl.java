package nju.wqy.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nju.wqy.dao.ConfigDao;
import nju.wqy.dao.CourseDao;
import nju.wqy.dao.ExamDao;
import nju.wqy.dao.ExamRecordDao;
import nju.wqy.dao.KeyRecordDao;
import nju.wqy.dao.UserDao;
import nju.wqy.model.Config;
import nju.wqy.model.ConfigData;
import nju.wqy.model.Course;
import nju.wqy.model.CourseData;
import nju.wqy.model.Exam;
import nju.wqy.model.ExamData;
import nju.wqy.model.ExamRecordData;
import nju.wqy.model.KeyDetail;
import nju.wqy.model.KeyRecordData;
import nju.wqy.model.Paper;
import nju.wqy.model.QuestionVO;
import nju.wqy.model.Student;
import nju.wqy.model.UserData;


@Service("examService")
@Transactional
public class ExamServiceImpl implements ExamService{
	@Autowired
	ExamDao examDao;
	@Autowired
	KeyRecordDao keyRecordDao;
	@Autowired
	UserDao userDao;
	@Autowired
	ExamRecordDao examRecordDao;
	@Autowired
	CourseDao  courseDao ;
	@Autowired
	ConfigDao  configDao ;
	public Paper findByExamId(String qfile) {
		Paper a=new Paper();
		QuestionVO q=new QuestionVO();
	
		ArrayList<QuestionVO> qs=new ArrayList<QuestionVO>();
		qs.add(q);
		a.setQuestions(qs);
		return a;
	}

	public Student findById(int uid) {
		Student s=new Student();
		s.setName("胡萝卜");
		return s;
	}

	public KeyDetail findByKeyword(String key) {
		KeyDetail k=new KeyDetail(key);
		k.setExamId(1);
		k.setUid(12);
		return k;
	}

	public Exam findExam(int examId) {
		Exam e=new Exam();
		e.setCourseId(1);
		e.setConfigId(1);
		e.setQFile("qw");
		e.setUFile("er");
		return e			;
	}

	public Course findCourse(int courseId) {
		Course c=new Course();
		c.setName("烹饪的艺术");
		
		return c;
	}

	public Config findConfig(int configId) {
		Config c=new Config();
		
		
		return c;
	}

	@Override
    public ExamData getExam(int id) {
        return examDao.findOne(id);
    }

	@Override
	public KeyRecordData getKeyRecord(String rsk) {
		return keyRecordDao.findByKey(rsk);
	}

	@Override
	public UserData getUser(int id) {
	
		return userDao.findOne(id);
	}

	@Override
	public ExamRecordData getExamRecord(int uid, int exam_id) {
		
		return examRecordDao.getExamRecord(uid, exam_id);
	}

	@Override
	public CourseData getCourse(int id) {
		
		return courseDao.findOne(id);
	}

	@Override
	public ConfigData getConfig(int id) {
		
		return configDao.findOne(id);
	}
}
