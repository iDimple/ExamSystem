package nju.wqy.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import nju.wqy.model.ExamRecordData;




public interface ExamRecordDao extends JpaRepository<ExamRecordData, Integer>{

	
	@Query("from ExamRecordData s where s.uid=:uid and s.exam_id=:exam_id")
	ExamRecordData getExamRecord(@Param("uid") int uid,@Param("exam_id") int exam_id);
	
	
//	@Modifying
//	@Query("update ExamRecordData c set c.answer =:answer and c.score=:score where c.exam_id=:exam_id and c.uid=:uid")
//	int updateExamRecord(@Param("answer")String answer, @Param("score")int score, @Param("exam_id")int exam_id, @Param("uid")int uid);
}
