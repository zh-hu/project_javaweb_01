package com.atguigu.qqzone.service.impl;

import com.atguigu.qqzone.dao.TopicDAO;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.TopicService;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-21 20:33
 */
public class TopicServiceImpl implements TopicService {
    private TopicDAO topicDAO = null;
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {

        return topicDAO.getTopicList(userBasic);
    }
}
