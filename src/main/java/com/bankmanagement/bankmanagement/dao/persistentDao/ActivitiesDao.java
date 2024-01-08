package com.bankmanagement.bankmanagement.dao.persistentDao;

import com.bankmanagement.bankmanagement.dao.persistentInterfaces.entityPersist.ActivitiesPersist;
import com.bankmanagement.bankmanagement.dao.persistentinit.BankManagementPersistentDao;
import com.bankmanagement.bankmanagement.helper.helper.Merger;
import com.bankmanagement.bankmanagement.model.Activities;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

@SuppressWarnings({"unchecked", "unused"})
public class ActivitiesDao implements ActivitiesPersist {
    private final BankManagementPersistentDao bankManagementPersistentDao;
    private final EntityManager entityManager;

    public ActivitiesDao() {
        bankManagementPersistentDao = new BankManagementPersistentDao();
        this.entityManager = this.bankManagementPersistentDao.getEntityManager();
    }

    public ActivitiesDao(BankManagementPersistentDao bankManagementPersistentDao) {
        this.bankManagementPersistentDao = bankManagementPersistentDao;
        this.entityManager = this.bankManagementPersistentDao.getEntityManager();
    }

    @Override
    public Activities add(Activities activities) {
        entityManager.getTransaction().begin();
        entityManager.persist(activities);
        entityManager.getTransaction().commit();
        return activities;
    }

    @Override
    public Optional<Activities> findById(Long id) {
        entityManager.getTransaction().begin();
        Activities activities = entityManager.find(Activities.class, id);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(activities);
    }

    @Override
    public Optional<Activities> findByIdWithin(Long id){
        return Optional.ofNullable(entityManager.find(Activities.class, id));
    }

    @Override
    public Activities findBy(String columnName, String value) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Activities a where " + columnName + " = :value");
        query.setParameter("value", value);
        try {
            return (Activities) query.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    @Override
    public Optional<List<Activities>> findBy(String columnName, String value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Activities a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Activities>> findBy(String columnName, long value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Activities a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Activities>> findBy(String columnName, int value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Activities a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Activities>> findBy(String columnName, Object value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Activities a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Activities update(Activities activities) {
        entityManager.getTransaction().begin();
        Optional<Activities> activitiesToUpdate = findById(activities.getId());
        activitiesToUpdate.ifPresent(value -> Merger.merge(value, activities));
        entityManager.getTransaction().commit();
        return activitiesToUpdate.orElse(null);
    }

    @Override
    public Activities delete(Activities activities) {
        return null;
    }

    @Override
    public Activities remove(Activities activities) {
        entityManager.getTransaction().begin();
        entityManager.remove(activities);
        entityManager.getTransaction().commit();
        return activities;
    }

    @Override
    public Optional<List<Activities>> runQuery(String query) {
        entityManager.getTransaction().begin();
        Query query1 = entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(query1.getResultList());
    }

    @Override
    public Activities runQuerySingle(String query) {
        entityManager.getTransaction().begin();
        Query query1 =  entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        try {
            return (Activities) query1.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    @Override
    public List<Activities> findAll() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Activities a");
        entityManager.getTransaction().commit();
        return  query.getResultList();
    }

    @Override
    public List<Activities> findAllWithRange(int beginIndex, int endIndex) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Activities a");
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
