package nju.wqy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nju.wqy.model.ExamData;

public interface ExamDao extends JpaRepository<ExamData, Integer> {
    //TODO : JPA update 用法

}
