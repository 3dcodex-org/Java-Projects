package com.bankmanagement.bankmanagement.dao.persistentInterfaces.persistentUnit;

import java.util.List;
import java.util.Optional;

/**
 *
 * @param <T> The class that implements this interface
 */
@SuppressWarnings("unused")
public interface BankManagementPersistentUnit<T> {
    /**
     *
     * @param t object type to be persisted to the database
     * @return the object being persisted to the database
     */
    T add(T t);

    /**
     *
     * @param id integer value denoting the unique identification of the record in the table in the database
     * @return the complete row associated with the id entered the database
     */
    Optional<T>findById(Long id);

    Optional<T> findByIdWithin(Long id);

    /**
     *
     * @param columnName name of column you want to filter your search by, e.g., name, age, DoB
     * @param value String value of the actual information you want to filter for
     * @return returns a single record from the table in the database
     */
    T findBy(String columnName, String value);

    /**
     *
     * @param columnName name of column you want to filter your search by, e.g., name, age, DoB
     * @param value String value of the actual information you want to filter for
     * @param resultMax The maximum number of result you want to retrieve from the database. set to zero (0) to return all results found
     * @return returns a list of object in the database of the Class
     */
    Optional<List<T>> findBy(String columnName, String value, int resultMax);
    /**
     *
     * @param columnName name of column you want to filter your search by, e.g., name, age, DoB
     * @param value Long value of the actual information you want to filter for
     * @param resultMax The maximum number of result you want to retrieve from the database. set to zero (0) to return all results found
     * @return returns a list of object in the database of the Class
     */
    Optional<List<T>>findBy(String columnName, long value, int resultMax);
    /**
     *
     * @param columnName name of column you want to filter your search by, e.g., name, age, DoB
     * @param value Integer value of the actual information you want to filter for
     * @param resultMax The maximum number of result you want to retrieve from the database. set to zero (0) to return all results found
     * @return returns a list of object in the database of the Class
     */
    Optional<List<T>>findBy(String columnName, int value, int resultMax);
    /**
     *
     * @param columnName name of column you want to filter your search by, e.g., name, age, DoB
     * @param value Object value of the actual information you want to filter for
     * @param resultMax The maximum number of result you want to retrieve from the database. set to zero (0) to return all results found
     * @return returns a list of object in the database of the Class
     */
    Optional<List<T>>findBy(String columnName, Object value, int resultMax);

    /**
     *
     * @param t populated object to be updated
     * @return object in the database that has been updated of class Type
     */
    T update(T t);

    /**
     *
     * @param t the object to be deleted from the database
     * @return returns the object that has been deleted in the database
     *
     *@apiNote this function does not remove the row in the database table but rather changes the status so that it is marked as deleted. to completely remove the row, please use the remove() function
     */
    T delete(T t);

    /**
     *
     * @param t the object to be deleted from the database
     * @return returns the object that has been deleted
     * @apiNote completely remove the row of from the database
     */
    T remove(T t);

    /**
     *
     * @param query query to  be executed e.g., ("select u from users u where u.id = 1")
     * @return  a list of objects in the database of the class type
     */
    Optional<List<T>> runQuery(String query);

    /**
     *
     * @param query query to  be executed e.g., ("select u from users u where u.id = 1")
     * @return a single objects in the database of the class type
     */
    T runQuerySingle(String query);

    /**
     *
     * @return a list of all objects in the database of class type
     */
    List<T> findAll();

    /**
     *
     * @param beginIndex the index from which the result should begin
     * @param endIndex the index from which the result should end
     * @return an arraylist of objects in the database of the class type
     */
    List<T> findAllWithRange(int beginIndex, int endIndex);

    /**
     * Closes the EntityManager and the EntityManagerFactory
     */
    void close();

    /**
     * Clears the EntityManager
     */
    void clear();

}
