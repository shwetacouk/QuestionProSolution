package com.questionPro.client;

import com.questionPro.model.response.Employee;
import com.questionPro.model.response.EmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ClientTest {
    public static void main(String... arg){
        String uri = "http://dummy.restapiexample.com/api/v1/employees";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EmployeeResponse> response= restTemplate.getForEntity(uri,EmployeeResponse.class);
        EmployeeResponse res = response.getBody();
        Optional<Employee> maxSalEmp =  res.getData().stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getEmployee_salary)));
        System.out.println("Max Salary Emplo: "+maxSalEmp.toString());

    }

}
