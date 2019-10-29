package com.yu.network.socket01.dao;

import com.yu.network.socket01.entity.User;

/**
 * @author pengyu
 */
public interface UserDao {

    /**
     * 查询用户数据
     * @return
     */
    public boolean query(User user);
}
