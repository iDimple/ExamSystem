package nju.wqy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nju.wqy.model.CourseData;
import nju.wqy.model.TeacherData;

public interface TeacherDao extends JpaRepository<TeacherData, Integer> {

    TeacherData findByNameAndPassword(String name, String password);
}
