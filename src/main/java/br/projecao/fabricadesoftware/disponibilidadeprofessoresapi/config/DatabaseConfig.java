package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
	
	public static String URL = "jdbc:postgresql://localhost:5432/db_disponibilidade_professores";
	public static String USERNAME = "postgres";
	public static String PASSWORD = "postgres";
	public static String SHOW_SQL = "false";
	public static String DDL_AUTO = "validate";
	
	@Bean
	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em 
	        = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource());
	      em.setPackagesToScan(new String[] { "br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models" });
	 
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      ((HibernateJpaVendorAdapter)vendorAdapter).setShowSql(SHOW_SQL.equalsIgnoreCase("true"));
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(additionalProperties());
	 
	      return em;
	   }
	 
	   @Bean
	   public DataSource dataSource(){
	      DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName("org.postgresql.Driver");
	      dataSource.setUrl(URL);
	      dataSource.setUsername(USERNAME);
	      dataSource.setPassword(PASSWORD);
	      return dataSource;
	   }
	 
	   @Bean
	   public PlatformTransactionManager transactionManager(
	     EntityManagerFactory emf){
	       JpaTransactionManager transactionManager = new JpaTransactionManager();
	       transactionManager.setEntityManagerFactory(emf);
	 
	       return transactionManager;
	   }
	 
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	       return new PersistenceExceptionTranslationPostProcessor();
	   }
	 
	   public Properties additionalProperties() {
	       Properties properties = new Properties();
	       
	       properties.setProperty("hibernate.database", "POSTGRESQL");
	       properties.setProperty("hibernate.hbm2ddl.auto", DDL_AUTO);
	       properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
	       properties.setProperty("hibernate.show_sql", SHOW_SQL);
	       properties.setProperty("hibernate.format_sql", SHOW_SQL);
	       properties.setProperty("hibernate.validationQuery", "SELECT 1");
	       properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
	       properties.put("hibernate.jdbc.lob.non_contextual_creation", "true");
	        
	       return properties;
	   }

}
