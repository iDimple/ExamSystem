package nju.wqy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nju.wqy.model.CourseData;
import nju.wqy.model.SampleData;

public interface CourseDao extends JpaRepository<CourseData, Integer> {


}
