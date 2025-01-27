package org.emp.controller;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp-controller")
@RequiredArgsConstructor
@CrossOrigin
//http://localhost:8080/emp-controller/add-employee
public class EmployeeController {


    final EmployeeService employeeService;

    @PostMapping("add-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee){

        employeeService.addEmployee(employee);
    }

    @GetMapping("get-all")
    public List<Employee> getAll(){

        return employeeService.getAll();
    }

    @DeleteMapping("/delete-emp/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return "Deleted";
    }

    @PutMapping("/update-employee")
    public void updateEmployee(@RequestBody Employee employee){

        employeeService.updateEmployee(employee);
    }

    @GetMapping("/find-by-id/{id}")
    public Employee findById(@PathVariable Long id){

        return employeeService.findById(id);
    }

    @GetMapping("/find-by-firstName/{firstName}")
    public Employee findbyFirstName(@PathVariable String firstName){
        return employeeService.findByFirstName(firstName);
    }
}
