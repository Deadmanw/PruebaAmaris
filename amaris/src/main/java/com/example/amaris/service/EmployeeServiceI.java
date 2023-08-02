package com.example.amaris.service;

import com.example.amaris.dto.EmployeeByIdDTO;
import com.example.amaris.dto.EmployeeListDTO;
import com.example.amaris.dto.RequestIdDTO;

public interface EmployeeServiceI {

    EmployeeListDTO employeeList();
    EmployeeByIdDTO employee(RequestIdDTO id);
}
