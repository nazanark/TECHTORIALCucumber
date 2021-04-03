package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static ResultSetMetaData resultSetMetaData;

    public static void establishConnection(){
        try {
             connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@techtorial.cpstghim1im2.us-east-2.rds.amazonaws.com:1521/ORCL",
                    "Student",
                    "Zholdoshkozhogulnara6566");

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static List <Map< String, Object>> executeQuery(){

        List<Map<String, Object>> employees = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("select * from employees");

            resultSet.beforeFirst();
            resultSetMetaData = resultSet.getMetaData();

            while (resultSet.next()) {
                Map<String, Object> employee = new LinkedHashMap<>();
                for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {

                    employee.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));

                }
                employees.add(employee);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return employees;
    }


    public static int getRowNum() throws SQLException{
        resultSet.last();
        return resultSet.getRow();
    }


    public static void closeConnection() throws SQLException{
        if(connection!=null){
            connection.close();
        }

        if(statement!=null){
            statement.close();
        }

        if(resultSet!=null){
            resultSet.close();
        }
    }

}
