package edu.icet.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PlaceOrderFormController {

    @FXML
    private Label netTotal;

    @FXML
    private TableView<?> tblCart;

    @FXML
    private TableColumn<?, ?> tblItemCode;

    @FXML
    private TableColumn<?, ?> tblItemName;

    @FXML
    private TableColumn<?, ?> tblPrice;

    @FXML
    private TableColumn<?, ?> tblQty;

    @FXML
    private TableColumn<?, ?> tblTotal;

    @FXML
    private JFXComboBox<?> txtCustID;

    @FXML
    private JFXTextField txtCustName;

    @FXML
    private JFXComboBox<?> txtItemCode;

    @FXML
    private JFXTextField txtItemName;

    @FXML
    private JFXTextField txtOrderID;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private Label txtSize;

    @FXML
    private Label txtUnitPrice;

    @FXML
    void btnAddItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchItemOnAction(ActionEvent event) {

    }

    @FXML
    void supBtnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void supIDAction(ActionEvent event) {

    }

}
