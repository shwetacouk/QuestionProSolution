package com.questionPro.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {
    private int id;
    private String employee_name;
    private int employee_salary;
    private String employee_age;
    private String profile_image;

}
