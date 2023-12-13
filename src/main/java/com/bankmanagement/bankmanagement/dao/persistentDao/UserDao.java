package com.bankmanagement.bankmanagement.dao.persistentDao;

import com.bankmanagement.bankmanagement.dao.persistentInterfaces.entityPersist.UserPersist;
import com.bankmanagement.bankmanagement.dao.persistentinit.BankManagementPersistentDao;
import com.bankmanagement.bankmanagement.helper.helper.Merger;
import com.bankmanagement.bankmanagement.helper.status.UserStatus;
import com.bankmanagement.bankmanagement.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class UserDao implements UserPersist {
    private final BankManagementPersistentDao bankManagementPersistentDao;
    private final EntityManager entityManager;

    public UserDao() {
        bankManagementPersistentDao = new BankManagementPersistentDao();
        this.entityManager = bankManagementPersistentDao.getEntityManager();
    }


    @Override
    public User add(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public Optional<User> findById(long id) {
        entityManager.getTransaction().begin();
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public User findBy(String columnName, String value) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT u FROM users u WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        try {
            return (User) query.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    @Override
    public Optional<List<User>> findBy(String columnName, String value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT u FROM users u WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<User>> findBy(String columnName, long value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT u FROM users u WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<User>> findBy(String columnName, int value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT u FROM users u WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<User>> findBy(String columnName, Object value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT u FROM users u WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public User update(User user) {
        entityManager.getTransaction().begin();
        Optional<User> userToUpdate = findById(user.getId());
        userToUpdate.ifPresent(value -> Merger.merge(value, user));
        entityManager.getTransaction().commit();
        return userToUpdate.orElse(null);
    }

    @Override
    public User delete(User user) {
        entityManager.getTransaction().begin();
        Optional<User> userToDelete = findById(user.getId());
        userToDelete.ifPresent(value -> value.setStatus(UserStatus.DELETED));
        entityManager.getTransaction().commit();
        return userToDelete.orElse(null);
    }

    @Override
    public User remove(User user) {
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public Optional<List<User>> runQuery(String query) {
        entityManager.getTransaction().begin();
        Query query1 = entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(query1.getResultList());
    }

    @Override
    public User runQuerySingle(String query) {
        entityManager.getTransaction().begin();
        Query query1 =  entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        try {
            return (User) query1.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    public void close(){
        bankManagementPersistentDao.close();
    }

}
