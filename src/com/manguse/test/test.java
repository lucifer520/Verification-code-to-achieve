package com.manguse.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	@Test
	public void StringBuildertest() {
		StringBuilder sb=new StringBuilder();
		StringBuffer sb1=new StringBuffer();
		char ch='s';
		for(int i=0;i<10;i++){
			sb.append(ch);
			sb1.append(ch);
			
		}
		System.out.println(sb.toString());
		System.out.println(sb);
		System.out.println(sb1.toString());
		System.out.println(sb1);
		
	}

}
