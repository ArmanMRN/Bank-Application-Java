package build;

import Connector.DataBaseConnect;

import java.sql.*;

public class DepositInterest extends DataBaseConnect {

    Connection connection = DriverManager.getConnection("jdbc:sqlite:G:\\SQL\\DataBaseTest1.db");
    Statement statement = connection.createStatement();
    ResultSet result;

    final double profit = 15;
    final double countOfDays = 30;
    String []list = new String[1000];
    int i = 0;

    public DepositInterest() throws SQLException {
    }


    public void Run() throws SQLException {

        result = statement.executeQuery("SELECT BankID , Balance , AccountType FROM Information");

        String ID;
        Double balance;
        String type;

        while (result.next())
        {
            ID = result.getString("BankID");
            balance = result.getDouble("Balance");
            type = result.getString("AccountType");

            if (type.equals("Profitable Account"))
            {
                list[i] = ID;
                i++;
            }



        }

        result.close();
        statement.close();
        connection.close();

        CalculateAndDeposit();

    }

    void CalculateAndDeposit () throws SQLException {


        for (int j = 0; j < i ; j++)
        {
            double oldBalance = ReadBalance(list[j]);
            double save = (countOfDays * profit * oldBalance)/36500;

            ChangeBalance(save+oldBalance , list[j]);

        }

    }

}
