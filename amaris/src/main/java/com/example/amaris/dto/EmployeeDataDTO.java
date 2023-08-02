package com.example.amaris.dto;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDataDTO {
    private int id;
    private String employee_name;
    private int employee_salary;
    private int employee_age;
    private String profile_image;

    private int employee_annual_salary;
}
