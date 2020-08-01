package cn.yuyangyang.weixin.model;

import com.baomidou.mybatisplus.annotation.TableName;

public class VideoMessage extends BaseMessage {
    private  Video Video;

    public cn.yuyangyang.weixin.model.Video getVideo() {
        return Video;
    }

    public void setVideo(cn.yuyangyang.weixin.model.Video video) {
        Video = video;
    }
}
