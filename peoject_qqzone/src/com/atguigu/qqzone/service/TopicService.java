package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-21 20:31
 */
public interface TopicService {
    /**
     * 查询特定用户
     * @param userBasic
     * @return
     */
    List<Topic> getTopicList(UserBasic userBasic);
}
