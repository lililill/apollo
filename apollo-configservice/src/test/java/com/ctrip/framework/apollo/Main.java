package com.ctrip.framework.apollo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception{
        Class.forName("oracle.jdbc.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.80.73:1521/orcl","CRM","123456");
        System.out.println(conn);
        Statement s = conn.createStatement();
        String sql="select * from v$version";
        ResultSet result=s.executeQuery(sql);
        while (result.next()){
            System.out.println(result.getString(1));
        }
    }
}
