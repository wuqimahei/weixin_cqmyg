package cn.yuyangyang.weixin.utils.initMessage;

import cn.yuyangyang.weixin.model.Music;
import cn.yuyangyang.weixin.model.MusicMessage;
import cn.yuyangyang.weixin.utils.Const;
import com.thoughtworks.xstream.XStream;

import java.util.Date;

public class InitMusicMessage {
    public static String initMusic(String toUserName, String fromUserName, String title,
                                   String desc, String url, String hqUrl, String thumb){
        Music music = new Music();
        music.setTitle(title);
        music.setDescription(desc);
        music.setMusicUrl(url);
        music.setHQMusicUrl(hqUrl);
        music.setThumbMediaId(thumb);

        MusicMessage musicMessage = new MusicMessage();
        musicMessage.setToUserName(fromUserName);
        musicMessage.setFromUserName(toUserName);
        musicMessage.setCreateTime(new Date().getTime());
        musicMessage.setMsgType(Const.MESSAGE_MUSIC);
        musicMessage.setMusic(music);
        return music2XML(musicMessage);
    }

    public static String music2XML(MusicMessage musicMessage){
        XStream xStream = new XStream();
        // 将根结点的标签替换成xml
        xStream.alias("xml", musicMessage.getClass());
        return xStream.toXML(musicMessage);
    }

}
