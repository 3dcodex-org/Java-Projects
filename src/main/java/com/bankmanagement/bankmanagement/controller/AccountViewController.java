package com.bankmanagement.bankmanagement.controller;


import com.bankmanagement.bankmanagement.App;
import com.bankmanagement.bankmanagement.dao.persistentDao.EmployeeDao;
import com.bankmanagement.bankmanagement.helper.session.sessionClass.EmployeeSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountViewController implements Initializable {
    private EmployeeSession employeeSession = EmployeeSession.getInstace();
    private final EmployeeDao employeeDao;

    @FXML
    private AnchorPane mainView;

    @FXML
    private AnchorPane navNode;
    public AccountViewController(){
        this.employeeDao = new EmployeeDao();
    }
    public AccountViewController(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(!EmployeeSession.isSession()){
            //empty the session
            employeeSession.cleanUserSession();
            //todo send back to the login view for proper processing
        }
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("transaction-view.fxml"));
        try {
            navNode = fxmlLoader.load();
            AnchorPane.setTopAnchor(navNode, 0.0);
            AnchorPane.setBottomAnchor(navNode, 23.0);
            AnchorPane.setLeftAnchor(navNode, 0.0);
            AnchorPane.setRightAnchor(navNode, 0.0);
            mainView.getChildren().add(navNode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
