import be.raja.service.EmployeeService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        EmployeeService service = context.getBean("version1" , EmployeeService.class);
        System.out.println(service.getClass());


    }
}
