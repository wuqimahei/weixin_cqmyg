package cn.yuyangyang.weixin.dao;

import cn.yuyangyang.weixin.model.TextMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface TextMessageDao {
    // 根据关键词自动回复
    String selectByKeyword(String keyword);
    // 新增一个自动回复
    int insertTextMessage(TextMessage textMessage);
    // 删除某关键字自动回复
    int deleteTextMessage(String keyword);

}
