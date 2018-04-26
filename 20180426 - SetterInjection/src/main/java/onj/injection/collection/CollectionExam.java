package onj.injection.collection;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionExam {
	private Map<String, Object> map;
	private Properties props;
	private Set<Object> set;

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public void setSet(Set<Object> set) {
		this.set = set;
	}

	public void display() {
		for(Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + "-" + entry.getValue());
		}
		
		for(Map.Entry<Object, Object> entry1 : props.entrySet()) {
			System.out.println("Key : " + entry1.getKey() + "-" + entry1.getValue());
		}
		
		for(Object obj : set) {
			System.out.println("value : " + obj);
		}
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context5.xml");
		ctx.refresh();
		
		CollectionExam col = (CollectionExam)ctx.getBean("sample");
		col.display();
	}

}
