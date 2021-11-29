package Connector;

import Model.Customer;
import Model.Customer2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DataBaseConnect {



        /*
         * NationalID
         * FullName
         * fatherName
         * BankID
         * PhoneNumber
         * Email
         * HomeAdress
         * Password
         * LoanID
         * AccountType
         * Balance
         */

        private String nationalID;
        private String fullName;
        private String fatherName;
        private String bankId;
        private String phoneNumber;
        private String email;
        private String homeAdress;
        private String password;
        private String loanID;
        private String accountType;
        private double balance;

        private String [][] TableData = new String[100][12];

        private Connection connection;

    private static String DB_PATH = "jdbc:mysql://localhost:3306/BankDatabase";

    private void openConnection() throws SQLException {

        /* ** ** import user and password ** ** */
        connection = DriverManager.getConnection(DB_PATH,"user","DBpassword.");
    }

    private void closeConnection() throws SQLException {
        connection.close();
    }

        public DataBaseConnect(){

        }


        public void WriteToDataBase()
        {


            try
            {
                openConnection();
                Statement statement = connection.createStatement();

                String save = "INSERT INTO Information(NationalID,FullName,DadName,BankID,PhoneNumber,Email,HomeAddres,Password,LoanID,AccountType,Balance) VALUES('%s' , '%s' , '%s' , '%s' , '%s' ,'%s','%s','%s','%s','%s',%s)";

                save = String.format(save,nationalID,fullName,fatherName,bankId,phoneNumber,email,homeAdress,password,loanID,accountType,balance);
                statement.execute(save);

                statement.close();
                closeConnection();
            }

            catch (SQLException e)
            {
                e.printStackTrace();
            }

        }


        public void ChangeBalance(double newBalance , String newBankID)
        {
            try
            {
                openConnection();
                Statement statement = connection.createStatement();
                String save = "UPDATE Information SET Balance=%s WHERE BankID='%s'";
                save = String.format(save,newBalance,newBankID);
                statement.execute(save);

                statement.close();
                closeConnection();

            }

            catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public void ChangePassword(String password , String newBankID)
        {
        try
        {
            openConnection();
            Statement statement = connection.createStatement();
            String save = "UPDATE Information SET Password=%s WHERE BankID='%s'";
            save = String.format(save,password,newBankID);
            statement.execute(save);

            statement.close();
            closeConnection();

        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }


        public void ReadInformaiton(String newBankID)
        {
            try
            {
                openConnection();
                Statement statement = connection.createStatement();
                String save = "SELECT * FROM Information WHERE BankID='%s'";
                save = String.format(save, newBankID);
                ResultSet result = statement.executeQuery(save);

                while (result.next()){
                    nationalID = result.getString("NationalID");
                    fullName = result.getString("FullName");
                    fatherName = result.getString("DadName");
                    bankId = result.getString("BankID");
                    phoneNumber =  result.getString("PhoneNumber");
                    email =  result.getString("Email");
                    homeAdress =  result.getString("HomeAddres");
                    password =  result.getString("Password");
                    loanID =  result.getString("LoanID");
                    accountType =  result.getString("AccountType");
                    balance =  result.getDouble("Balance");
                }


                result.close();
                statement.close();
                closeConnection();

            }

            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }


        public String[][] GetInformationTableData()
        {
            try
            {
                openConnection();
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM Information");

                int i = 0;

                while (result.next())
                {
                    TableData[i][0] = Integer.toString(i+1);
                    TableData[i][1] = result.getString("NationalID");
                    TableData[i][2] = result.getString("FullName");
                    TableData[i][3] = result.getString("DadName");
                    TableData[i][4] = result.getString("BankID");
                    TableData[i][5] = result.getString("PhoneNumber");
                    TableData[i][6] = result.getString("Email");
                    TableData[i][7] = result.getString("HomeAddres");
                    TableData[i][8] = result.getString("Password");
                    TableData[i][9] = result.getString("LoanID");
                    TableData[i][10] = result.getString("AccountType");
                    TableData[i][11] = Double.toString(result.getDouble("Balance"));
                    i++;
                }

                result.close();
                statement.close();
                closeConnection();

                return TableData;


            }

            catch (SQLException e)
            {
                e.printStackTrace();
                return TableData;

            }
        }

        public boolean IsCardIDExiest(String cardID) {

            String saveSt = null;
            boolean exiests = false;

            try
            {
                openConnection();
                Statement statement = connection.createStatement();

                String save = "SELECT FullName FROM Information WHERE BankID='%s'";
                save = String.format(save , cardID);

                ResultSet result = statement.executeQuery(save);

                while (result.next()){
                    saveSt = result.getString("FullName");
                }


                result.close();
                statement.close();
                closeConnection();
            }

            catch (SQLException e)
            {
                System.out.println(e);
                saveSt = "false";
            }

            if (!(saveSt.equals("false")))
                exiests = true;

            return  exiests;

        }


        public String GetNameByCardID(String cardID){

            String saveSt = null;

            try
            {
                openConnection();
                Statement statement = connection.createStatement();

                String save = "SELECT FullName FROM Information WHERE BankID='%s'";
                save = String.format(save , cardID);

                ResultSet result = statement.executeQuery(save);

                while(result.next()){
                    saveSt = result.getString("FullName");
                }


                result.close();
                statement.close();
                closeConnection();
            }

            catch (SQLException e)
            {
                System.out.println(e);
                saveSt = "Card ID not Find";
            }

            return  saveSt;

        }


        public ObservableList getTableDataForManager() throws SQLException {

            ObservableList <Customer2> list = FXCollections.observableArrayList();

            openConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Information");

            while (result.next())
            {
                Customer2 customer = new Customer2();

                customer.setNationalID(result.getString("NationalID"));
                customer.setFullName(result.getString("FullName"));
                customer.setFatherName(result.getString("DadName"));
                customer.setBankId(result.getString("BankID"));
                customer.setPhoneNumber(result.getString("PhoneNumber"));
                customer.setEmail(result.getString("Email"));
                customer.setHomeAdress(result.getString("HomeAddres"));
                customer.setPassword(result.getString("Password"));
                customer.setLoanID(result.getString("LoanID"));
                customer.setAccountType(result.getString("AccountType"));
                customer.setBalance(result.getDouble("Balance"));

                list.add(customer);

            }

            statement.close();
            closeConnection();

            return list;

        }



        public void DeleteCustomer(String cardID) throws SQLException {

            openConnection();
            Statement statement = connection.createStatement();

            String save = "DELETE FROM Information WHERE BankID='%s'";
            save = String.format(save,cardID);

            statement.execute(save);

        }


        public double ReadBalance(String newBankID) throws SQLException {

            openConnection();
            Statement statement = connection.createStatement();

            double saveDb = 0;

            String save = "SELECT Balance FROM Information WHERE BankID='%s'";
            save = String.format(save, newBankID);
            ResultSet result = statement.executeQuery(save);

            while (result.next()){
                saveDb = result.getDouble("Balance");
            }



            result.close();
            statement.close();
            closeConnection();

            return saveDb;

        }


        public boolean isCardIDAndPasswordRight(String cardID , String Password) throws SQLException {

            boolean isTrue = false;

            openConnection();
            Statement statement = connection.createStatement();

            String save = "SELECT Password FROM Information WHERE BankID='%s'";
            save = String.format(save , cardID);

            String newPassword = null;

            try
            {
                ResultSet result = statement.executeQuery(save);

                while(result.next()){
                    newPassword = result.getString("Password");
                }

                result.close();

                if (newPassword.equals(Password))
                    isTrue = true;

                statement.close();
                closeConnection();

                return isTrue;

            }

            catch (SQLException e)
            {
                statement.close();
                closeConnection();
                return isTrue;
            }

        }


        /* ============================= */
        public String GetNationalID() {
            return nationalID;
        }

        public void setNationalID(String nationalID) {
            this.nationalID = nationalID;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getFatherName() {
            return fatherName;
        }

        public void setFatherName(String fatherName) {
            this.fatherName = fatherName;
        }

        public String getBankId() {
            return bankId;
        }

        public void setBankId(String bankId) {
            this.bankId = bankId;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getHomeAdress() {
            return homeAdress;
        }

        public void setHomeAdress(String homeAdress) {
            this.homeAdress = homeAdress;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getLoanID() {
            return loanID;
        }

        public void setLoanID(String loanID) {
            this.loanID = loanID;
        }

        public String getAccountType() {
            return accountType;
        }

        public void setAccountType(String accountType) {
            this.accountType = accountType;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }


        /* ================================== */

}


