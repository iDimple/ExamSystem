package nju.wqy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nju.wqy.model.UserData;



public interface UserDao extends JpaRepository<UserData, Integer>{

}
