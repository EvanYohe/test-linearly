package com.linearly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {

		// Matrix testMatrixOne = new Matrix(new double[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		// Matrix testMatrixTwo = new Matrix(new double[][] { { 2, 3, 2 }, { 3, 2, 3 }, { 2, 3, 2 } });

		// TODO: Remove before testing in web setting
		// System.exit(1);
		ApplicationContext ctx = SpringApplication.run(MainApplication.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}
