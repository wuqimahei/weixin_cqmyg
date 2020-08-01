package cn.yuyangyang.weixin.dao;

import cn.yuyangyang.weixin.model.News;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsMessageMapper extends BaseMapper<News> {
}
