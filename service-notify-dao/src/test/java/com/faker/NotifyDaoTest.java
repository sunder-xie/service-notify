package com.faker;

import com.faker.notify.DaoApplication;
import com.faker.notify.dao.SmsMapper;
import com.faker.notify.entity.Sms;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DaoApplication.class)
public class NotifyDaoTest {

	private static final Logger logger = LogManager.getLogger(NotifyDaoTest.class);

	@Autowired
	private SmsMapper smsMapper;

	@Test
	public void insertTest() {
		Sms sms = smsMapper.selectByPrimaryKey(1L);
		System.out.println(sms.getContent());
		logger.info("123");
	}

}
