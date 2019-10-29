package com.yu.jdbctest;

import java.sql.*;

/**
 * 测试jdbc连接
 * @author pengyu
 */
public class Demo1 {

    public static void main(String[] args) {

        // 创建jdbc对象，都是java.sql包
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 创建连接对象
            String url1 = "jdbc:mysql://192.168.141.241:3306/stumgr";
            String uname1 = "root";
            String pwd1 = "root";
            conn = DriverManager.getConnection(url1,uname1,pwd1);
            //String sql = "insert into account (accname,balance) values('chenliu',1800)";
            //String sql = "delete from account where accname = 'chenliu'";
            String sql = "select * from account where ? < balance and balance <> ?  ";
            // 创建sql命令对象
            ps = conn.prepareStatement(sql);
            // 占位符赋值
            ps.setString(1, "300");
            ps.setString(2, "400");
            // 发送sql命令
            ResultSet res = ps.executeQuery();
            // 处理结果
            //System.out.println(res>0?"插入成功":"插入失败");
            while (res.next()) {
                System.out.print(res.getString("accname")+":"+res.getInt("balance"));
                System.out.println("");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }




}
