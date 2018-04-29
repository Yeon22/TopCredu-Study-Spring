package com.mkyong.examples.spring;

import org.springframework.stereotype.Service;

@Service("ml")
public class MachineLearningService implements DataModelSevice {

	public boolean isValid(String input) {
		return true;
	}

}
