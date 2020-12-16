package com.questionPro.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeResponse {
    private List<Employee> data;
}
