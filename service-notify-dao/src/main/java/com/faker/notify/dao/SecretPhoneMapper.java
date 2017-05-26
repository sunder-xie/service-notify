package com.faker.notify.dao;

import com.faker.notify.entity.SecretPhone;

public interface SecretPhoneMapper {
    int deleteByPrimaryKey(Long secretId);

    int insert(SecretPhone record);

    int insertSelective(SecretPhone record);

    SecretPhone selectByPrimaryKey(Long secretId);

    int updateByPrimaryKeySelective(SecretPhone record);

    int updateByPrimaryKey(SecretPhone record);
}