package org.ranger.example.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ranger.example.mapper.UserMapper;
import org.ranger.example.service.UserService;
import org.simplestartframwork.context.annotation.Inject;
import org.simplestartframwork.context.annotation.component.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER =LogManager.getLogger(UserServiceImpl.class.getName());
	
	@Inject
	private UserMapper userMapper;

	@Override
	public Map<String, Object> add(Map<String, Object> entity) {
		int count = userMapper.insert(entity);
		if(count>0) {
			return entity;
		}
		return null;
	}

	@Override
	public int deleteById(Long id) {
		
		return userMapper.delete(id);
	}

	@Override
	public int updateOfNotNull(Map<String, Object> entity) {

		return userMapper.updateOfNotNull(entity);
	}

	@Override
	public List<Map<String, Object>> findAll() {
		
		 List<Map<String, Object>> users = userMapper.findAll();
		 System.out.println("service result users:"+users);
		 return users;
		
	}

	@Override
	public Map<String, Object> findUserById(Long id) {
		LOGGER.debug("-通过ID查询用户-");
		Map<String, Object> user = userMapper.findById(id);
		return user;
	}
	

		
	

}
