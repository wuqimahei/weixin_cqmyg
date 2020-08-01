package cn.yuyangyang.weixin.utils;

import cn.yuyangyang.weixin.model.AccessToken;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;

/**
 * 获取access_token
 */
public class GetAccessToken {


    /**
     * 通过Get 请求
     */
    public static JSONObject doGetString(String url){

        // 使用RestTemplate发送Get请求
        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(url, String.class);

        JSONObject jsonStr = null;

        if (response != null){
            jsonStr =  JSONObject.parseObject(response);
        }
        return jsonStr;
    }



    /**
     * 获取access_token
     */
    public static AccessToken getAccessToken(){
        AccessToken accessToken = new AccessToken();
        String url = Const.ACCESS_TOKEN_URL.replace("APPID", Const.APPID).replace( "APPSECRET", Const.APPSECRET);
        JSONObject token = doGetString(url);
        if (token != null){
            accessToken.setAccess_token(token.getString("access_token"));
            accessToken.setExpires_in(token.getString("expires_in"));
        }
        return accessToken;
    }
}
