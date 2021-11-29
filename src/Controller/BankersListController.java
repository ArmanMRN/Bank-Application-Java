package Controller;

import Connector.BankerDataBaseConnect;
import Connector.DataBaseConnect;
import com.sun.javafx.collections.ImmutableObservableList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Model.Banker;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class BankersListController {

    static ObservableList<Banker> list;

     {
        try
        {
            list = new BankerDataBaseConnect().GetTableDataForManager();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    static Stage stage;
    static Parent root;

    public void OpenPage() throws IOException, SQLException {

        root = FXMLLoader.load(getClass().getResource("/view/BankersList.fxml"));
        stage = new Stage();
        stage.setTitle("Bankers List");
        stage.setScene(new Scene(root,840,500));
        stage.show();


    }

    public void initialize (){

        fullName.setCellValueFactory(new PropertyValueFactory<Banker,String>("fullName"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Banker,String>("phone"));
        address.setCellValueFactory(new PropertyValueFactory<Banker,String>("address"));
        userName.setCellValueFactory(new PropertyValueFactory<Banker,String>("userName"));
        password.setCellValueFactory(new PropertyValueFactory<Banker,String>("password"));

        table.setItems(list);

    }

    @FXML
    private TableView<Banker> table;

    @FXML
    private TableColumn<Banker, String> fullName;

    @FXML
    private TableColumn<Banker, String> phoneNumber;

    @FXML
    private TableColumn<Banker, String> address;

    @FXML
    private TableColumn<Banker, String> userName;

    @FXML
    private TableColumn<Banker, String> password;

}
