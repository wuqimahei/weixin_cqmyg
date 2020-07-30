package cn.yuyangyang.weixin.utils;

public class Const {

    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_VOICE = "voice";
    public static final String MESSAGE_VIDEO = "video";
    public static final String MESSAGE_MUSIC = "music";
    public static final String MESSAGE_NEWS = "news";


    /**
     * Event 包含关注和取关
     * 关注和取关的MsgType都是Event
     *
     * 再次通过标签Event判断是关注还是取关
     */
    public static final String MESSAGE_EVENT = "event";
    // 关注
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    // 取关
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    // click菜单
    public static final String MESSAGE_CLICK = "click";
    // view菜单
    public static final String MESSAGE_VIEW = "view";

}
