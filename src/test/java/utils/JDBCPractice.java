package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBCPractice {

    /*
    1. Connection --> it helps us to provide database credentials and connect to the database
    2. Statement --> we define our conditions to get the result from database
    3. ResultSet --> we store the data from database to the ResultSet object in JAVA

    -- Three of them are interface --

     */
    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection(
                "jdbc:oracle:thin:@techtorial.cpstghim1im2.us-east-2.rds.amazonaws.com:1521/ORCL",
                "Student",
                "Zholdoshkozhogulnara6566");

        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet=statement.executeQuery("select * from employees");

        resultSet.next(); // --> it will go to the next row. If there is a next() row it will return true and go to the next row
        // if there is no next row, it will return false.

        System.out.println(resultSet.getString("first_name"));

        resultSet.last(); // --> it will go to the last row
        // resultSet.first(); --> it will go to the first row
        // resultSet.beforeFirst(); --> it will go to the column names

        System.out.println(resultSet.getString("last_name"));
        System.out.println(resultSet.getRow()); // --> it will return row number where my resultSet is pointing
        System.out.println(resultSet.next()); // --> it will return false, since after last row there is nothing

        //----------------------------------------------------------------------//
        resultSet.beforeFirst();
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
        // METADATA --> Information about the your columns, row etc in your table
        // a set of data that describes and gives information about ther data.
        System.out.println(resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(3));

        List<Map<String,Object>> employees=new ArrayList<>();

        while (resultSet.next()){
            Map<String, Object> employee=new LinkedHashMap<>();
            for (int i = 1; i <resultSetMetaData.getColumnCount(); i++) {

                employee.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));

            }
            employees.add(employee);
        }
        System.out.println(employees.get(2).get("EMAIl"));
        System.out.println(employees.get(3));
    }
}
