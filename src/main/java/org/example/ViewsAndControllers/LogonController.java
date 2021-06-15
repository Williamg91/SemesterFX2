package org.example.ViewsAndControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.Databasepackage.DBAccess;
import org.example.Databasepackage.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;

public class LogonController {



    @FXML
    Button knap;
    @FXML
    TextField felt;
    @FXML
    TextField Loginfelt;
    @FXML
    PasswordField passwordfelt;

    public void trykPaaKnap(ActionEvent actionEvent) {

        String Mail = Loginfelt.getText();
        String password = passwordfelt.getText();

        DatabaseConnection cdns = new DatabaseConnection();

        Connection connection = cdns.getMYSQLConnection("client","henning","SundhedsteknologiDB");
        DBAccess dba = new DBAccess(connection);
        //
        String[] combo=  dba.getUserAndPassword(Mail, password);

         dba.insertUser("Lærke","nice");


        if(combo[1].equals(password)&& combo[0].equals(Mail) ){
            try{
                App.setRoot("EKGchart");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
