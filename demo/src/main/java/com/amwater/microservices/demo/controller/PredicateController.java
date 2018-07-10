package com.amwater.microservices.demo.controller;

import static com.amwater.microservices.demo.EmployeePredicates.filterEmployeeNames;
import static com.amwater.microservices.demo.EmployeePredicates.filterEmployeeNamesString;
import static com.amwater.microservices.demo.EmployeePredicates.filterEmployees;
import static com.amwater.microservices.demo.EmployeePredicates.isAdultFemale;
import static com.amwater.microservices.demo.EmployeePredicates.isAdultMale;
import static com.amwater.microservices.demo.EmployeePredicates.isAgeMoreThan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amwater.microservices.demo.Employee;

@RestController
public class PredicateController {
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
	
    // A predicate is a functional interface. A function interface contains only one abstract method.
	@GetMapping("/namesStartWithA")
    public String namesStartWithA() {
		List<String> names = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");
		 
		List<String> namesWithA = names.stream()
		  .filter(name -> name.startsWith("A"))
		  .collect(Collectors.toList());
		
        return namesWithA.toString(); 
    }
	
	@GetMapping("/adultMales")
    public List<Employee> adultMales() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));
        
        List<Employee> adultMales = filterEmployees(employees, isAdultMale());
        
        return adultMales; 
    }
	
	@GetMapping("/adultFemales")
    public List<Employee> adultFemales() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));
        
        List<Employee> adultMales = filterEmployees(employees, isAdultFemale());
        
        return adultMales; 
    }
	
	@GetMapping("/olderThan20")
    public List<Employee> olderThan20() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));
        
        List<Employee> adultMales = filterEmployees(employees, isAgeMoreThan(20));
        
        return adultMales; 
    }
	
	@GetMapping("/namesOlderThan20")
    public List<String> namesOlderThan20() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));
        
        List<String> adultMales = filterEmployeeNames(employees, isAgeMoreThan(20));
        
        return adultMales; 
    }
	
	@GetMapping("/namesOlderThan20String")
    public String namesOlderThan20String() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));
        
        String adultMales = filterEmployeeNamesString(employees, isAgeMoreThan(20));
        
        return adultMales; 
    }
}
