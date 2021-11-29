package Connector;
import Model.Banker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public class BankerDataBaseConnect {

    private String userName;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String address;

    private Connection connection;

    private static String DB_PATH = "jdbc:mysql://localhost:3306/bankdatabase";

    private void openConnection() throws SQLException {

        /* ** ** ** import user and password ** ** ** */
        connection = DriverManager.getConnection(DB_PATH,"user","DBpassword.");
    }

    private void closeConnection() throws SQLException {
        connection.close();
    }


    public void WriteToDataBase() throws SQLException {

        openConnection();
        Statement statement = connection.createStatement();
        String save;
        save = "INSERT INTO Bankers(UserName,Password,FullName,PhoneNumber,Address) " +
                "VALUES('%s','%s','%s','%s','%s')";
        save = String.format(save , userName,password,fullName,password,address);

        statement.execute(save);

        statement.close();
        closeConnection();
    }

    void ReadInformation() throws SQLException {

        openConnection();
        Statement statement = connection.createStatement();
        String save;
        save = "SELECT * FROM Bankers WHERE UserName='%s'";
        save = String.format(save,userName);

        ResultSet result = statement.executeQuery(save);

        while(result.next()){
            userName = result.getString("UserName");
            password = result.getString("Password");
            fullName = result.getString("FullName");
            phoneNumber = result.getString("PhoneNumber");
            address = result.getString("Address");

        }

        result.close();
        statement.close();
        closeConnection();
    }

    public ObservableList<Banker> GetTableDataForManager() throws SQLException {

        ObservableList<Banker> list = FXCollections.observableArrayList();

        openConnection();
        Statement statement = connection.createStatement();

        String save = "SELECT * FROM Bankers";
        ResultSet result = statement.executeQuery(save);

        while (result.next())
        {
            Banker banker = new Banker();

            banker.setFullName(result.getString("FullName"));
            banker.setPhone(result.getString("PhoneNumber"));
            banker.setAddress(result.getString("Address"));
            banker.setUserName(result.getString("UserName"));
            banker.setPassword(result.getString("Password"));

            list.add(banker);

        }

        result.close();
        statement.close();
        closeConnection();
        return list;

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
