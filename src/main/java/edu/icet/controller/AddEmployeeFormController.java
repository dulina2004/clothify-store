package edu.icet.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.net.URL;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void empBtnOnActionAdd(ActionEvent event) {

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
