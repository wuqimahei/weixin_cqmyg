package cn.yuyangyang.weixin.model;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <Image></Image>标签所包含的内容
 */
@TableName("wx_image_message")
public class Image {
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
