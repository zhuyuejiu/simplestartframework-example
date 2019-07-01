package org.ranger.example.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ranger.example.service.UserService;
import org.simplestartframwork.context.annotation.Inject;
import org.simplestartframwork.context.annotation.component.Action;
import org.simplestartframwork.web.annotation.PathMapping;
import org.simplestartframwork.web.annotation.RequestParam;

//设置组件类注解
@Action
//设置路径访问命名空间
@PathMapping(value = "/user")
public class UserAction {
	
	private static final Logger LOGGER = LogManager.getLogger(UserAction.class.getName());
	
	/**
	 * 注入业务对象
	 */
	@Inject
	private UserService userService;

	/**
	 * 增加用户
	 * @param entity
	 * @return
	 */
	@PathMapping(value = "/add")
	public String add(@RequestParam("entity") Map<String, Object> entity,HttpServletRequest request) {
		LOGGER.debug("-增加用户-"+entity);
		Map<String, Object> user = userService.add(entity);
		System.out.println(user.get("user_id"));
		
		
	    //插入后，返回用户列表
		return this.list(request);

	}
	
	/**
	 * 删除用户
	 * @param entity
	 * @return
	 */
	@PathMapping(value = "/delete")
	public String delete(@RequestParam("id") Long id,HttpServletRequest request) {
		LOGGER.debug("-删除用户-"+id);
		
		userService.deleteById(id);
	
		 //插入后，返回用户列表
		return this.list(request);
	}

	
	/**
	 * 更新用户
	 * @param entity
	 * @return
	 */
	@PathMapping(value = "/update")
	public String update(@RequestParam(value="entity") Map<String, Object> entity,HttpServletRequest request) {
		LOGGER.debug("-更新用户-"+entity);
		userService.updateOfNotNull(entity);
		

		 //更新后，返回用户列表
		return this.list(request);
	}
	
	/**
	 *  跳转到更新用户页面
	 * @param entity
	 * @return
	 */
	@PathMapping(value = "/to_update")
	public String toUpdate(@RequestParam("id") Long id,HttpServletRequest request) {
		LOGGER.debug("-跳转更新用户页面-"+id);
		
		Map<String, Object> user = userService.findUserById(id);
		request.setAttribute("user", user);
		LOGGER.debug("返回的用户："+user);

		return "forward:/update.jsp";
	}

	/**
	 * 查询用户
	 */
	@PathMapping(value = "/list")
	public String list(HttpServletRequest request) {
		LOGGER.debug("-查询用户-");
		List<Map<String, Object>> users = userService.findAll();
		if(users!=null) {
			request.setAttribute("users",users);
		}
	
		return "forward:/info.jsp";

	}





}
