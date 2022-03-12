package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-21 17:35
 */
public interface UserBasicService {
    /**
     *
     * @param loginId
     * @param pwd
     * @return
     */
    UserBasic login(String loginId , String pwd);

    /**
     *
     * @param userBasic
     * @return
     */
    List<UserBasic> getFriendList(UserBasic userBasic);

    /**
     * 根据id获取指定的用户信息
     */
    UserBasic getUserBasicById(Integer id);
}
