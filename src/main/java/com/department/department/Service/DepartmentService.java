package com.department.department.Service;

import com.department.department.Entity.Department;
import com.department.department.Exception.BadRequestException;
import com.department.department.Repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside the Service class saveDepartment method");
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long departmentId) throws BadRequestException{
        log.info("Inside the Service class getDepartmentById method");
        Department department= departmentRepository.findByDepartmentId(departmentId);
        if(department==null){
            String message = "No Department Found";
            throw new BadRequestException(message);
        }
        return  department;

    }

    public List<Department> getAllDepartments(){
        log.info("Inside the Service class getAllDepartments method");
        return departmentRepository.findAll();
    }

    public void deleteDepartment(Long departmentId) throws BadRequestException {
        log.info("Inside the Service class deleteDepartment method");
        departmentRepository.delete(this.getDepartmentById(departmentId));
    }

    public void updateDepartment(Department department, Long departmentId) throws BadRequestException {
        Department department1= this.getDepartmentById(departmentId);
        department.setDepartmentId(department1.getDepartmentId());
        departmentRepository.save(department);
    }
}
