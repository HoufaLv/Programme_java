package com.ksit.jdbcc;

import org.junit.Test;


import java.sql.*;

public class TestJdbcAdv {

    @Test
    public void testInvokeProcedure() throws ClassNotFoundException {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql:///kaishengit_db","root","rootroot");

            //将返回值 换成 ? , ?
            String sql = "{CALL productProcedure2(?,?)}";

            //使用CallableStatement 来调用存储过程
            CallableStatement callableStatement = connection.prepareCall(sql);

            //为返回值注册,为第一个返回值和第二个返回值注册
            callableStatement.registerOutParameter(1, Types.DECIMAL);
            callableStatement.registerOutParameter(2, Types.DECIMAL);
            ResultSet resultSet = callableStatement.executeQuery();

            float aFloat = callableStatement.getFloat(1);
            float aFloat1 = callableStatement.getFloat(2);

            System.out.println(aFloat);
            System.out.println(aFloat1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
