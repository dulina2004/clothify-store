package edu.icet.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.icet.bo.BoFactory;
import edu.icet.bo.custom.OrderBo;
import edu.icet.bo.custom.impl.OrderBoImpl;
import edu.icet.dao.custom.impl.OrderDaoImpl;
import edu.icet.model.Order;
import edu.icet.model.orderTblObj;
import edu.icet.util.BoType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.modelmapper.ModelMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewOrderFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> custID;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private TableColumn<?, ?> netTotal;

    @FXML
    private TableColumn<?, ?> orderID;

    @FXML
    private TableView<Order> tblOrder;

    @FXML
    void printBtnOnAction(ActionEvent event) {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Save PDF Report");
//        fileChooser.setInitialFileName("OrderReport.pdf");
//        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
//
//        File file = fileChooser.showSaveDialog(new Stage());
//        if (file != null) {
//            Document document = new Document();
//            try (FileOutputStream fos = new FileOutputStream(file)) {
//                PdfWriter.getInstance(document, fos);
//                document.open();
//
//                // Title
//                Font titleFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD, BaseColor.GREEN);
//                Paragraph title = new Paragraph("Order Report", titleFont);
//                title.setAlignment(Element.ALIGN_CENTER);
//                title.setSpacingAfter(20f);
//                document.add(title);
//
//                // Create a table with 4 columns
//                PdfPTable table = new PdfPTable(4);
//                table.setWidthPercentage(100);
//                table.setSpacingBefore(10f);
//                table.setSpacingAfter(10f);
//
//                // Header
//                Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
//                String[] headers = {"Order ID", "Date", "Net Total", "Customer ID"};
//                for (String header : headers) {
//                    PdfPCell headerCell = new PdfPCell(new Phrase(header, headerFont));
//                    headerCell.setBackgroundColor(BaseColor.DARK_GRAY);
//                    headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                    headerCell.setPadding(10f);
//                    table.addCell(headerCell);
//                }
//
//                // Data rows
//                Font dataFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
//                ObservableList<Order> orders = tblOrder.getItems();
//                for (Order order : orders) {
//                    // Order ID
//                    table.addCell(createCell(order.getId(), dataFont));
//                    table.addCell(createCell(order.getDate() != null ? order.getDate().toString() : "N/A", dataFont));
//                    table.addCell(createCell(String.valueOf(order.getNetTotal()), dataFont));
//                    table.addCell(createCell(order.getCustomer() != null ? order.getCustomer().getId() : "N/A", dataFont));
//                }
//
//                document.add(table);
//                System.out.println("PDF report saved successfully!");
//
//            } catch (DocumentException | IOException e) {
//                e.printStackTrace();
//                showAlert("Error", "Error generating PDF: " + e.getMessage());
//            } finally {
//                document.close(); // Ensure the document is closed in all cases
//            }
//        } else {
//            System.out.println("PDF save operation was canceled.");
//        }
    }
//
//    private PdfPCell createCell(String content, Font font) {
//        PdfPCell cell = new PdfPCell(new Phrase(content, font));
//        cell.setPadding(8f);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        return cell;
//    }
//
//    private void showAlert(String title, String message) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//
    OrderBoImpl orderBo= BoFactory.getInstance().getBo(BoType.ORDER);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderID.setCellValueFactory(new PropertyValueFactory<>("id"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        netTotal.setCellValueFactory(new PropertyValueFactory<>("netTotal"));
        custID.setCellValueFactory(new PropertyValueFactory<>("custID"));


        System.out.println(orderBo.getAllOrders());
        tblOrder.setItems(orderBo.getAllOrders());
    }
}
