package newsmanagement.utils;

/**
 * Created by yt476 on 2017/5/8.
 */

import org.slf4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjian on 16-5-20.
 * 对本地的数据库进行操作，部分代码与DataBaseRemoteOperation重复
 */
public class DataBaseUtils {

    final static String driverName = "com.mysql.jdbc.Driver"; //驱动名称
    static final String DBUser = "root"; //mysql用户名
    static final String DBPasswd = "wangjian"; //mysql密码
    static final String DBName = "news_management"; //数据库名
    static final String MySQLServer = "localhost"; //数据库名
    static final String MySQLServerPort = "3306"; //数据库名
    public static List<Map<String,Object>> queryDB(String sql) throws ClassNotFoundException, SQLException {
        Connection conn=null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Map<String,Object>> resultList = new ArrayList<Map<String, Object>>();
        String url = "jdbc:mysql://localhost:3306/wechat";

            Class.forName(driverName);
            conn = DriverManager.getConnection(url,DBUser,DBPasswd);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while(resultSet.next()){
                Map<String,Object> column = new HashMap<String, Object>();
                for(int i=1;i<=resultSetMetaData.getColumnCount();i++){
                    column.put(resultSetMetaData.getColumnName(i),resultSet.getObject(i));
                }
                if(column.size()!=0)
                    resultList.add(column);
            }
            preparedStatement.close();
            conn.close();
            resultSet.close();

        return resultList;
    }
    public static void updateDB(String sql) throws ClassNotFoundException, SQLException {
        Connection conn=null;
        PreparedStatement preparedStatement = null;
        String url = "jdbc:mysql://"+MySQLServer+":"+MySQLServerPort+"/" + DBName;

            Class.forName(driverName);
            conn = DriverManager.getConnection(url,DBUser,DBPasswd);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();

    }
    public static void insertDB(String sql) throws SQLException, ClassNotFoundException {
        updateDB(sql);
    }
    public static void deleteDB(String sql) throws SQLException, ClassNotFoundException {
        updateDB(sql);
    }
}
