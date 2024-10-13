package edu.icet.controller;

import com.jfoenix.controls.JFXTextField;
import edu.icet.bo.custom.impl.EmployeeBoImpl;
import edu.icet.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class AddEmployeeFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> EmpID;

    @FXML
    private TableColumn<?, ?> EmpMobile;

    @FXML
    private TableColumn<?, ?> EmpName;

    @FXML
    private TableColumn<?, ?> EmpNic;

    @FXML
    private TableView<?> EmpTable;

    @FXML
    private Pane dpane_111;

    @FXML
    private Pane dpane_1111;

    @FXML
    private Pane dpane_11111;

    @FXML
    private Pane dpane_111111;

    @FXML
    private Pane dpane_11112;

    @FXML
    private Pane dpane_11113;

    @FXML
    private JFXTextField txtEmpEmail;

    @FXML
    private JFXTextField txtEmpID;

    @FXML
    private JFXTextField txtEmpMobile;

    @FXML
    private JFXTextField txtEmpName;

    @FXML
    private JFXTextField txtEmpNic;

    @FXML
    private JFXTextField txtEmpPassword;

    EmployeeBoImpl employeeBoImpl = new EmployeeBoImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtEmpID.setText("888888");
    }

    @FXML
    void empBtnOnActionAdd(ActionEvent event) {

        Random random = new Random();
        int p = random.nextInt(99999999) + 10000000;

        String encrypt = Integer.toString(p);
        String password = employeeBoImpl.passwordEncrypt(encrypt);

        Employee user = new Employee(
                txtEmpID.getText(),
                txtEmpName.getText(),
                txtEmpEmail.getText(),
                txtEmpNic.getText(),
                password,
                txtEmpMobile.getText()
        );
        if (!txtEmpName.getText().equals("") && employeeBoImpl.isValidEmail(txtEmpEmail.getText()) && !txtEmpNic.getText().equals("")) {


            boolean isInsert = employeeBoImpl.insertUser(user);
            if (isInsert) {
                //Table1.setItems(userBoImpl.getAllUsers());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Employee Added");
                alert.setContentText("Employee Added Successfully..!");
                alert.showAndWait();
                //txtId.setText(userBoImpl.generateEmployeeId());
                //txtAddress.setText("");
                //txtName.setText("");
                //txtEmail.setText("");
            }

        } else {
            new Alert(Alert.AlertType.ERROR, "Somthing Wrong..!!!").show();
        }

    }

    @FXML
    void empBtnOnActionDelete(ActionEvent event) {

    }

    @FXML
    void empBtnOnActionSearch(ActionEvent event) {

    }

    @FXML
    void empBtnOnActionUpdate(ActionEvent event) {

    }


}
