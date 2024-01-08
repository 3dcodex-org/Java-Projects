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

@SuppressWarnings({"unchecked", "unused"})
public class AccountDao implements AccountPersist {
    private final BankManagementPersistentDao bankManagementPersistentDao;
    private final EntityManager entityManager;

    public AccountDao(){
        this.bankManagementPersistentDao = new BankManagementPersistentDao();
        this.entityManager = this.bankManagementPersistentDao.getEntityManager();
    }
    public AccountDao(BankManagementPersistentDao bankManagementPersistentDao){
        this.bankManagementPersistentDao = new BankManagementPersistentDao();
        entityManager = this.bankManagementPersistentDao.getEntityManager();
    }
    @Override
    public Account add(Account account) {
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        return account;
    }

    @Override
    public Optional<Account> findById(Long id) {
        entityManager.getTransaction().begin();
        Account account =  entityManager.find(Account.class, id);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(account);
    }

    @Override
    public Optional<Account> findByIdWithin(Long id){
        return Optional.ofNullable(entityManager.find(Account.class, id));
    }

    @Override
    public Account findBy(String columnName, String value) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Account a where " + columnName + " = :value");
        query.setParameter("value", value);
        entityManager.getTransaction().commit();
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
        entityManager.getTransaction().commit();
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Account>> findBy(String columnName, long value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Account a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Account>> findBy(String columnName, int value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Account a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Account>> findBy(String columnName, Object value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Account a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Account update(Account account) {
        entityManager.getTransaction().begin();
        Optional<Account> accountToUpdate = findByIdWithin(account.getId());
        accountToUpdate.ifPresent(value -> Merger.merge(value, account));
        entityManager.getTransaction().commit();
        return accountToUpdate.orElse(null);
    }

    @Override
    public Account delete(Account account) {
        entityManager.getTransaction().begin();
        Optional<Account> accountToDelete =findByIdWithin(account.getId());
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
    public List<Account> findAll() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Account a");
        entityManager.getTransaction().commit();
        return  query.getResultList();
    }

    @Override
    public List<Account> findAllWithRange(int beginIndex, int endIndex) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Account a");
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
