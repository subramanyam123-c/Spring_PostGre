package com.ems.PostGre.service;

import com.ems.PostGre.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long empId);
    List<EmployeeDto> getAllEmp();

    EmployeeDto updateEmp(Long id, EmployeeDto employeeDto);

    void deleteEmp(Long id);
}
