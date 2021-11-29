package Model;

import Connector.DataBaseConnect;

public class Customer {

    private static String nationalID;
    private static String fullName;
    private static String fatherName;
    private static String bankId;
    private static String phoneNumber;
    private static String email;
    private static String homeAdress;
    private static String password;
    private static String loanID;
    private static String accountType;
    private static double balance;


    public static void ReadData(){

        DataBaseConnect dataBaseConnect = new DataBaseConnect();
        dataBaseConnect.ReadInformaiton(bankId);

        Model.Customer.setNationalID(dataBaseConnect.GetNationalID());
        Model.Customer.setFullName(dataBaseConnect.getFullName());
        Model.Customer.setFatherName(dataBaseConnect.getFatherName());
        Model.Customer.setBankId(dataBaseConnect.getBankId());
        Model.Customer.setPhoneNumber(dataBaseConnect.getPhoneNumber());
        Model.Customer.setEmail(dataBaseConnect.getEmail());
        Model.Customer.setHomeAdress(dataBaseConnect.getHomeAdress());
        Model.Customer.setPassword(dataBaseConnect.getPassword());
        Model.Customer.setLoanID(dataBaseConnect.getLoanID());
        Model.Customer.setAccountType(dataBaseConnect.getAccountType());
        Model.Customer.setBalance(dataBaseConnect.getBalance());

    }


    public static void WriteData(){

        DataBaseConnect dataBaseConnect = new DataBaseConnect();
        dataBaseConnect.ReadInformaiton(bankId);

        dataBaseConnect.setNationalID(nationalID);
        dataBaseConnect.setFullName(fullName);
        dataBaseConnect.setFatherName(fatherName);
        dataBaseConnect.setBankId(bankId);
        dataBaseConnect.setPhoneNumber(phoneNumber);
        dataBaseConnect.setEmail(email);
        dataBaseConnect.setHomeAdress(homeAdress);
        dataBaseConnect.setPassword(password);
        dataBaseConnect.setLoanID(loanID);
        dataBaseConnect.setAccountType(accountType);
        dataBaseConnect.setBalance(balance);

        dataBaseConnect.ChangeBalance(balance,bankId);
        dataBaseConnect.ChangePassword(password,bankId);

    }



    public String getNationalID() {
        return nationalID;
    }

    public static void setNationalID(String newNationalID) {
        nationalID = newNationalID;
    }

    public static String getFullName() {
        return fullName;
    }

    public static void setFullName(String newfullName) {
        fullName = newfullName;
    }

    public static String getFatherName() {
        return fatherName;
    }

    public static void setFatherName(String newfatherName) {
        fatherName = newfatherName;
    }

    public static String getBankId() {
        return bankId;
    }

    public static void setBankId(String newbankId) {
        bankId = newbankId;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(String newphoneNumber) {
        phoneNumber = newphoneNumber;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String newemail) {
        email = newemail;
    }

    public static String getHomeAdress() {
        return homeAdress;
    }

    public static void setHomeAdress(String newhomeAdress) {
        homeAdress = newhomeAdress;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String newpassword) {
        password = newpassword;
    }

    public static String getLoanID() {
        return loanID;
    }

    public static void setLoanID(String newloanID) {
        loanID = newloanID;
    }

    public static String getAccountType() {
        return accountType;
    }

    public static void setAccountType(String newaccountType) {
        accountType = newaccountType;
    }

    public static double getBalance() {
        return balance;
    }

    public static void setBalance(double newbalance) {
        balance = newbalance;
    }
}
