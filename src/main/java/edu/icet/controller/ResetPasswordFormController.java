package edu.icet.controller;

import com.jfoenix.controls.JFXPasswordField;
import edu.icet.bo.BoFactory;
import edu.icet.bo.custom.EmployeeBo;
import edu.icet.model.Employee;
import edu.icet.util.BoType;
import edu.icet.util.Validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
public class ResetPasswordFormController{

    @FXML
    private JFXPasswordField password1;

    @FXML
    private JFXPasswordField password2;
    private Employee employee;
    EmployeeBo employeeBo= BoFactory.getInstance().getBo(BoType.EMPLOYEE);
    Validator validator=new Validator();
    @FXML
    void resetPasswordOnAction(ActionEvent event) {
        if (password1.getText()==null&&password2.getText()==null){
            new Alert(Alert.AlertType.INFORMATION, "Eenter  password").show();
        }else {
            if (password1.getText().equals(password2.getText())){
                this.employee.setPassword(validator.hashPassword(password1.getText()));
                employeeBo.updateUser(this.employee);
                new Alert(Alert.AlertType.INFORMATION, "Login Success").show();
                Stage stage0 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage0.close();
            }else {
                new Alert(Alert.AlertType.ERROR, "Enter Password Correctly").show();
            }
        }
    }
    public void init(Employee employee){
        this.employee=employee;
        System.out.println(employee);
    }

}
