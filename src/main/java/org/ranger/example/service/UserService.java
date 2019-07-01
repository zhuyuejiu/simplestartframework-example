package org.ranger.example.service;

import java.util.List;
import java.util.Map;


public interface UserService {
	
	/**
	 * 增加用户
	 * @param entity
	 * @return
	 */
	Map<String,Object>  add(Map<String,Object> entity) ;
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	int deleteById(Long id);
	
	/**
	 * 更新用户非空字段
	 * @param entity
	 * @return
	 */
	int updateOfNotNull(Map<String,Object> entity);
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	List<Map<String,Object>> findAll();
	
	/**
	 * 通过编号好像用户记录
	 * @param id
	 * @return
	 */
	Map<String,Object> findUserById(Long id);
	

}
