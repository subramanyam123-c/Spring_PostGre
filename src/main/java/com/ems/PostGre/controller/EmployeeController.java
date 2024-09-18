package com.ems.PostGre.controller;

import com.ems.PostGre.dto.EmployeeDto;
import com.ems.PostGre.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @Operation(hidden = true)
    @RequestMapping
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
    @PostMapping
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmp = service.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }
    @GetMapping("{empId}")
    public ResponseEntity<EmployeeDto> getEmpBYiD(@PathVariable Long empId){
        EmployeeDto emp = service.getEmployeeById(empId);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmp(){
        List<EmployeeDto> list = service.getAllEmp();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmp(@PathVariable Long id,@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = service.updateEmp(id,employeeDto);
        return new ResponseEntity<>(employeeDto1,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable Long id){
        service.deleteEmp(id);
        return new ResponseEntity<>("Deleted",HttpStatus.FOUND);
    }

}
