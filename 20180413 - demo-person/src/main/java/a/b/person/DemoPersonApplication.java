package a.b.person;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootApplication
public class DemoPersonApplication implements CommandLineRunner {
	@Autowired
	PersonDAO personDAO;

	public static void main(String[] args) {
		SpringApplication.run(DemoPersonApplication.class, args);
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Override
	public void run(String... args) throws Exception {
		personDAO.setJdbcTemplate(jdbcTemplate);
		personDAO.setTransactionTempalte(new TransactionTemplate(transactionManager(dataSource)));
		
		Person person = new Person("Java", "Honk", "John st.","NY", "NY", "USA");
		
		personDAO.insertUser(person);
		
		personDAO.deletePerson(1);
		
		personDAO.selectAllPerson();
		
		personDAO.selectPersonByName();
	}
	
}
