package cn.yuyangyang.weixin.model;

public class VideoMessage extends BaseMessage {
    private  Video Video;

    public cn.yuyangyang.weixin.model.Video getVideo() {
        return Video;
    }

    public void setVideo(cn.yuyangyang.weixin.model.Video video) {
        Video = video;
    }
}
