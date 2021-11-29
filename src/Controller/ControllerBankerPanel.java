package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerBankerPanel {

    static Stage stage;
    Parent root;

    public void OpenPage() throws IOException {

        stage = new Stage();

        root = FXMLLoader.load(getClass().getResource("/View/BankerPanel.fxml"));
        stage.setTitle("Banker Panel");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }

    @FXML
    private Button createAccountButton;

    @FXML
    private Button transferMoneyButton;

    @FXML
    private Button loanButton;

    @FXML
    private Button customerInformationButton;

    @FXML
    void createAccountButtonAction(ActionEvent event) throws IOException {

        ControllerCustomerInformationFild controllerCustomerInformationFild =
                new ControllerCustomerInformationFild();

        controllerCustomerInformationFild.Open();

    }

    @FXML
    void customerInformationButtonAction(ActionEvent event) throws IOException {

        customerInformationButtonAction();
    }

    @FXML
    void loanButtonAction(ActionEvent event) {

    }

    @FXML
    void transferMoneyButtonAction(ActionEvent event) throws IOException {

        TransferMoneyButtonaction();

    }

    void TransferMoneyButtonaction() throws IOException {
        ControllerMoneyTransferPage moneyTransferPage = new ControllerMoneyTransferPage();
        moneyTransferPage.Open();
    }

    void customerInformationButtonAction () throws IOException {

        ShowCustomerInformationController show = new ShowCustomerInformationController();
        show.Open();

    }


}
