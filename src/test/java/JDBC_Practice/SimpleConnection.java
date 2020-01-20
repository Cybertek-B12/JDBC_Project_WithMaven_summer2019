package JDBC_Practice;

import java.sql.*;

public class SimpleConnection {

    public static void main(String[] args) throws SQLException {

        /*
        hostname: your own host name
        port:1521
        SID: xe

        URL formula: jdbc:oracle:thin:@yourHostName:1521:xe

         */
        String url = "jdbc:oracle:thin:@54.166.75.182:1521:xe";
        String username ="hr";
        String password = "hr";

        // step 1
        Connection connection = DriverManager.getConnection(url, username, password);

      //  System.out.println("Connected");

        // step 2
         Statement statement = connection.createStatement();

            // select * from countries

             ResultSet result  = statement.executeQuery("select * from countries");

             while(result.next()){
               String countryName =   result.getString("country_name");
               int region_id = result.getInt("region_id");

                if(countryName.equals("Germany")) {
                    System.out.println(countryName+" "+region_id);
                }

             }


    }


}
