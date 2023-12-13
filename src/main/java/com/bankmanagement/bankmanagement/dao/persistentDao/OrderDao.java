package com.bankmanagement.bankmanagement.dao.persistentDao;

import com.bankmanagement.bankmanagement.dao.persistentInterfaces.entityPersist.OrderPersist;
import com.bankmanagement.bankmanagement.dao.persistentinit.BankManagementPersistentDao;
import com.bankmanagement.bankmanagement.helper.helper.Merger;
import com.bankmanagement.bankmanagement.helper.status.OrderStatus;
import com.bankmanagement.bankmanagement.model.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class OrderDao implements OrderPersist {
    private final EntityManager entityManager;
    private final BankManagementPersistentDao bankManagementPersistentDao;
    public OrderDao(){
        bankManagementPersistentDao = new BankManagementPersistentDao();
        entityManager = bankManagementPersistentDao.getEntityManager();
    }
    @Override
    public Order add(Order order) {
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        return order;
    }

    @Override
    public Optional<Order> findById(long id) {
        entityManager.getTransaction().begin();
        return Optional.ofNullable(entityManager.find(Order.class, id));
    }

    @Override
    public Order findBy(String columnName, String value) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT o FROM orders o WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        try {
            return (Order) query.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    @Override
    public Optional<List<Order>> findBy(String columnName, String value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT o FROM orders o WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0 ) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Order>> findBy(String columnName, long value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT o FROM orders o WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0 ) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Order>> findBy(String columnName, int value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT o FROM orders o WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0 ) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Order>> findBy(String columnName, Object value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT o FROM orders o WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0 ) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Order update(Order order) {
        entityManager.getTransaction().begin();
        Optional<Order> orderToUpdate = findById(order.getId());
        orderToUpdate.ifPresent(value -> Merger.merge(value, order));
        entityManager.getTransaction().commit();
        return orderToUpdate.orElse(null);
    }

    @Override
    public Order delete(Order order) {
        entityManager.getTransaction().begin();
        Optional<Order> orderToDelete = findById(order.getId());
        orderToDelete.ifPresent(value -> value.setOrderStatus(OrderStatus.DELETED));
        entityManager.getTransaction().commit();
        return orderToDelete.orElse(null);
    }

    @Override
    public Order remove(Order order) {
        entityManager.getTransaction().begin();
        entityManager.remove(order);
        entityManager.getTransaction().commit();
        return order;
    }

    @Override
    public Optional<List<Order>> runQuery(String query) {
        entityManager.getTransaction().begin();
        Query query1 = entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(query1.getResultList());
    }

    @Override
    public Order runQuerySingle(String query) {
        entityManager.getTransaction().begin();
        Query query1 =  entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        try {
            return (Order) query1.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    @Override
    public void close() {
        bankManagementPersistentDao.close();
    }
}
