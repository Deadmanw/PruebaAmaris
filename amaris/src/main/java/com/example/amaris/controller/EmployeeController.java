package com.example.amaris.controller;


import com.example.amaris.dto.EmployeeByIdDTO;
import com.example.amaris.dto.EmployeeListDTO;
import com.example.amaris.dto.RequestIdDTO;
import com.example.amaris.service.EmployeeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/employee")
public class EmployeeController {
    EmployeeServiceI employeeServiceI;

    @Autowired
    public EmployeeController(EmployeeServiceI employeeServiceI) {
        this.employeeServiceI = employeeServiceI;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "getEmployeeList",produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeListDTO employeeList(){
        return employeeServiceI.employeeList();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "getEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeByIdDTO employee(@RequestBody RequestIdDTO id) {
        return employeeServiceI.employee(id);
    }
}
