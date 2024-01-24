package com.bankmanagement.bankmanagement.service.serviceClass;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.bankmanagement.bankmanagement.dao.persistentDao.EmployeeDao;
import com.bankmanagement.bankmanagement.service.session.sessionClass.EmployeeSession;
import com.bankmanagement.bankmanagement.model.Employee;
import com.bankmanagement.bankmanagement.service.serviceInterface.UserManager;


public class LoginService implements UserManager<Employee> {
    private final EmployeeDao employeeDao;

    public LoginService(){
        this.employeeDao = new EmployeeDao();
    }
    public LoginService(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee login(String username, String password) {
        String encryptedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        System.out.println(encryptedPassword);
        String query = "SELECT e FROM Employee e WHERE username = '" + username + "'";
        Employee employee =  employeeDao.runQuerySingle(query);
        if(employee == null || !BCrypt.verifyer().verify(password.toCharArray(),
                employee.getPassword()).verified) return null;
        EmployeeSession.getInstace(employee);
        return employee;
    }

    @Override
    public boolean isAuthorized(Employee employee) {
        return false;
    }

    @Override
    public boolean isAuthenticated(Employee employee) {
        return false;
    }


}
