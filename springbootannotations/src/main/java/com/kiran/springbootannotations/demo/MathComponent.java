package com.kiran.springbootannotations.demo;

import org.springframework.stereotype.Component;

@Component
public class MathComponent {
	public int add(int x, int y) {
		return  x + y ;
	}
	

}
