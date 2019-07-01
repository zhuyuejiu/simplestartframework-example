package org.ranger.example.config;

import javax.sql.DataSource;

import org.simplestartframwork.context.annotation.Bean;
import org.simplestartframwork.context.annotation.Config;
import org.simplestartframwork.context.annotation.Scan;
import org.simplestartframwork.context.annotation.component.Persistent;
import org.simplestartframwork.data.SessionFactory;
import org.simplestartframwork.data.datasource.DefaultDataSource;
import org.simplestartframwork.data.impl.DefaultSessionFactory;
import org.simplestartframwork.data.support.SessionFactoryConfigurator;

@Config
@Scan(basePackages={"org.ranger.example"})
public class BeanConfig {
	
	//1.创建默认的数据源
	@Bean(name="dataSource")
	public DataSource dataSource() {
		DefaultDataSource dataSource=new DefaultDataSource();
		dataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		return dataSource;
	}
	
	//2.获得会话工厂
	@Bean(name="sessionFactory")
	public SessionFactory sessionFactory() {
		
		DefaultSessionFactory sessionFactory=new DefaultSessionFactory();
		
		sessionFactory.setDataSource(this.dataSource());
		return sessionFactory;
	}
	
	@Bean
    public  SessionFactoryConfigurator configurator() {
    	SessionFactoryConfigurator configurator=new SessionFactoryConfigurator();
    	SessionFactory sessionFactory = this.sessionFactory();
    	//支持自动提交
    	sessionFactory.setAutoCommit(true);
    	configurator.setMapperPackages("org.ranger.example.mapper");
    	configurator.setSessionFactory(sessionFactory);
    	configurator.setComponentAnnotation(Persistent.class);
    	configurator.configurator();
    	return configurator;
    }

}
