package cn.yuyangyang.weixin.utils.initMessage;

import cn.yuyangyang.weixin.model.Image;
import cn.yuyangyang.weixin.model.ImageMessage;
import cn.yuyangyang.weixin.utils.Const;
import com.thoughtworks.xstream.XStream;

import java.util.Date;

/**
 * 拼接 图片消息
 */
public class InitImageMessage {


    // 初始化图片消息
    public static String initImageMessage(String toUserName, String fromUserName, String mediaId){
        String message = null;
        Image image = new Image();

        image.setMediaId(mediaId);
        ImageMessage imageMessage = new ImageMessage();
        imageMessage.setFromUserName(toUserName);
        imageMessage.setToUserName(fromUserName);
        imageMessage.setMsgType(Const.MESSAGE_IMAGE);
        imageMessage.setCreateTime(new Date().getTime());
        imageMessage.setImage(image);
        message = image2XML(imageMessage);
        return message;
    }

    // 图片消息转xml
    public static String image2XML(ImageMessage imageMessage){
        XStream xStream = new XStream();
        // 将根结点的标签替换成xml
        xStream.alias("xml", imageMessage.getClass());
        return xStream.toXML(imageMessage);
    }
}
