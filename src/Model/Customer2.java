package Model;

import Connector.DataBaseConnect;

public class Customer2 {

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


    public void ReadData(){

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


    public void WriteData(){

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

    public void setNationalID(String newNationalID) {
        nationalID = newNationalID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String newfullName) {
        fullName = newfullName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String newfatherName) {
        fatherName = newfatherName;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String newbankId) {
        bankId = newbankId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String newphoneNumber) {
        phoneNumber = newphoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newemail) {
        email = newemail;
    }

    public String getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(String newhomeAdress) {
        homeAdress = newhomeAdress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newpassword) {
        password = newpassword;
    }

    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(String newloanID) {
        loanID = newloanID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String newaccountType) {
        accountType = newaccountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newbalance) {
        balance = newbalance;
    }


}
