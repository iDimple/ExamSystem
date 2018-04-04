package nju.wqy.service;

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
import nju.wqy.model.Student;
import nju.wqy.model.UserData;

public interface ExamService {
Paper findByExamId(String qfile);
Student findById(int uid);
KeyDetail findByKeyword(String key);
Exam findExam(int examId);
Course findCourse(int courseId);
Config findConfig(int configId);

ExamData getExam(int id);
KeyRecordData getKeyRecord(String rsk);
UserData getUser(int id);
ExamRecordData getExamRecord(int uid,int exam_id);
CourseData getCourse(int id);
ConfigData getConfig(int id);
}
