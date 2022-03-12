package com.atguigu.qqzone.controller;

import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.ReplyService;
import com.atguigu.qqzone.service.TopicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-22 21:32
 */
public class TopicController {
    private TopicService topicService;
    private ReplyService replyService;

    public String topicDetail(Integer id , HttpSession session){
        Topic topic = topicService.getTopicById(id);

        session.setAttribute("topic",topic);
        return "frames/detail";
    }
    public String delTopic(Integer topicId){
        topicService.delTopic(topicId);
        return "redirect:topic.do?operate=getTopicList";
    }
    public String getTopicList(HttpSession session){
        //从session中获取当前用户信息
        UserBasic userBasic= (UserBasic)session.getAttribute("userBasic");
        //再次拆线牛当前用户关联的所有日志
        List<Topic> topicList = topicService.getTopicList(userBasic);
        //设置一下关联的日志列表（因为之前session中关联的friend的topicList和此刻数据库中不一致）
        userBasic.setTopicList(topicList);
        //重新覆盖一下friend中的信息（为什么不覆盖在userbasic中因为mian.html页面迭代的是friend中key中的数据）
        session.setAttribute("friend",userBasic);
        return "frames/main";
    }
}

