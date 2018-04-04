package nju.wqy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nju.wqy.model.KeyRecordData;
import nju.wqy.model.SampleData;




public interface KeyRecordDao  extends JpaRepository<KeyRecordData, Integer>{
	
	@Query("from KeyRecordData s where s.rsk=:rsk")
	KeyRecordData findByKey(@Param("rsk") String rsk);
}
