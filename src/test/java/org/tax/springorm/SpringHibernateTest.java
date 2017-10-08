package org.tax.springorm;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tax.springorm.service.IUserService;

public class SpringHibernateTest {
    private static ApplicationContext ctx = null;

    @BeforeClass 
    public static void onlyOnce() {
    	System.out.println("ctx = new ClassPathXmlApplicationContext!");
         ctx = new ClassPathXmlApplicationContext("db/applicationContext-hibernate.xml");
    }

    @Test
    public void testSave(){
        IUserService service=ctx.getBean("userService",IUserService.class);
        service.saveUser();
        System.out.println("Hello World!");
    }
    
//    @Test
    public void testSaveThrowException() throws Exception{
        IUserService service=ctx.getBean("userService",IUserService.class);
        service.saveUserThrowException();
    }
    
   // @Test
    public void testJDBCDaoQuery(){
        IUserService service=ctx.getBean("userService",IUserService.class);
        service.findUsers();
    }
}