package com.bankmanagement.bankmanagement.dao.persistentDao;

import com.bankmanagement.bankmanagement.dao.persistentInterfaces.entityPersist.AccountPersist;
import com.bankmanagement.bankmanagement.dao.persistentinit.BankManagementPersistentDao;
import com.bankmanagement.bankmanagement.helper.helper.Merger;
import com.bankmanagement.bankmanagement.helper.status.AccountStatus;
import com.bankmanagement.bankmanagement.model.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class AccountDao implements AccountPersist {
    private final BankManagementPersistentDao bankManagementPersistentDao;
    private final EntityManager entityManager;

    public AccountDao(){
        bankManagementPersistentDao = new BankManagementPersistentDao();
        entityManager = bankManagementPersistentDao.getEntityManager();
    }
    @Override
    public Account add(Account account) {
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        return account;
    }

    @Override
    public Optional<Account> findById(long id) {
        entityManager.getTransaction().begin();
        return Optional.ofNullable(entityManager.find(Account.class, id));
    }

    @Override
    public Account findBy(String columnName, String value) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Account a where " + columnName + " = :value");
        query.setParameter("value", value);
        try {
            return (Account) query.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    @Override
    public Optional<List<Account>> findBy(String columnName, String value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Account a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Account>> findBy(String columnName, long value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Account a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Account>> findBy(String columnName, int value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Account a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Account>> findBy(String columnName, Object value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Account a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Account update(Account account) {
        entityManager.getTransaction().begin();
        Optional<Account> accountToUpdate = findById(account.getId());
        accountToUpdate.ifPresent(value -> Merger.merge(value, account));
        entityManager.getTransaction().commit();
        return accountToUpdate.orElse(null);
    }

    @Override
    public Account delete(Account account) {
        entityManager.getTransaction().begin();
        Optional<Account> accountToDelete =findById(account.getId());
        accountToDelete.ifPresent(value -> value.setAccountStatus(AccountStatus.DELETED));
        entityManager.getTransaction().commit();
        return accountToDelete.orElse(null);
    }

    @Override
    public Account remove(Account account) {
        entityManager.getTransaction().begin();
        entityManager.remove(account);
        entityManager.getTransaction().commit();
        return account;
    }

    @Override
    public Optional<List<Account>> runQuery(String query) {
        entityManager.getTransaction().begin();
        Query query1 =  entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(query1.getResultList());
    }

    @Override
    public Account runQuerySingle(String query) {
        entityManager.getTransaction().begin();
        Query query1 =  entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        try {
            return (Account) query1.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    @Override
    public void close() {
        bankManagementPersistentDao.close();
    }
}
