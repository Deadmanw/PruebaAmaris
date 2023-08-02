package com.example.amaris.service;

import com.example.amaris.dto.EmployeeByIdDTO;
import com.example.amaris.dto.EmployeeDataDTO;
import com.example.amaris.dto.EmployeeListDTO;
import com.example.amaris.dto.RequestIdDTO;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

    @Value("${api.dummy.host}")
    String dummyHost;
    @Value("${api.dummy.path.list}")
    String dummyPathList;
    @Value("${api.dummy.path.id}")
    String dummyPathId;
    @Value("${api.dummy.replace}")
    String dummyReplaceId;

    @Override
    public EmployeeListDTO employeeList() {
        EmployeeListDTO response = new EmployeeListDTO();
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<String> entity = new HttpEntity<>("");
            String url = dummyHost + dummyPathList;

            ResponseEntity<EmployeeListDTO> responseList =
                restTemplate.exchange(url, HttpMethod.GET, entity, EmployeeListDTO.class);

            if (responseList.getStatusCode().value() != 200) {
                response.setMessage(responseList.getStatusCode().getReasonPhrase());
                response.setStatus(String.valueOf(responseList.getStatusCode().value()));
            } else {

                for (EmployeeDataDTO employeeData:responseList.getBody().getData()) {
                    annualSalary(employeeData);

                }
                response.setData(responseList.getBody().getData());
                response.setMessage(responseList.getBody().getMessage());
                response.setStatus(responseList.getBody().getStatus());
            }
            System.out.println(response);
            return response;
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return response;
        }
    }

    @Override
    public EmployeeByIdDTO employee(RequestIdDTO id) {
        EmployeeByIdDTO response = new EmployeeByIdDTO();
        try {
            RestTemplate restTemplate = new RestTemplate();
            MultiValueMap<String, String> map = null;
            HttpEntity<String> entity = new HttpEntity<>("", map);

            String url = dummyHost + dummyPathId.replace(dummyReplaceId, String.valueOf(id.getId()));
            ResponseEntity<EmployeeByIdDTO> responseDummy =
                restTemplate.exchange(url, HttpMethod.GET, entity, EmployeeByIdDTO.class);

            if (responseDummy.getStatusCode().value() != 200) {
                response.setMessage(responseDummy.getStatusCode().getReasonPhrase());
                response.setStatus(String.valueOf(responseDummy.getStatusCodeValue()));
            } else {
                annualSalary(responseDummy.getBody().getData());
                
                response.setData(responseDummy.getBody().getData());
                response.setMessage(responseDummy.getBody().getMessage());
                response.setStatus(responseDummy.getBody().getStatus());
            
            }
            System.out.println(response);
            return response;
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return response;
        }
    }

    private EmployeeDataDTO annualSalary(EmployeeDataDTO employeeDataDTO) {
        int annual=employeeDataDTO.getEmployee_salary() * 12;
        employeeDataDTO.setEmployee_annual_salary(annual);
        return employeeDataDTO;
    }
}
