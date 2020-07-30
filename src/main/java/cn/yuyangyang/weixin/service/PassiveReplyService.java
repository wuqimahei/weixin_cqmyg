package cn.yuyangyang.weixin.service;


public interface PassiveReplyService {
    String selectByKeyWord(String fromUserName, String toUserName, String content);
}
