package cn.yuyangyang.weixin.model;

import com.baomidou.mybatisplus.annotation.TableName;


public class MusicMessage extends BaseMessage {
    private Music Music;

    public cn.yuyangyang.weixin.model.Music getMusic() {
        return Music;
    }

    public void setMusic(cn.yuyangyang.weixin.model.Music music) {
        Music = music;
    }
}
