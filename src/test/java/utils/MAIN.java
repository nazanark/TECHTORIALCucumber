//package utils;
//
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Map;
//
//public class MAIN {
//
//    public static void main(String[] args) throws SQLException {
//
//        JDBCUtils.establishConnection();
//
//        List<Map<String,Object>> regions=JDBCUtils.executeQuery("select * from regions");
//
//        System.out.println(regions.get(2).get("REGION_NAME"));
//
//        List<Map<String,Object>> countries=JDBCUtils.executeQuery("select * from countries");
//        for (int i=0; i<countries.size(); i++){
//            System.out.println(countries.get(i).get("COUNTRY_NAME"));
//        }
//
//        JDBCUtils.closeConnection();
//    }
//}
