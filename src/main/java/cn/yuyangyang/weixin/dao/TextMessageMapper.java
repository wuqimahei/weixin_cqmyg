package cn.yuyangyang.weixin.dao;

import cn.yuyangyang.weixin.model.TextMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface TextMessageMapper extends BaseMapper<TextMessage> {
    // 根据关键词自动回复
    String selectByKeyword(String keyword);
    // 新增一个自动回复
    int insertTextMessage(TextMessage textMessage);
    // 删除某关键字自动回复
    int deleteTextMessage(String keyword);

}
