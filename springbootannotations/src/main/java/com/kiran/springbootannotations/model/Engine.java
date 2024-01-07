package com.kiran.springbootannotations.model;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	public String getV8Engine() {
		return "V8 Engine";
	}

}
