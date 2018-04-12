package jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jdbc.domain.Emp;
import jdbc.repository.EmpRepository;

@SpringBootApplication
public class Jdbc2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Jdbc2Application.class, args);
	}
	
	@Autowired
	EmpRepository empRepository;

	@Override
	public void run(String... arg){
		//전체 사원 SELECT
		List<Emp> emps = empRepository.findAll();
		for(Emp e:emps) {
			System.out.println(e);
		}
		System.out.println("--------------------");
		
		//2번 사원 SEELCT
		Emp e = empRepository.findOne(2L);
		System.out.println(e);
		System.out.println("--------------------");
		
		//3번 사원 DELETE
		empRepository.delete(3L);
		emps = empRepository.findAll();
		for(Emp e1:emps) {
			System.out.println(e1);
		}
		System.out.println("--------------------");
		
		//4번 사원 INSERT
		e = empRepository.save(new Emp(4L, "4길동"));
		emps = empRepository.findAll();
		for(Emp e1:emps) {
			System.out.println(e1);
		}
		System.out.println("--------------------");
		
		//'5길동' 사원 INSERT
		Emp e5 = new Emp("5길동");
		e = empRepository.save(e5);
		emps = empRepository.findAll();
		for(Emp e1:emps) {
			System.out.println(e1);
		}
	}
}
