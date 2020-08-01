package cn.yuyangyang.weixin.model;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 图文消息的消息体
 */
@TableName("wx_news_message")
public class News {

    private String Title;
    private String Description;
    private String PicUrl;
    private String Url;


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
