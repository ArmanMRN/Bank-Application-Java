package Connector;

import java.sql.SQLException;

public class UserNamePasswordCheck extends DataBaseConnect{

    public boolean Manager(String userName , String password){

        boolean isTrue = false;
        ManagerInformation manager = new ManagerInformation();

        if (userName.equals(manager.getUserName()) && password.equals(manager.getPassword()))
            isTrue=true;

        return isTrue;
    }


    public boolean Banker(String userName , String password){

        try
        {

            boolean isTrue = false;
            BankerDataBaseConnect banker = new BankerDataBaseConnect();
            banker.setUserName(userName);
            banker.ReadInformation();


            if (userName.equals(banker.getUserName()) && password.equals(banker.getPassword()))
                isTrue = true;

            return isTrue;
        }

        catch (Exception e)
        {
            return false;
        }
    }

}
