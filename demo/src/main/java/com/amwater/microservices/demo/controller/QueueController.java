package com.amwater.microservices.demo.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amwater.microservices.demo.Employee;

@RestController
public class QueueController {
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

    @GetMapping("/queue")
    public List<Employee> sortEmployeeByAge() {
    	Queue<Employee> q = new LinkedList<>();
    	
    	q.add(e1);
    	q.add(e2);
    	q.add(e3);
    	q.add(e4);
    	q.add(e5);
    	q.add(e6);
    	q.add(e7);
    	q.add(e8);
    	q.add(e9);
    	q.add(e10);

    	Employee e;
    	List<Employee> employeeList = new ArrayList<>();
    	
    	while (true) {
    		e = q.poll();
    		
    		if (e != null) {
    			employeeList.add(e);
    		} else {
    			break;
    		}
    	}
    	
        return employeeList;
    }  

    @GetMapping("/stack")
    public List<Employee> stack() {
    	Stack<Employee> s = new Stack<>();

    	s.push(e1);
    	s.push(e2);
    	s.push(e3);
    	s.push(e4);
    	s.push(e5);
    	s.push(e6);
    	s.push(e7);
    	s.push(e8);
    	s.push(e9);
    	s.push(e10);

    	Employee e;
    	List<Employee> employeeList = new ArrayList<>();
    	
    	while (true) {
    		try {
				e = s.pop();
				employeeList.add(e);
			} catch (Exception e11) {
				break;
			}
    	}
    	
        return employeeList;
    }  
}  