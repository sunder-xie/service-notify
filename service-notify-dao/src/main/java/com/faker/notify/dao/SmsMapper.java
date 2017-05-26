package com.faker.notify.dao;

import com.faker.notify.entity.Sms;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsMapper {
    int deleteByPrimaryKey(Long smsId);

    int insert(Sms record);

    int insertSelective(Sms record);

    Sms selectByPrimaryKey(Long smsId);

    int updateByPrimaryKeySelective(Sms record);

    int updateByPrimaryKey(Sms record);
}