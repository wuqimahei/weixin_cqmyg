package cn.yuyangyang.weixin.model;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("wx_voice_message")
public class Voice {
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
