package com.harry.reactspring.service.imp;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.harry.reactspring.dto.EmployeeDto;
import com.harry.reactspring.entity.Employee;
import com.harry.reactspring.exception.ResourceNotFoundException;
import com.harry.reactspring.mapper.EmployeeMapper;
import com.harry.reactspring.repository.EmployeeRepository;
import com.harry.reactspring.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {
    
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee =employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee with given id does not exist : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List <Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper
        .mapToEmployeeDto(employee))
        .collect(Collectors.toList());
    }
    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
       Employee employee =  employeeRepository.findById(employeeId)
        .orElseThrow(()-> new ResourceNotFoundException("Employee not found with this id"));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }
    
    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee =  employeeRepository.findById(employeeId)
        .orElseThrow(()-> new ResourceNotFoundException("Employee not found with this id"));
        
        employeeRepository.deleteById(employeeId);
    
    }
    
}
