package org.example.spring.mvc.service;

import org.example.spring.mvc.dao.DatabasePool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testService {
    public Connection testAdd(Long studentId,String studentName) {
        Date date = new Date();//创建一个时间对象，获取到当前的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置时间显示格式
        String time = sdf.format(date);//将当前时间格式化为需要的类型
        String sqlString = "INSERT INTO s_student ( student_name, student_id,add_time ) VALUES ( \"" + studentName + "\"," + studentId + ",\"" + time + "\");";
        String sqlString2 = "INSERT INTO s_student ( student_name, student_id,add_time ) VALUES ( \"李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗李狗\",123123,\"2020-04-22 21:39:43\");";
        System.out.println(sqlString);
        Connection connection = null;
        try {
            connection = DatabasePool.getHikariDataSource().getConnection();
            connection.setAutoCommit(false);
            try  {
                Statement statement1 = connection.createStatement();
                //Statement statement2 = connection.createStatement();
                statement1.executeUpdate(sqlString);
                statement1.executeUpdate(sqlString2);
                connection.commit();

            } catch (SQLException e) {
                e.printStackTrace();
                //System.out.println("进入catch");
                return connection;
                //回滚事务代码
            }
        } catch (SQLException e) {
            e.printStackTrace();


        }
        return null;
    }
    }
