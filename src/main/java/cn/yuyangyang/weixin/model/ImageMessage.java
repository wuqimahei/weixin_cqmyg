package cn.yuyangyang.weixin.model;

public class ImageMessage extends BaseMessage{

    private Image Image;

    public cn.yuyangyang.weixin.domain.Image getImage() {
        return Image;
    }

    public void setImage(cn.yuyangyang.weixin.domain.Image image) {
        Image = image;
    }
}
