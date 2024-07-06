package org.emp.employeeController;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.entity.EmployeeEntity;
import org.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp-controller")
@RequiredArgsConstructor
//http://localhost:8080/emp-controller/add-employee
public class EmployeeController {


    final EmployeeService employeeService;

    @PostMapping("add-employee")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }
    @GetMapping("get-all")
    public List<EmployeeEntity> getAll(){

        return employeeService.getAll();
    }
}