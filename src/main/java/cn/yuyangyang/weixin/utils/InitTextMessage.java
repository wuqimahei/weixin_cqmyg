package cn.yuyangyang.weixin.utils;

import cn.yuyangyang.weixin.model.TextMessage;
import com.thoughtworks.xstream.XStream;
import java.util.Date;

/**
 * 拼接文本消息
 */
public class InitTextMessage {

    /**
     * 拼接文本消息
     */
    public static String initTextMessage(String toUserName, String fromUserName, String content){
        TextMessage textMessage = new TextMessage();
        textMessage.setFromUserName(toUserName);
        textMessage.setToUserName(fromUserName);
        textMessage.setMsgType(Const.MESSAGE_TEXT);
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setContent("消息是：" + content);
        return text2XML(textMessage);
    }

    /**
     * 文本消息转为xml
     */
    public static String text2XML(TextMessage textMessage){
        XStream xStream = new XStream();
        // 将根结点的标签替换成xml
        xStream.alias("xml", textMessage.getClass());
        return xStream.toXML(textMessage);
    }

}
