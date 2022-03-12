package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.HostReply;

/**
 * @author zhanghu
 * @create 2022-02-22 22:13
 */
public interface HostReplyService {
    HostReply getHostReplyByReplyId(Integer replyId);
    void delReply(Integer id);
}
