import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tax.springorm.service.IUserService;


public class Springorm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ctx = new ClassPathXmlApplicationContext!");
        ApplicationContext     ctx = new ClassPathXmlApplicationContext("db/applicationContext-hibernate.xml");
        IUserService service=ctx.getBean("userService",IUserService.class);
        service.saveUser();
        System.out.println("Hello World!");
	}

}
