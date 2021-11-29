package Controller;

import Connector.DataBaseConnect;
import Model.Customer;
import Model.Customer2;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CustomersListController {

    static ObservableList<Customer> list;


    {
        try
        {
            list = new DataBaseConnect().getTableDataForManager();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    static Stage stage;
    Parent root;


    public void initialize(){

        nationalID.setCellValueFactory(new PropertyValueFactory<Customer2,String>("nationalID"));
        fullName.setCellValueFactory(new PropertyValueFactory<Customer2,String>("fullName"));
        fatherName.setCellValueFactory(new PropertyValueFactory<Customer2,String>("fatherName"));
        cardID.setCellValueFactory(new PropertyValueFactory<Customer2,String>("BankId"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Customer2,String>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<Customer2,String>("email"));
        address.setCellValueFactory(new PropertyValueFactory<Customer2,String>("homeAdress"));
        password.setCellValueFactory(new PropertyValueFactory<Customer2,String>("password"));
        loanID.setCellValueFactory(new PropertyValueFactory<Customer2,String>("loanID"));
        accountType.setCellValueFactory(new PropertyValueFactory<Customer2,String>("accountType"));
        balance.setCellValueFactory(new PropertyValueFactory<Customer2,Double>("balance"));

        table.setItems(list);
    }


    public void OpenPage() throws IOException{

        stage = new Stage();

        root = FXMLLoader.load(getClass().getResource("/view/CustomersList.fxml"));
        stage.setTitle("Customers List");
        stage.setScene(new Scene(root, 1366, 700));
        stage.show();

    }


    @FXML
    private TableView<Customer> table;

    @FXML
    private TableColumn<Customer2, String> nationalID;

    @FXML
    private TableColumn<Customer2, String> fullName;

    @FXML
    private TableColumn<Customer2, String> fatherName;

    @FXML
    private TableColumn<Customer2, String> cardID;

    @FXML
    private TableColumn<Customer2, String> phoneNumber;

    @FXML
    private TableColumn<Customer2, String> email;

    @FXML
    private TableColumn<Customer2, String> address;

    @FXML
    private TableColumn<Customer2, String> password;

    @FXML
    private TableColumn<Customer2, String> loanID;

    @FXML
    private TableColumn<Customer2, String> accountType;

    @FXML
    private TableColumn<Customer2, Double> balance;


}
