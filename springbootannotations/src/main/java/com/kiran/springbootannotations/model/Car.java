package com.kiran.springbootannotations.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class Car {
	@Autowired
	Engine engine;
	
	
	@Autowired
	public Car (Engine engine) {
		this.engine = engine;
		System.out.println(" Engine bean injected using Car class constructor "+ engine.getV8Engine());
		
	}
	@Bean
  Engine displayEngine() {
	//engine = new Engine();
	//System.out.println("Engine bean Injected using the @Bean" + engine.getV8Engine() );
	
	return  new Engine();
}
	public Engine getEngine() {
		return engine;
	}
	@Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
		System.out.println(" Engine bean injected using Selector method in Car Class" + engine.getV8Engine());
	}
	
}
