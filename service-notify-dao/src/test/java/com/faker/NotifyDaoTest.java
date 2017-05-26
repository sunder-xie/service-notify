package com.faker;

import com.faker.notify.dao.SmsMapper;
import com.faker.notify.entity.Sms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(locations = "classpath:application.yml")
public class NotifyDaoTest {

	@Autowired
	private SmsMapper smsMapper;

	@Test
	public void insertTest() {
		Sms sms = smsMapper.selectByPrimaryKey(1L);
		System.out.println(sms.getContent());
	}

}
