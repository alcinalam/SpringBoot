package com.bc2403sb.democalculator;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication

// @SpringBootConfiguration :
// @EnableAutoConfiguration :
// @ComponentScan: before Application starts, 
// 1. scan all java class (under folder on or below the class annotated @SpringBootApplication) 
//    annotated with@Controller,@Service,@Repository,@Configuration
// 2. For example, CalculatorController.java(@Controller). 
//    Then Spring will create an object for CalculatorController.class and put it into the spring context.
// 3. when there is a client call the API defined in CalculatorController.class, spring will use the object 
//    from spring context and then call the instance method.
public class DemoCalculatorApplication {

	private static ApplicationContext context;

	public static ApplicationContext getContext(){
		return context;
	}

	public static void main(String[] args) {
		//SpringApplication.run(DemoCalculatorApplication.class, args);

		DemoCalculatorApplication.context = SpringApplication.run(DemoCalculatorApplication.class, args);
		

		// Definition of Bean in Java:
		// - Simliar to java object.
		// - But bean CANNOT be explicitly created by the object behavior
		// - Spring itself will perform component scan, and then create the bean (java object) into spring
		// - you can just annotate @Controller, @Service, @Repository, @Configuarate to indicate the 

		// String[] beans = springContext.getBeanDefinitionNames();
		// System.out.println(Arrays.toString(beans));

		// chorme jason formatter extention
	}

}
