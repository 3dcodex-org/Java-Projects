package com.bankmanagement.bankmanagement;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.bankmanagement.bankmanagement.dao.persistentDao.AccountDao;
import com.bankmanagement.bankmanagement.dao.persistentDao.EmployeeDao;
import com.bankmanagement.bankmanagement.dao.persistentDao.TransactionDao;
import com.bankmanagement.bankmanagement.dao.persistentDao.UserDao;
import com.bankmanagement.bankmanagement.helper.status.*;
import com.bankmanagement.bankmanagement.model.Account;
import com.bankmanagement.bankmanagement.model.Employee;
import com.bankmanagement.bankmanagement.model.Transaction;
import com.bankmanagement.bankmanagement.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
//        Employee employee = new Employee();
//        employee.setUsername("emmanuel");
//        String password = "password";
//        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
//        employee.setPassword(bcryptHashString);
//        EmployeeDao employeeDao = new EmployeeDao();
//        employeeDao.add(employee);

//        User user = new User();
//        user.setFirstName("Example");
//        user.setLastName("User");
//        user.setEmail("example@gmail.com");
//        user.setAuthority(new ArrayList<>(Authority.USER.ordinal()));
//        user.setPassword("examplePassword");
//        user.setCity("Yaounde");
//        user.setAddress1("Messassi");
//        user.setAddress2("Nyom II");
//        user.setStatus(UserStatus.ACTIVE);
//        UserDao userDao = new UserDao();
//        userDao.add(user);

//        Account account = new Account();
//        account.setAccountHolder(userDao.findById(1).get());
//        account.setAccountNumber("123456789986");
//        account.setAccountType(AccountType.CURRENT);
//        account.setAccountStatus(AccountStatus.ACTIVE);
//        account.setBalance(2000000);
//        AccountDao accountDao = new AccountDao();
//        accountDao.add(account);

//        Transaction transaction = new Transaction();
//        transaction.setAccount(accountDao.findById(1).get());
//        transaction.setAmount(23000.0);
//        transaction.setBranchCode(2435);
//        transaction.setTransactionInitiator(userDao.findById(1).get());
//        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
//        transaction.setTransactionType(TransactionType.DEPOSIT);
//        TransactionDao transactionDao = new TransactionDao();
//        transactionDao.add(transaction);

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 779, 604);
        stage.setTitle("Bank Management System");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("image/ictu-logo.png")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}