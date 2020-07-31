package cn.yuyangyang.weixin.service.impl;

import cn.yuyangyang.weixin.dao.PassiveReplyDao;
import cn.yuyangyang.weixin.dao.TextMessageDao;
import cn.yuyangyang.weixin.model.KeyWord;
import cn.yuyangyang.weixin.model.TextMessage;
import cn.yuyangyang.weixin.service.PassiveReplyService;
import cn.yuyangyang.weixin.utils.Const;
import cn.yuyangyang.weixin.utils.InitTextMessage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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

        String message = null;

        // 需要回复什么类型的消息
        QueryWrapper<KeyWord> query = Wrappers.query();
        query.select("type").in("keyword", content);
        String type = passiveReplyDao.selectOne(query).getType();
        System.out.println("====================");
        System.out.println(type);
        System.out.println("====================");
        if (type.equals(Const.MESSAGE_TEXT)){
            // TODO 要回复文本类型的
            //query.in("")
            //message = InitTextMessage.initTextMessage(toUserName, fromUserName, );
        }else if (type.equals(Const.MESSAGE_IMAGE)){
            // 要回复图片类型的

        }else if (type.equals(Const.MESSAGE_VOICE)){

        }else if (type.equals(Const.MESSAGE_VIDEO)){

        }else if (type.equals(Const.MESSAGE_MUSIC)){

        }else if (type.equals(Const.MESSAGE_NEWS)){

        }
        return message;
    }

}
