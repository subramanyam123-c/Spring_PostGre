package com.ems.PostGre.service;

import com.ems.PostGre.dto.EmployeeDto;
import com.ems.PostGre.entity.Employee;
import com.ems.PostGre.exception.ResourceNotFounException;
import com.ems.PostGre.mapper.EmployeeMapper;
import com.ems.PostGre.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository repo;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee emp =  repo.save(EmployeeMapper.mapToEmployee(employeeDto));
        return EmployeeMapper.mapToEmployeeDto(emp);
    }

    @Override
    public EmployeeDto getEmployeeById(Long empId) {
        Employee emp = repo.findById(empId)
                .orElseThrow(()->new ResourceNotFounException("Employee not found with give id"+ empId));
        return EmployeeMapper.mapToEmployeeDto(emp);
    }

    @Override
    public List<EmployeeDto> getAllEmp() {
        List<Employee> employees = repo.findAll();
     return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmp(Long id, EmployeeDto employeeDto) {
        Employee emp = repo.findById(id)
                .orElseThrow(()->new ResourceNotFounException("Employee not found with give id"+ id));
        emp.setFirstName(employeeDto.getFirstName());
        emp.setLastName(employeeDto.getLastName());
        emp.setEmail(employeeDto.getEmail());
        Employee updatedEmp = repo.save(emp);
        return EmployeeMapper.mapToEmployeeDto(updatedEmp);
    }

    @Override
    public void deleteEmp(Long id) {
            repo.deleteById(id);
    }

}
