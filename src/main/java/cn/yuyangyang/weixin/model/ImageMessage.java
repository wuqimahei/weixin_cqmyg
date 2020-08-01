package cn.yuyangyang.weixin.model;

import com.baomidou.mybatisplus.annotation.TableName;


public class ImageMessage extends BaseMessage{

    private Image Image;

    public cn.yuyangyang.weixin.model.Image getImage() {
        return Image;
    }

    public void setImage(cn.yuyangyang.weixin.model.Image image) {
        Image = image;
    }
}
