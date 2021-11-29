package Controller;

import Connector.DataBaseConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMoneyTransferPage {

    private boolean isCheckButtonPresed = false;
    private boolean isAccountFounded = true;
    static Stage stage;
    static Parent root;

    public void Open() throws IOException {

        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("/view/MoneyTransferPage.fxml"));
        stage.setTitle("Money Transfer");
        stage.setScene(new Scene(root , 600 , 400));
        stage.show();

    }

    @FXML
    private TextField cardIDText;

    @FXML
    private TextField amountText;

    @FXML
    private Button checkButton;

    @FXML
    private Button sendButton;

    @FXML
    private Label fullNameLabel;

    @FXML
    private Label checkButtonNotPressedErrorLabel;

    @FXML
    void checkButtonAction(ActionEvent event) {

        CheckButtonAction();
    }

    @FXML
    void sendButtonAction(ActionEvent event) {

        SendButtonAction();
    }

    void CheckButtonAction(){

        checkButtonNotPressedErrorLabel.setText("");

        DataBaseConnect dataBaseConnect = new DataBaseConnect();
        fullNameLabel.setText(dataBaseConnect.GetNameByCardID(cardIDText.getText()));
        isCheckButtonPresed = true;

        if (fullNameLabel.getText().equals("Card ID not Find"))
            isAccountFounded = false;
        else
            isAccountFounded = true;
    }

    void SendButtonAction(){

        if (isAccountFounded && isCheckButtonPresed)
        {
            String amountString = amountText.getText();
            double amountDouble = Double.parseDouble(amountString);

            DataBaseConnect dataBaseConnect = new DataBaseConnect();

            dataBaseConnect.ReadInformaiton(cardIDText.getText());
            double newBalance = dataBaseConnect.getBalance() + amountDouble;

            dataBaseConnect.ChangeBalance(newBalance,cardIDText.getText());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Transfer money Done!");
            alert.show();
        }

        else
        {
            if (isCheckButtonPresed == false)
                checkButtonNotPressedErrorLabel.setText("Press Check Button");

            else if (isAccountFounded == false)
                checkButtonNotPressedErrorLabel.setText("this Card ID not exists");
        }

    }

}
