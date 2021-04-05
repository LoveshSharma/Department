package com.department.department.Controller;

import com.department.department.Entity.Department;
import com.department.department.Exception.BadRequestException;
import com.department.department.Service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;



@PostMapping("/")
public Department saveDepartment(@RequestBody Department department){
log.info("Inside the saveDepartment method in Controller");
    return departmentService.saveDepartment(department);
}

@GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId) throws BadRequestException {
    log.info("Inside the getDepartment method in Controller");
    return departmentService.getDepartmentById(departmentId);
}
    @GetMapping("/")
    public List<Department> getAllDepartments(){
        log.info("Inside the getDepartment method in Controller");
        return departmentService.getAllDepartments();
    }
    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable("id") Long departmentId) throws BadRequestException {
        log.info("Inside the deleteDepartmentById method in Controller");
     departmentService.deleteDepartment(departmentId);
    }
    @PatchMapping("/{id}")
    public void updateDepartmentName(@RequestBody Department department, @PathVariable("id") Long departmentId) throws BadRequestException {
        log.info("Inside the updateDepartmentName method in Controller");
     departmentService.updateDepartment(department, departmentId);
    }
}
