package com.faker.notify.dao;

import com.faker.notify.entity.Template;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TemplateMapper {
    int deleteByPrimaryKey(Integer templateId);

    int insertSelective(Template record);

    Template selectByPrimaryKey(Integer templateId);

    int updateByPrimaryKeySelective(Template record);

}