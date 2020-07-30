package cn.yuyangyang.weixin.service.impl;

import cn.yuyangyang.weixin.dao.PassiveReplyDao;
import cn.yuyangyang.weixin.dao.TextMessageDao;
import cn.yuyangyang.weixin.service.PassiveReplyService;
import cn.yuyangyang.weixin.utils.Const;
import cn.yuyangyang.weixin.utils.InitTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassiveReplyServiceImpl implements PassiveReplyService {

    @Autowired
    private PassiveReplyDao passiveReplyDao;
    @Autowired
    private TextMessageDao textMessageDao;

    @Override
    public String selectByKeyWord(String fromUserName, String toUserName, String content) {

        // 需要回复什么类型的消息
        String type = passiveReplyDao.searchByKeyWord(content);
        String message = null;

        if (type.equals(Const.MESSAGE_TEXT)){
            // 要回复文本类型的
            String msg = textMessageDao.selectByKeyword(content);
            message = InitTextMessage.initTextMessage(toUserName, fromUserName, msg);
        }else if (type.equals(Const.MESSAGE_IMAGE)){
            // 要回复图片类型的

        }else if (type.equals(Const.MESSAGE_VOICE)){

        }else if (type.equals(Const.MESSAGE_VIDEO)){

        }else if (type.equals(Const.MESSAGE_MUSIC)){

        }else if (type.equals(Const.MESSAGE_NEWS)){

        }
        return message;
    }

    // 根据关键词查询需要回复的内容



}
