package cn.yuyangyang.weixin.model;

import com.baomidou.mybatisplus.annotation.TableName;

public class VoiceMessage extends BaseMessage {

    private Voice Voice;

    public cn.yuyangyang.weixin.model.Voice getVoice() {
        return Voice;
    }

    public void setVoice(cn.yuyangyang.weixin.model.Voice voice) {
        Voice = voice;
    }
}
