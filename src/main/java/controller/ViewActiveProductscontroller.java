package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ProductsService;
import services.SearchService;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.ParseException;

public class ViewActiveProductscontroller {

    @FXML
    private VBox Vbox;

    @FXML
    private Button showAllButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField textfieldSearch;

    @FXML
    TableView table;
    @FXML
    TableColumn name;
    @FXML
    TableColumn description;
    @FXML
    TableColumn price;
    @FXML
    TableColumn stock;
    @FXML
    TableColumn supplier;

    @FXML
    private Button buyButton;

    @FXML
    void searchButtonAction(ActionEvent event) {

    }

    @FXML
    void showAllButtonAction(ActionEvent event) {

    }

    @FXML
    void textfieldSearchAction(ActionEvent event) {

    }

    @FXML
    private Button gobackButton;

    @FXML
    void gobackButtonAction(ActionEvent event) {

    }


    public void showAllButtonAction(javafx.event.ActionEvent actionEvent) throws IOException, ParseException {
        ProductsService.loadProductsFromFile();
//        final ObservableList<Product> data = FXCollections.observableArrayList(
//                new Product("bla","blabla", new User("sa","dsa","user"),2,2.4),
//                new Product("bla","blabla", new User("sa","dsa","user"),2,2.4),
//                new Product("bla","blabla", new User("sa","dsa","user"),2,2.4)
//
//
//        );
        System.out.println("gasgas");
        table.getColumns().clear();
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        supplier.setCellValueFactory(new PropertyValueFactory<>("user"));
        stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.setItems(ProductsService.products );
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getColumns().addAll(name,description,supplier,stock,price);
    }

    public void searchButtonAction(javafx.event.ActionEvent actionEvent) throws IOException, ParseException {
        SearchService.Search(searchButton.getText().toString());
        table.getColumns().clear();
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/viewActiveProducts.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(NewCustomerScene);
        window.show();
        table.getColumns().clear();
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        supplier.setCellValueFactory(new PropertyValueFactory<>("user"));
        stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.setItems(SearchService.products );
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getColumns().addAll(name,description,supplier,stock,price);
    }

    public void textfieldSearchAction(javafx.event.ActionEvent actionEvent) {
    }

    public void gobackButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/LoggedINCUSTOMER.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }

    public void buyButtonAction(javafx.event.ActionEvent actionEvent) {
    }
}
