package nju.wqy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nju.wqy.dao.ExamRecordDao;
import nju.wqy.dao.SampleDao;
import nju.wqy.model.ExamRecordData;
import nju.wqy.model.SampleData;

@Service("sendReportService")
@Transactional
public class SendReportServiceImpl implements SendReportService{
	@Autowired
	ExamRecordDao examRecordDao;




	@Override
	public Boolean saveRecord(ExamRecordData examrecord) {

		return examRecordDao.save(examrecord)!=null;
	}




	@Override
	public int updateExamRecord(String answer, int score, int examId, int uid) {
		return 0;
				//return updateExamRecord(answer, score,examId, uid);
			}
//	public int updateExamRecord(String answer, int score, int examId, int uid) {
//return 0;
//		//return updateExamRecord(answer, score,examId, uid);
//	}




	@Override
	public Boolean updateExam(ExamRecordData data) {
		
		return examRecordDao.saveAndFlush(data)!=null;
	}

}
