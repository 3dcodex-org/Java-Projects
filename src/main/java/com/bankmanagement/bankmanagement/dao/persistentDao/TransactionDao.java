package com.bankmanagement.bankmanagement.dao.persistentDao;

import com.bankmanagement.bankmanagement.dao.persistentInterfaces.entityPersist.TransactionPersist;
import com.bankmanagement.bankmanagement.dao.persistentinit.BankManagementPersistentDao;
import com.bankmanagement.bankmanagement.helper.helper.Merger;
import com.bankmanagement.bankmanagement.model.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

public class TransactionDao implements TransactionPersist {
    private final BankManagementPersistentDao bankManagementPersistentDao;
    private final EntityManager entityManager;

    public TransactionDao(){
        bankManagementPersistentDao = new BankManagementPersistentDao();
        this.entityManager = this.bankManagementPersistentDao.getEntityManager();
    }

    public TransactionDao(BankManagementPersistentDao bankManagementPersistentDao) {
        this.bankManagementPersistentDao = bankManagementPersistentDao;
        this.entityManager = this.bankManagementPersistentDao.getEntityManager();
    }

    @Override
    public Transaction add(Transaction transaction) {
        entityManager.getTransaction().begin();
        entityManager.persist(transaction);
        entityManager.getTransaction().commit();
        return transaction;
    }

    @Override
    public Optional<Transaction> findById(long id) {
        entityManager.getTransaction().begin();
        return Optional.ofNullable(entityManager.find(Transaction.class, id));
    }

    @Override
    public Transaction findBy(String columnName, String value) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Transaction a where " + columnName + " = :value");
        query.setParameter("value", value);
        try {
            return (Transaction) query.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    @Override
    public Optional<List<Transaction>> findBy(String columnName, String value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Transaction a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Transaction>> findBy(String columnName, long value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Transaction a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Transaction>> findBy(String columnName, int value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Transaction a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Transaction>> findBy(String columnName, Object value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Transaction a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Transaction update(Transaction transaction) {
        entityManager.getTransaction().begin();
        Optional<Transaction> transactionToUpdate = findById(transaction.getId());
        transactionToUpdate.ifPresent(value -> Merger.merge(value, transaction));
        entityManager.getTransaction().commit();
        return transactionToUpdate.orElse(null);
    }

    @Override
    public Transaction delete(Transaction transaction) {
        return null;
    }

    @Override
    public Transaction remove(Transaction transaction) {
        entityManager.getTransaction().begin();
        entityManager.remove(transaction);
        entityManager.getTransaction().commit();
        return transaction;
    }

    @Override
    public Optional<List<Transaction>> runQuery(String query) {
        entityManager.getTransaction().begin();
        Query query1 =  entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(query1.getResultList());
    }

    @Override
    public Transaction runQuerySingle(String query) {
        entityManager.getTransaction().begin();
        Query query1 =  entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        try {
            return (Transaction) query1.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    @Override
    public void close() {
        bankManagementPersistentDao.close();
    }
}
