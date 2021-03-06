package com.faker.notify.dao;

import com.faker.notify.entity.SecretPhone;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecretPhoneMapper {
    int deleteByPrimaryKey(Long secretId);

    int insertSelective(SecretPhone record);

    SecretPhone selectByPrimaryKey(Long secretId);

    int updateByPrimaryKeySelective(SecretPhone record);

}