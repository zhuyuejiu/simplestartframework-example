package org.ranger.example.mapper.builder;

import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserBuilder {
	
	private static final Logger LOGGER=LogManager.getLogger(UserBuilder.class.getName());
	
	/**
	 * 根据条件非空字段
	 * @param entity
	 * @return
	 */
	public String updateOfNotNull(Map<String,Object> entity){
		String sql="UPDATE tb_user SET ";
		StringBuilder sb =new StringBuilder(sql);
	    Set<String> keySet = entity.keySet();
	    int count=0;
	    for (String key : keySet) {
			Object value = entity.get(key);
			if(value!=null) {
				sb.append(key +" = #{"+key+"}");
			}
			if (count<(keySet.size()-1)) {
				sb.append(",");
			}
			count++;
		}
	    
	    sb.append(" WHERE user_id= #{user_id}");
	
	    LOGGER.debug("updateOfNotNull Build"+sb.toString());
	  
		return sb.toString();
	}

}
