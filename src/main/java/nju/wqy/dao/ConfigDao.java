package nju.wqy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nju.wqy.model.ConfigData;


public interface ConfigDao extends JpaRepository<ConfigData, Integer> {


}
