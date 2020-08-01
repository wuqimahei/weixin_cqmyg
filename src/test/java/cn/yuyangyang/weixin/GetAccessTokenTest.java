package cn.yuyangyang.weixin;

import cn.yuyangyang.weixin.model.AccessToken;
import cn.yuyangyang.weixin.utils.GetAccessToken;
import cn.yuyangyang.weixin.utils.UploadFile;
import org.junit.jupiter.api.Test;

public class GetAccessTokenTest {

    /**
     * 35_Xb-QMtsn2FNnGv0rtoFUgVbsc3V61vmd2FVVVKMZyRGhTRGw_9SYL7XvvM5mMsMHbHNtd5_JYLH5ELclSdpDJSr0cSqul8CG8IdD0gxSpAUDlppB1VilkSzRj5EZIPsz8JhpOcksNxLephlXRSUaAHAGHJ
     */
    @Test
    public void getAccessToken() {
        AccessToken accessToken = GetAccessToken.getAccessToken();
        System.out.println("凭据:" + accessToken.getAccess_token());
        System.out.println("时间："+accessToken.getExpires_in());

    }


    /**
     * 获取media_id
     * @throws Exception
     */
    @Test
    public void uploadTest() throws Exception {

        AccessToken accessToken = GetAccessToken.getAccessToken();
        System.out.println("凭据:" + accessToken.getAccess_token());
        System.out.println("时间："+accessToken.getExpires_in());

        String path = "/Users/yuyangyang/Downloads/qrcode_for_gh_ed259a9e7c0b_344.jpg";
        String mediaId = UploadFile.upload(path, accessToken.getAccess_token(), "thumb");
        System.out.println(mediaId);

    }

    // image : Om_sVvF_jV2dMsEWi71lpR_4EPRjaPcRTQZLQLXj6baSfee0qAq8c7hLtNlJfVYW
    // voice : OH9xMuWPUIWEYkLxMGJvTQ1CxqS0YIciQxPyPsgyUiX84F1147-3EhyA1mb2uzhz
    // video : rpvbJ_o_MXWhgbFv8KZokygNvYj4_YhlDQBydS58vDe4a_j8FRADVBXaPac620O4
    // thumb : z7uOhDopw4LHLnFH9wIEW_NFykmosOhE5s4jISzrH17fXgqj8tHsn5L5RRKi_G3P



}
