package cn.yuyangyang.weixin;

import cn.yuyangyang.weixin.service.PassiveReplyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeixinCqmygApplicationTests {


    @Autowired
    private PassiveReplyService passiveReplyService;

    @Test
    void dbTest() {
        String s = passiveReplyService.selectByKeyWord("abc", "dfg", "lxt");
        System.out.println(s);
    }

}
