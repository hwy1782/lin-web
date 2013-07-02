package com.touchhy.web.linweb.test;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ActiveProfiles("test")
@ContextConfiguration(locations = { "classpath:applicationContext.xml","/test-bean.xml"})
@TransactionConfiguration(defaultRollback=false)
public class BaseDAOTest extends AbstractTransactionalJUnit4SpringContextTests {
}
