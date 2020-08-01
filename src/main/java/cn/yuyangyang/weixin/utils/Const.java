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

    // 上传素材获取media_id 的路径
    public static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";

    public static final String APPID = "***";
    public static final String APPSECRET = "***";
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";


}
