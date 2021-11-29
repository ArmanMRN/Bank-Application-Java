package Controller;

import Model.Customer;
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

public class CustomerResiveMoneyController {

    static Stage stage;
    Parent root;

    public void OpenPage() throws IOException {

        stage = new Stage();

        root = FXMLLoader.load(getClass().getResource("/view/CustomerResiveMoney.fxml"));
        stage.setTitle("Receive Money");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }
    @FXML
    private TextField amountTextField;

    @FXML
    private Label balanceLabel;

    @FXML
    private Label errorLabel;

    @FXML
    private Button reciveMoneyButton;

    @FXML
    void reciveMoneyButtonAction(ActionEvent event) {
        reciveMoneyButtonAction();
    }

    void reciveMoneyButtonAction(){

        double save = Double.parseDouble(amountTextField.getText());

        if (Customer.getBalance() >= save)
        {
            double newBalance = Customer.getBalance()-save;
            Customer.setBalance(newBalance);
            Customer.WriteData();
            stage.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Done!");
            alert.show();
        }

        else
        {
            errorLabel.setText("your amount is not enough");
        }


    }

    public void initialize(){

        balanceLabel.setText(Double.toString(Customer.getBalance()));
    }

}
