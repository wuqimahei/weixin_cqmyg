package cn.yuyangyang.weixin.model;

public class MusicMessage extends BaseMessage {
    private Music Music;

    public cn.yuyangyang.weixin.domain.Music getMusic() {
        return Music;
    }

    public void setMusic(cn.yuyangyang.weixin.domain.Music music) {
        Music = music;
    }
}
