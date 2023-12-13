package com.bankmanagement.bankmanagement.service.serviceClass;


import com.bankmanagement.bankmanagement.dao.persistentDao.EmployeeDao;
import com.bankmanagement.bankmanagement.model.Employee;

public class SignupService {
    private EmployeeDao employeeDao;

    public SignupService(){}
    public SignupService(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    /**
     *
     * @param employee the employee you want insert into the database
     * @return the employee data created in the database
     */
    public Employee createAccount(Employee employee){
        return employeeDao.add(employee);
    }

    /**
     *
     * @param username string that you want to filter by
     * @return employee object if present and null if absent
     */
    public Employee findByUsername(String username){
        return employeeDao.findBy("username", username);
    }

    /**
     *
     * @param email email address that you wish to filter by
     * @return employee object if present and null if absent
     */
    public Employee findByEmail(String email){
        return employeeDao.findBy("email", email);
    }
}
