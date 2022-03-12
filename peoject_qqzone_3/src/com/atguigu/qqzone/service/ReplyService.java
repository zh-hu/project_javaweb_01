package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-22 22:04
 */
public interface ReplyService {
    /**
     *  根据topic的id获取关联的所有回复
     */
    List<Reply> getReplyListByTopicId(Integer topicId);
    /**
     * 添加回复
     */
    void addReply(Reply reply);
    void delReply(Integer id);
    /**
     * 删除制定的日志关联的所有的回复
     */
    void delReplyList(Topic topic);
}
