package com.zaurtregulov.spring.rest;

import com.zaurtregulov.spring.rest.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//при помощи этого класса осуществляется общение с сервером (http запросы и ответы)
@Component
public class Communication {

  @Autowired
  private RestTemplate restTemplate;
  private final String URL = "http://localhost:8080/spring_course_rest/api/employees";

  public List<Employee> getAllEmployees() {

    //при помощи следующего кода отправляется request, ответ приходит в переменную responseEntity
    //третий параметр - что мы хотим добавить к телу http request
    //четвертый параметр - вспомогательный класс передающий дженерик тип
    ResponseEntity<List<Employee>> responseEntity =
        restTemplate.exchange(URL, HttpMethod.GET, null
            , new ParameterizedTypeReference<List<Employee>>() {
            });

    //получение полезной нагрузки
    List<Employee> employees = responseEntity.getBody();
    return employees;
  }

  public Employee getEmployee(int id) {

    Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
    return employee;
  }

  public void saveEmployee(Employee employee) {
    int id = employee.getId();

    if (id == 0) {
      //в response будет возвращаться json, поэтому тип String
      ResponseEntity<String> responseEntity =
          restTemplate.postForEntity(URL, employee, String.class);
      System.out.println("New employee was added to DB");
      System.out.println(responseEntity.getBody());
    } else {
      restTemplate.put(URL, employee);
      System.out.println("Employee with id " + id + " was updated");
    }
  }

  public void deleteEmployee(int id) {
    restTemplate.delete(URL + "/" + id);
    System.out.println("Employee with id " + id + " was deleted from DB");
  }
}
