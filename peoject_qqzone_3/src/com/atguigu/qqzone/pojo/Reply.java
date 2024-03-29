package com.atguigu.qqzone.pojo;

import java.util.Date;

/**
 * @author zhanghu
 * @create 2022-02-18 13:34
 */
public class Reply {
    private Integer id;
    private String content;
    private Date replyDate;
    private UserBasic author;
    private Topic topic;
    private HostReply hostReply;


    public Reply() {
    }

    public Reply(String content, Date replyDate, UserBasic author, Topic topic) {
        this.content = content;
        this.replyDate = replyDate;
        this.author = author;
        this.topic = topic;
    }

    public Reply(Integer id) {
        this.id = id;
    }

    public Reply(String content, Date replyDate, Topic topic, HostReply hostReply) {
        this.content = content;
        this.replyDate = replyDate;
        this.topic = topic;
        this.hostReply = hostReply;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public UserBasic getAuthor() {
        return author;
    }

    public void setAuthor(UserBasic author) {
        this.author = author;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public HostReply getHostReply() {
        return hostReply;
    }

    public void setHostReply(HostReply hostReply) {
        this.hostReply = hostReply;
    }
}
