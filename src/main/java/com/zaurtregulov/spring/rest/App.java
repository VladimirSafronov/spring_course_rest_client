package com.zaurtregulov.spring.rest;

import com.zaurtregulov.spring.rest.configuration.MyConfig;
import com.zaurtregulov.spring.rest.entity.Employee;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

//        List<Employee> employees = communication.getAllEmployees();
//        System.out.println(employees);

//        Employee empById = communication.getEmployee(5);
//        System.out.println(empById);

//        Employee emp = new Employee("Sveta", "Sokolova", "IT", 1900);
//        emp.setId(13);
//        communication.saveEmployee(emp);

        communication.deleteEmployee(13);
    }
}
