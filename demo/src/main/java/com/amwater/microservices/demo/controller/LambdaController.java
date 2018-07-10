package com.amwater.microservices.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amwater.microservices.demo.Employee;

@RestController
public class LambdaController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
    Employee e2 = new Employee(2,13,"F","Martina","Hengis");
    Employee e3 = new Employee(3,43,"M","Ricky","Martin");
    Employee e4 = new Employee(4,26,"M","Jon","Lowman");
    Employee e5 = new Employee(5,19,"F","Cristine","Maria");
    Employee e6 = new Employee(6,15,"M","Aaron","Feezor");
    Employee e7 = new Employee(7,68,"F","Melissa","Roy");
    Employee e8 = new Employee(8,79,"M","Alex","Gussin");
    Employee e9 = new Employee(9,15,"F","Neetu","Singh");
    Employee e10 = new Employee(10,45,"M","Naveen","Jain");

    // Lambdas are basically passing functionality as a method argument or code as data
    @GetMapping("/sortEmployeeByAge")
    public List<Employee> sortEmployeeByAge() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));
          
        // implementing lambda expression - sort by age  
        Collections.sort(employees, (p1,p2) -> {  
        	return p1.getAge().compareTo(p2.getAge());  
        });  
        
        return employees;
    }  
}  