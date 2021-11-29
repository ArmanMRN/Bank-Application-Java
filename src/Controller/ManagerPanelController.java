package Controller;

import build.DepositInterest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ManagerPanelController {

    static Stage stage;
    static Parent root;

    public void OpenPage() throws IOException {

        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("/view/ManagerPanel.fxml"));
        stage.setTitle("Manager Panel");
        stage.setScene(new Scene(root , 600 , 400));
        stage.show();

    }

    @FXML
    private Button operatorsListButton;

    @FXML
    private Button addOperatorButton;

    @FXML
    private Button customersListButton;

    @FXML
    private Button bankInfoButton;

    @FXML
    private Button settleProfitsButton;

    @FXML
    private Button deleteInfoDataBaseButton;

    @FXML
    void AddOperatorButtonAction(ActionEvent event) throws IOException {
        AddOperatorButtonAction();
    }

    @FXML
    void BankInfoButtonAction(ActionEvent event) {

    }

    @FXML
    void CustomersListButtonAction(ActionEvent event) throws IOException, SQLException {
        CustomersListButtonAction();
    }

    @FXML
    void DeleteInfoDataBaseButtonAction(ActionEvent event) {

    }

    @FXML
    void OperatorsListButtonAction(ActionEvent event) throws IOException, SQLException {
        operatorsListButton();
    }

    @FXML
    void SettleProfitsButtonAction(ActionEvent event) throws SQLException {
        SettleProfitsButtonAction();
    }



    void CustomersListButtonAction() throws IOException, SQLException {

        CustomersListController customersListController = new CustomersListController();
        customersListController.OpenPage();
    }

    void AddOperatorButtonAction() throws IOException {

        AddNewBankerController addNewBankerController = new AddNewBankerController();
        addNewBankerController.OpenPage();

    }

    void operatorsListButton() throws IOException, SQLException {

        BankersListController bankersListController = new BankersListController();
        bankersListController.OpenPage();

    }

    void SettleProfitsButtonAction() throws SQLException {

        new DepositInterest().Run();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Done!");
        alert.show();
    }

}
