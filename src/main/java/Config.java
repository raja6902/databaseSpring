import be.raja.data.EmployeeRepository;
import be.raja.data.EmployeeRepositoryimpl;
import be.raja.service.EmployeeService;
import be.raja.service.EmployeeServiceimpl;
import be.raja.service.EmployeeServiceimplv2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
public class Config {
    @Bean(name= "version1")
    public EmployeeService createEmployeeService(EmployeeRepository repository){
        return new EmployeeServiceimpl(repository);
    }
     @Bean(name = "version2")
    public EmployeeService createEmployeeServicev2(){
        return new EmployeeServiceimplv2();
    }
    @Bean
    public EmployeeRepository createEmployeeRepository(@Qualifier("prod-emf") EntityManagerFactory emf){
        return new EmployeeRepositoryimpl(emf);
    }
    @Bean(name = "prod-emf")
    @Lazy
    public EntityManagerFactory createProductionEMF(){
       return Persistence.createEntityManagerFactory("production-datasource");
    }
    @Bean(name = "test-emf")
    @Lazy
    public  EntityManagerFactory createTestEMF(){
        return Persistence.createEntityManagerFactory("test-datasource");
    }


}
