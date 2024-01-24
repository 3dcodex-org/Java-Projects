package com.bankmanagement.bankmanagement.dao.persistentinit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@SuppressWarnings("unused")
public class BankManagementPersistentDao {
    private EntityManager entityManager;
    private EntityManagerFactory eMf;

    public BankManagementPersistentDao() {
        this.eMf = Persistence.createEntityManagerFactory("bankManagement_pu");
        this.entityManager = this.eMf.createEntityManager();
    }
    public BankManagementPersistentDao(String persistentUnit){
        this.eMf = Persistence.createEntityManagerFactory(persistentUnit);
        this.entityManager = this.eMf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManagerFactory geteMf() {
        return eMf;
    }

    public void seteMf(EntityManagerFactory eMf) {
        this.eMf = eMf;
    }

    public void close(){
        this.entityManager.close();
        this.eMf.close();
    }
    public void clear(){
        this.entityManager.clear();
    }

}
