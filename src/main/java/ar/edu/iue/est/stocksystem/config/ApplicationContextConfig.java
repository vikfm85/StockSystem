package ar.edu.iue.est.stocksystem.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ar.edu.iue.est.stocksystem.dao.AccountDAO;
import ar.edu.iue.est.stocksystem.dao.OrderDAO;
import ar.edu.iue.est.stocksystem.dao.ProductDAO;
import ar.edu.iue.est.stocksystem.dao.impl.AccountDAOImpl;
import ar.edu.iue.est.stocksystem.dao.impl.OrderDAOImpl;
import ar.edu.iue.est.stocksystem.dao.impl.ProductDAOImpl;

@Configuration
@ComponentScan("ar.edu.iue.est.stocksystem.*")
@EnableTransactionManagement
/**
 * Cargo las distintas variables del ambiente y las distintas configuraciones
 * del programa
 * 
 * @author vikfm1985
 *
 */
@PropertySource("classpath:ds-hibernate-cfg.properties")
public class ApplicationContextConfig {

	// La clase Environment sirve para almacenar todas las propiedades cargadas
	// por el tag @PropertySource
	@Autowired
	private Environment env;

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
		// Cargas las propiedades que se encuentran en
		// message/validator.properties
		rb.setBasenames(new String[] { "messages/validator" });
		return rb;
	}

	// Seteo el viewResolver que es donde va a ir a buscar las paginas jsp del
	// programa
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// Configuracion para cuando deseo hacer un upload.
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();

		// Seteo el tamaño maximo (maxSize)...
		// commonsMultipartResolver.setMaxUploadSize(...);

		return commonsMultipartResolver;
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// See: ds-hibernate-cfg.properties
		dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
		dataSource.setUrl(env.getProperty("ds.url"));
		dataSource.setUsername(env.getProperty("ds.username"));
		dataSource.setPassword(env.getProperty("ds.password"));

		System.out.println("## getDataSource: " + dataSource);

		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
		Properties properties = new Properties();

		// Leo las propiedades del archivo ds-hibernate-cfg.properties
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("current_session_context_class", env.getProperty("current_session_context_class"));

		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		// Package que continene las clases con las entidades
		factoryBean.setPackagesToScan(new String[] { "ar.edu.iue.est.stocksystem.entity" });
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(properties);
		factoryBean.afterPropertiesSet();
		//
		SessionFactory sf = factoryBean.getObject();
		System.out.println("## getSessionFactory: " + sf);
		return sf;
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Bean(name = "accountDAO")
	public AccountDAO getApplicantDAO() {
		return new AccountDAOImpl();
	}

	@Bean(name = "productDAO")
	public ProductDAO getProductDAO() {
		return new ProductDAOImpl();
	}

	@Bean(name = "orderDAO")
	public OrderDAO getOrderDAO() {
		return new OrderDAOImpl();
	}

	@Bean(name = "accountDAO")
	public AccountDAO getAccountDAO() {
		return new AccountDAOImpl();
	}

}