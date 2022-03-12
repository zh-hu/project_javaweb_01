package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.HostReply;

/**
 * @author zhanghu
 * @create 2022-02-21 17:21
 */
public interface HostReplyDAO {
    //replyId查询的hontReply实体
    HostReply getHostReplyByReplyId(Integer replyID);
    //删除特定的hostReply
    void delHostReply(Integer id);
}
