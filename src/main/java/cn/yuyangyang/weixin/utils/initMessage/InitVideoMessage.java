package cn.yuyangyang.weixin.utils.initMessage;

import cn.yuyangyang.weixin.model.Video;
import cn.yuyangyang.weixin.model.VideoMessage;
import cn.yuyangyang.weixin.utils.Const;
import com.thoughtworks.xstream.XStream;

import java.util.Date;

public class InitVideoMessage {

    public static String initVideo(String toUserName, String fromUserName,
                                   String title, String mediaId, String desc){

        String message = null;
        Video video = new Video();
        video.setTitle(title);
        // Uxx7udVp8BD8NZTEGPnsKnt1aGAoDdnh_9rCiXFct17XmUqegTbbycdjIgtzRM0n
        video.setMediaId(mediaId);
        video.setDescription(desc);

        VideoMessage videoMessage = new VideoMessage();
        videoMessage.setFromUserName(toUserName);
        videoMessage.setToUserName(fromUserName);
        videoMessage.setCreateTime(new Date().getTime());
        videoMessage.setMsgType(Const.MESSAGE_VIDEO);
        videoMessage.setVideo(video);
        message =  video2XML(videoMessage);
        System.out.println(message);
        return message;
    }

    public static String video2XML(VideoMessage videoMessage){
        XStream xStream = new XStream();
        // 将根结点的标签替换成xml
        xStream.alias("xml", videoMessage.getClass());
        return xStream.toXML(videoMessage);
    }
}
