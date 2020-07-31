package cn.yuyangyang.weixin.dao;

import cn.yuyangyang.weixin.model.KeyWord;
import cn.yuyangyang.weixin.model.TextMessage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface PassiveReplyDao extends BaseMapper<KeyWord> {

}
