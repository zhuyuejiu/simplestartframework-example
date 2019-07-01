package org.ranger.example.mapper;


import java.util.List;
import java.util.Map;

import org.ranger.example.mapper.builder.UserBuilder;
import org.simplestartframwork.context.annotation.component.Persistent;
import org.simplestartframwork.data.annotation.Options;
import org.simplestartframwork.data.annotation.SQL;
import org.simplestartframwork.data.annotation.SQL.SQLType;
import org.simplestartframwork.data.annotation.SQLBuilder;

@Persistent
public interface UserMapper {
	
	/**
	 * 插入记录
	 * @param entity
	 * @return
	 */
	@SQL(type=SQLType.INSERT,value="INSERT INTO tb_user	(user_name, password,create_date) VALUES (#{user_name}, #{password},#{create_date})")
	@Options(backfillParmaryKey=true,columnName="user_id",propteryName="user_id")
	int insert(Map<String,Object> entity);
	
	/**
	 * 删除记录
	 * @param id
	 * @return
	 */
	@SQL(type=SQLType.DELETE,value="DELETE FROM tb_user WHERE user_id=#{id}")
	int delete(Object id);
	
	/**
	 * 更新非空字符串
	 * @param entity
	 * @return
	 */
	@SQLBuilder(classes=UserBuilder.class,method="updateOfNotNull")
	int updateOfNotNull(Map<String,Object> entity);
	
	/**
	 * 查询所有记录
	 * @return
	 */
	@SQL(type=SQLType.SELECT,value="SELECT *	FROM tb_user")
	List<Map<String,Object>> findAll();
	
	/**
	 * 查询指定Id的记录
	 * @return
	 */
	@SQL(type=SQLType.SELECT,value="SELECT *	FROM tb_user WHERE user_id = #{id}")
	Map<String,Object> findById(Long id);

}
