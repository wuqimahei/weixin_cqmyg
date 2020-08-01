package cn.yuyangyang.weixin.utils.initMessage;

public class ErrorMessage {
    public static String errorMessage(String toUserName, String fromUserName){

        String msg = "消息不存在，请确认关键字后重新发送。";

        return InitTextMessage.initTextMessage(toUserName, fromUserName, msg);
    }
}
