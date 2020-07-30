package cn.yuyangyang.weixin.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface PassiveReplyDao {

    String searchByKeyWord(String keyword);
}
