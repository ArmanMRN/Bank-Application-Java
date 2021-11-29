package build;

import Connector.DataBaseConnect;

import java.util.Random;

public class CreateCardID {

    public static String Run (){

        boolean exists = true;
        String result = "";
        DataBaseConnect dataBaseConnect = new DataBaseConnect();

        while (exists)
        {
            exists = false;
            result = "5892-1011-"+Create()+"-"+Create();
            if (dataBaseConnect.IsCardIDExiest(result))
                exists = true;
        }



        return result;
    }

    private static String Create(){

        String saveSt = "";
        Random random = new Random();

        for(int i = 0;i<4;i++)
        {

            int save = random.nextInt(9);
            saveSt = saveSt + Integer.toString(save);

        }

        return saveSt;
    }

}
