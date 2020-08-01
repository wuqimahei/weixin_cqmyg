package cn.yuyangyang.weixin.utils.initMessage;

import cn.yuyangyang.weixin.model.News;
import cn.yuyangyang.weixin.model.NewsMessage;
import cn.yuyangyang.weixin.utils.Const;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.Date;

public class InitNewsMessage {
    /**
     * 拼装图文消息
     */
    public static String initNewsMessage(String toUserName, String fromUserName,
                                         String title, String desc, String picUrl, String url){

        String message = null;
        ArrayList<News> newsList = new ArrayList<>();
        NewsMessage newsMessage = new NewsMessage();

        /**
         * 图文消息个数；当用户发送文本、图片、语音、视频、图文、地理位置这六种消息时，开发者只能回复1条图文消息；其余场景最多可回复8条图文消息
         * https://mp.weixin.qq.com/cgi-bin/announce?action=getannouncement&announce_id=115383153198yAvN&version=&lang=zh_CN&token=
         */
        News news = new News();
        news.setTitle(title);
        news.setDescription(desc);
        news.setPicUrl(picUrl);
        news.setUrl(url);

        newsList.add(news);

        newsMessage.setFromUserName(toUserName);
        newsMessage.setToUserName(fromUserName);
        newsMessage.setCreateTime(new Date().getTime());
        newsMessage.setMsgType(Const.MESSAGE_NEWS);
        newsMessage.setArticleCount(newsList.size());
        newsMessage.setArticles(newsList);

        message = news2XML(newsMessage);
        return message;
    }

    /**
     * 图文消息转为xml
     */
    public static String news2XML(NewsMessage newsMessage){
        XStream xStream = new XStream();
        // 将根结点的标签替换成xml
        xStream.alias("xml", newsMessage.getClass());
        // 消息体使用的是item标签
        xStream.alias("item", new News().getClass());
        return xStream.toXML(newsMessage);
    }
}
