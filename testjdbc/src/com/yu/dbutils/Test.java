package com.yu.dbutils;

/**
 * 测试DbUtils工具类
 * @author pengyu
 */
public class Test {

    public static void main(String[] args) {

        //insert();
        //update();
        //delete();
        DbUtils.query();
    }

    /**
     * 测试增加
     */
    private static void insert() {

        String sql = "insert into account (id,accname,balance) values(?,?,?)";
        int res = DbUtils.update(sql, 3,"chenliu",50000);
        System.out.println(res > 0? "插入成功":"插入失败");
    }

    /**
     *  测试删除
     */
    private static void delete() {

        String sql = "delete from account where accname = ? and balance in ?";
        int res = DbUtils.update(sql, "chenliu",50000);
        System.out.println(res > 0? "删除成功":"删除失败");
    }

    /**
     * 测试修改
     */
    private static void update() {

        String sql = "update account set balance = ? where accname = ? and balance = ?";

        int updateBalance = 50;
        String accname = "chenliu";
        int srcBalance = 50000;
        int res = DbUtils.update(sql, updateBalance,accname,srcBalance);
        System.out.println(res > 0? "修改成功":"修改失败");
    }

}
