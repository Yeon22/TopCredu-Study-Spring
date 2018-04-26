package onj.collection.annotation;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("sample")
public class CollectionAnnotationExam {
	@Resource(name = "map")
	private Map<String, Object> map;
	
	@Resource(name = "props")
	private Properties props;
	
	@Resource(name = "set")
	private Set<Object> set;
	
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
		ctx.load("classpath:app-context6.xml");
		ctx.refresh();
		
		CollectionAnnotationExam colano = (CollectionAnnotationExam)ctx.getBean("sample");
		colano.display();
	}

}
