package nju.wqy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nju.wqy.model.SampleData;

public interface SampleDao extends JpaRepository<SampleData, Integer> {
    SampleData findByName(String name);

    SampleData findByNameAndDetail(String name, String detail);

    @Query("from SampleData s where s.name=:name")
    SampleData findSample(@Param("name") String name);
}
