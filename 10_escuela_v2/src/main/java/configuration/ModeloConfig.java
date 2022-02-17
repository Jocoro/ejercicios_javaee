package configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;



//para saber donde esta el archivo donde tenemos que buscar los values
@PropertySource("classpath:configuration/application.properties")
@EnableTransactionManagement
@ComponentScan({"dao","service"})
@Configuration
public class ModeloConfig {
	@Value("${driver}")
	String driver;
	@Value("${url}")
	String url;
	@Value("${user}")
	String user;
	@Value("${pwd}")
	String pwd;
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(pwd);
		return dataSource;
	}
	//adaptador de Hibernate
	@Bean
	public HibernateJpaVendorAdapter adapter() {
	HibernateJpaVendorAdapter adp=new HibernateJpaVendorAdapter();
	adp.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
	return adp;
	}
	//factoria EntityManager: Objeto para acceder a capa de persistencia con JPA
	@Bean
	public LocalContainerEntityManagerFactoryBean factory(DataSource dataSource, HibernateJpaVendorAdapter adapter) {
	LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
	factory.setPersistenceUnitName("escuelaPU");
	factory.setDataSource(dataSource);
	factory.setPackagesToScan("model");
	factory.setJpaVendorAdapter(adapter);
	return factory;
	}
	//gestor de transacción
	@Bean
	public JpaTransactionManager txManager(LocalContainerEntityManagerFactoryBean factory) {
	JpaTransactionManager manager=new JpaTransactionManager();
	manager.setEntityManagerFactory(factory.getObject());
	return manager;
	}

}
