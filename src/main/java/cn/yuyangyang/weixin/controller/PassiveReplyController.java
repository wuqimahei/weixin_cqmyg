package cn.yuyangyang.weixin.controller;

import cn.yuyangyang.weixin.service.PassiveReplyService;
import cn.yuyangyang.weixin.utils.Const;
import cn.yuyangyang.weixin.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 被动回复用户消息
 */
@Controller
public class PassiveReplyController {

    @Autowired
    private PassiveReplyService passiveReplyService;


    // 接收用户发送过来的信息
    @RequestMapping(value = "wx", method = RequestMethod.POST)
    public void userSend(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // 用户发过来的是xml格式，转为 map
        Map<String, String> map = MessageUtil.xml2Map(request);

        /**
         * ToUserName	开发者微信号
         * FromUserName	发送方帐号（一个OpenID）
         * CreateTime	消息创建时间 （整型）
         * MsgType	消息类型，文本为text
         * MsgId	消息id，64位整型
         */
        String toUserName = map.get("ToUserName");
        String fromUserName = map.get("FromUserName");
        String msgType = map.get("MsgType");
        String createTime = map.get("CreateTime");
        String msgId = map.get("MsgId");

        String message = null;
        /**
         * 根据 MsgType 寻找不同 Service
         */
        if (msgType.equals(Const.MESSAGE_TEXT)){
            // 接收到的是用户发来的文本消息
            // 文本消息包含 content
            String content = map.get("Content");
            message = passiveReplyService.selectByKeyWord(fromUserName, toUserName, content);
        }else if (msgType.equals(Const.MESSAGE_IMAGE)){
            // 接收到的是用户发来的图片消息
            // 图片消息包含 PicUrl MediaId
            String picUrl = map.get("PicUrl");
            String mediaId = map.get("MediaId");
        }
        // TODO 其他消息
        out.print(message);
        out.close();
    }
}
