package com.bankmanagement.bankmanagement.dao.persistentDao;

import com.bankmanagement.bankmanagement.dao.persistentInterfaces.entityPersist.EmployeePersist;
import com.bankmanagement.bankmanagement.dao.persistentinit.BankManagementPersistentDao;
import com.bankmanagement.bankmanagement.helper.helper.Merger;
import com.bankmanagement.bankmanagement.helper.status.UserStatus;
import com.bankmanagement.bankmanagement.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

@SuppressWarnings({"unchecked","unused"})
public class EmployeeDao implements EmployeePersist {
    private final BankManagementPersistentDao bankManagementPersistentDao;
    private final EntityManager entityManager;

    public EmployeeDao(){
        this.bankManagementPersistentDao = new BankManagementPersistentDao();
        this.entityManager = this.bankManagementPersistentDao.getEntityManager();
    }

    public EmployeeDao(BankManagementPersistentDao bankManagementPersistentDao) {
        this.bankManagementPersistentDao = bankManagementPersistentDao;
        this.entityManager = this.bankManagementPersistentDao.getEntityManager();
    }


    @Override
    public Employee add(Employee employee) {

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        return employee;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(employee);
    }

    @Override
    public Optional<Employee> findByIdWithin(Long id){
        return Optional.ofNullable(entityManager.find(Employee.class, id));
    }

    @Override
    public Employee findBy(String columnName, String value) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT e FROM employee e WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        try {
            return (Employee) query.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    public Optional<List<Employee>> findBy(String columnName, String value, int resultMax) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Employee>> findBy(String columnName, long value, int resultMax) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE " + columnName + " = :value" + ((resultMax > 0 )?" LIMIT " + resultMax:""));
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Employee>> findBy(String columnName, int value, int resultMax) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Employee>> findBy(String columnName, Object value, int resultMax) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Employee update(Employee employee) {
        entityManager.getTransaction().begin();
        Optional<Employee> employeeToUpdate = findByIdWithin(employee.getId());
        employeeToUpdate.ifPresent(value -> Merger.merge(value, employee));
        entityManager.getTransaction().commit();
        return employeeToUpdate.orElse(null);
    }

    @Override
    public Employee delete(Employee employee) {
        entityManager.getTransaction().begin();
        Optional<Employee> employeeToDelete =findByIdWithin(employee.getId());
        employeeToDelete.ifPresent(value -> value.setStatus(UserStatus.DELETED));
        entityManager.getTransaction().commit();
        return employeeToDelete.orElse(null);
    }

    @Override
    public Employee remove(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
        return employee;
    }

    @Override
    public Optional<List<Employee>> runQuery(String query) {
        entityManager.getTransaction().begin();
        Query query1 =  entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(query1.getResultList());
    }

    @Override
    public Employee runQuerySingle(String query) {
        entityManager.getTransaction().begin();
        Query query1 =  entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        try {
            return (Employee) query1.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    @Override
    public List<Employee> findAll() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select e from Employee e");
        entityManager.getTransaction().commit();
        return  query.getResultList();
    }

    @Override
    public List<Employee> findAllWithRange(int beginIndex, int endIndex) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select e from Employee e");
        entityManager.getTransaction().commit();
        return  query.getResultList().subList(beginIndex, endIndex);
    }

    @Override
    public void close() {
        bankManagementPersistentDao.close();
    }

    @Override
    public void clear() {
        bankManagementPersistentDao.clear();
    }

}
