package a.b.person;

import java.sql.Types;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
public class PersonDAO implements IPersonDAO {
	private JdbcTemplate jdbcTemplate;
	private TransactionTemplate transactionTemplate;
	private PlatformTransactionManager txManager;
	
	public void setTransactionManager (PlatformTransactionManager transactionManager) {
		this.txManager = transactionManager;
	}

	@Override
	//TransactionManager를 이용하여 구현하기
	public int insertUse2(final Person person) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		def.setTimeout(10);
		TransactionStatus status = txManager.getTransaction(def);
		
		try {
			int value = 0;
			for(int i=0; i<3; i++) {
				String insertQuery = "insert into person(first_name, last_name, street_name, city, state, country)"
						+" values(?, ?, ?, ?, ?, ?)";
				Object[] params = new Object[] { 
						person.getFirstName(),
						person.getLastName(),
						person.getStreet(),
						person.getCity(),
						person.getState(),
						person.getCountry() };
				int[] types = new int[] {
						Types.VARCHAR,
						Types.VARCHAR,
						Types.VARCHAR,
						Types.VARCHAR,
						Types.VARCHAR,
						Types.VARCHAR };
				value += jdbcTemplate.update(insertQuery, params, types);
			}
			System.out.println("\nPerson inserted to the table :: " + value);
			txManager.commit(status);
			return value;
			
		} catch (DataAccessException e) {
			txManager.rollback(status);
		}
		
		return 0;
	}

	@Override
	public int insertUser(final Person person) {
		return transactionTemplate.execute(new TransactionCallback<Integer>() {

			@Override
			public Integer doInTransaction(TransactionStatus transactionStatus) {
				try {
					int value = 0;
					for(int i=0; i<3; i++) {
						String insertQuery = "insert into person(first_name, last_name, street_name, city, state, country)"
								+" values(?, ?, ?, ?, ?, ?)";
						Object[] params = new Object[] { 
								person.getFirstName(),
								person.getLastName(),
								person.getStreet(),
								person.getCity(),
								person.getState(),
								person.getCountry() };
						int[] types = new int[] {
								Types.VARCHAR,
								Types.VARCHAR,
								Types.VARCHAR,
								Types.VARCHAR,
								Types.VARCHAR,
								Types.VARCHAR };
						value += jdbcTemplate.update(insertQuery, params, types);
					}
					
					System.out.println("\nPerson inserted to the table :: " + value);
					
					return value;
					
				} catch (Exception e) {
					transactionStatus.setRollbackOnly();
				}
				
				return 0;
			}
			
		});
	
	}

	@Override
	public void deletePerson(int personID) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				try {
					String deletePerson = "delete from person where id=?";
					Object[] params = new Object[] { personID };
					int[] types = new int[] { Types.VARCHAR };
					jdbcTemplate.update(deletePerson, params, types);
					System.out.println("\nPerson with id 1 deleted from the table\n");
				} catch (Exception e) {
					transactionStatus.setRollbackOnly();
				}
			}
		});
	}

	@Override
	public void selectAllPerson() {
		System.out.println("\nList of person in the table\n");
		
		String selectAllPerson = "select * from person";
		List<Map<String, Object>> listOfPerson = jdbcTemplate.queryForList(selectAllPerson);
		for(Iterator<Map<String, Object>> iterator = listOfPerson.iterator(); iterator.hasNext(); ) {
			Map<String, Object>map = (Map<String, Object>)iterator.next();
			System.out.println(map);
		}
		System.out.println();
	}

	@Override
	public void selectPersonByName() {
		System.out.println("\nLists of person name Java in the table\n");
		
		String selectAllPerson = "select * from person where first_name = 'Java'";
		List<Map<String, Object>> listOfPerson = jdbcTemplate.queryForList(selectAllPerson);
		for(Iterator<Map<String, Object>> iterator = listOfPerson.iterator(); iterator.hasNext(); ) {
			Map<String, Object>map = (Map<String, Object>)iterator.next();
			System.out.println(map);
		}
		System.out.println();
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}
	
	public void setTransactionTempalte(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

}
