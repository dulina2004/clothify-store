package edu.icet.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.icet.bo.BoFactory;
import edu.icet.bo.custom.CustomerBo;
import edu.icet.bo.custom.ItemBo;
import edu.icet.model.Customer;
import edu.icet.model.Item;
import edu.icet.model.Supplier;
import edu.icet.util.BoType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {

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
    private JFXComboBox<String> txtCustID;

    @FXML
    private JFXTextField txtCustName;

    @FXML
    private Label txtDate;

    @FXML
    private JFXComboBox<String> txtItemCode;

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
        try {
            Item item=itemBo.searchItemByName(txtItemName.getText());
            txtItemCode.setValue(item.getId());
            txtUnitPrice.setText(item.getUnitPrice()+"");
            txtSize.setText(item.getSize());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("No Item Found");
            alert.showAndWait();
            txtItemCode.setValue("");
            txtUnitPrice.setText("0");
            txtSize.setText("0");
        }
    }

    @FXML
    void custIDonAction(ActionEvent event) {
        try {
            txtCustName.setText(customerBo.searchItemByID(txtCustID.getValue()).getName());
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @FXML
    void itemCodeOnAction(ActionEvent event) {
        try {
            Item item=itemBo.searchItemByID(txtItemCode.getValue());
            txtItemName.setText(item.getName());
            txtUnitPrice.setText(item.getUnitPrice()+"");
            txtSize.setText(item.getSize());
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @FXML
    void supBtnSearchOnAction(ActionEvent event) {
        try {
            txtCustID.setValue(customerBo.searchUserByName(txtCustName.getText()).getId());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("No Customer Found");
            alert.showAndWait();
        }
    }

    CustomerBo customerBo= BoFactory.getInstance().getBo(BoType.CUSTOMER);
    private void loadCustomerIdmenu(){
        ObservableList<String> customers = FXCollections.observableArrayList();
        ObservableList<Customer> sup=customerBo.getAllUsers();
        for (Customer customer:sup){
            customers.add(customer.getId());
        }
        txtCustID.setItems(customers);
    }

    ItemBo itemBo= BoFactory.getInstance().getBo(BoType.ITEM);
    private void loadItemIdmenu(){
        ObservableList<String> items = FXCollections.observableArrayList();
        ObservableList<Item> sup=itemBo.getAllUsers();
        for (Item item:sup){
            items.add(item.getId());
        }
        txtItemCode.setItems(items);
    }

    private void loadDateAndTime(){
        Date date =new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow=f.format(date);

        txtDate.setText(dateNow);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadCustomerIdmenu();
        loadItemIdmenu();
        loadDateAndTime();
    }
}
