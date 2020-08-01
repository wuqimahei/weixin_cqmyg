package cn.yuyangyang.weixin.utils.initMessage;

import cn.yuyangyang.weixin.model.Image;
import cn.yuyangyang.weixin.model.ImageMessage;
import cn.yuyangyang.weixin.model.Voice;
import cn.yuyangyang.weixin.model.VoiceMessage;
import cn.yuyangyang.weixin.utils.Const;
import com.thoughtworks.xstream.XStream;

import java.util.Date;

public class InitVoiceMessage {
    // 初始化语音消息
    public static String initVoiceMessage(String toUserName, String fromUserName, String mediaId){
        String message = null;
        Voice voice = new Voice();

        voice.setMediaId(mediaId);
        VoiceMessage voiceMessage = new VoiceMessage();
        voiceMessage.setFromUserName(toUserName);
        voiceMessage.setToUserName(fromUserName);
        voiceMessage.setMsgType(Const.MESSAGE_VOICE);
        voiceMessage.setCreateTime(new Date().getTime());
        voiceMessage.setVoice(voice);
        message = voice2XML(voiceMessage);
        System.out.println(message);
        return message;
    }

    // 图片消息转xml
    public static String voice2XML(VoiceMessage voiceMessage){
        XStream xStream = new XStream();
        // 将根结点的标签替换成xml
        xStream.alias("xml", voiceMessage.getClass());
        return xStream.toXML(voiceMessage);
    }
}
