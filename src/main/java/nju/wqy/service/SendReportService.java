package nju.wqy.service;

import nju.wqy.model.ExamRecordData;

public interface SendReportService {
Boolean saveRecord(ExamRecordData examrecord);

int updateExamRecord(String answer, int score,int examId,int uid);

Boolean updateExam(ExamRecordData data);
}
