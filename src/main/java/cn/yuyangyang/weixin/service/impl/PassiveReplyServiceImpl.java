package cn.yuyangyang.weixin.service.impl;

import cn.yuyangyang.weixin.dao.*;
import cn.yuyangyang.weixin.model.*;
import cn.yuyangyang.weixin.service.PassiveReplyService;
import cn.yuyangyang.weixin.utils.Const;
import cn.yuyangyang.weixin.utils.initMessage.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassiveReplyServiceImpl implements PassiveReplyService {

    @Autowired
    private KeyWordMapper keyWordMapper;
    @Autowired
    private TextMessageMapper textMessageMapper;
    @Autowired
    private ImageMessageMapper imageMessageMapper;
    @Autowired
    private MusicMessageMapper musicMessageMapper;
    @Autowired
    private VideoMessageMapper videoMessageMapper;
    @Autowired
    private NewsMessageMapper newsMessageMapper;
    @Autowired
    private VoiceMessageMapper voiceMessageMapper;

    @Override
    public String selectByKeyWord(String fromUserName, String toUserName, String content) {

        String message = null;

        // 需要回复什么类型的消息
        QueryWrapper<KeyWord> query = Wrappers.query();
        query.select("type").in("keyword", content);

        KeyWord keyWord = keyWordMapper.selectOne(query);
        if (keyWord == null){
            message = ErrorMessage.errorMessage(toUserName, fromUserName);
            return message;
        }

        // 获取关键字对应的类型
        String type = keyWord.getType();
        if (type.equals(Const.MESSAGE_TEXT)){
            // TODO 要回复文本类型的
            QueryWrapper<TextMessage> queryText = Wrappers.query();
            queryText.select("content").in("keyword", content);
            String textContent = textMessageMapper.selectOne(queryText).getContent();

            message = InitTextMessage.initTextMessage(toUserName, fromUserName, textContent);

        }else if (type.equals(Const.MESSAGE_IMAGE)){
            // 要回复图片类型的
            QueryWrapper<Image> queryImage = Wrappers.query();
            queryImage.select("media_id").in("keyword", content);
            String mediaId = imageMessageMapper.selectOne(queryImage).getMediaId();

            message = InitImageMessage.initImageMessage(toUserName, fromUserName, mediaId);

        }else if (type.equals(Const.MESSAGE_VOICE)){
            // 语音
            QueryWrapper queryVoice = Wrappers.query();
            queryVoice.select("media_id").in("keyword", content);
            String mediaId = voiceMessageMapper.selectOne(queryVoice).getMediaId();

            message = InitVoiceMessage.initVoiceMessage(toUserName, fromUserName, mediaId);

        }else if (type.equals(Const.MESSAGE_VIDEO)){
            // 视频
            QueryWrapper<Video> queryVideo = Wrappers.query();
            queryVideo.select("title", "media_id", "description").in("keyword", content);
            Video video = videoMessageMapper.selectOne(queryVideo);

            String title= video.getTitle() ;
            String mediaId= video.getMediaId() ;
            String description = video.getDescription() ;

            message = InitVideoMessage.initVideo(toUserName, fromUserName, title, mediaId, description);

        }else if (type.equals(Const.MESSAGE_MUSIC)){
            // 音乐
            QueryWrapper<Music> queryMusic = Wrappers.query();
            queryMusic.select("title", "description", "music_url", "hq_music_url", "thumb_media_id").in("keyword", content);
            Music music = musicMessageMapper.selectOne(queryMusic);

            String title = music.getTitle();
            String desc =music.getDescription();
            String url =music.getMusicUrl();
            String hqUrl =music.getHQMusicUrl();
            String thumb =music.getThumbMediaId();

            message = InitMusicMessage.initMusic(toUserName, fromUserName, title, desc, url, hqUrl, thumb);

        }else if (type.equals(Const.MESSAGE_NEWS)){
            // 图文
            QueryWrapper<News> queryNews = Wrappers.query();
            queryNews.select("title", "description", "pic_url", "url").in("keyword", content);
            News news = newsMessageMapper.selectOne(queryNews);

            String title = news.getTitle() ;
            String desc = news.getDescription() ;
            String picUrl = news.getPicUrl() ;
            String url = news.getUrl() ;

            message = InitNewsMessage.initNewsMessage(toUserName, fromUserName, title, desc, picUrl, url);

        }
        return message;
    }

}
