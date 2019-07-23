package czt.yonyou.yonyou;
/**
 * h2 内存数据库
 */

import czt.yonyou.dao.AgentRepository;
import czt.yonyou.entity.Agent;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class YonyouApplication {

    @Bean
    InitializingBean saveData(AgentRepository repo){
        return ()->{
            repo.save(new Agent("Get to know Spring Boot","Today I will learn Spring Boot","01/01/2016","s"));
            repo.save(new Agent("Simple Spring Boot Project","I will do my first Spring Boot Project","01/02/2016","s"));
            repo.save(new Agent("Spring Boot Reading","Read more about Spring Boot","02/01/2016","ds"));
            repo.save(new Agent("Spring Boot in the Cloud","Spring Boot using Cloud Foundry","03/01/2016","s"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(YonyouApplication.class, args);
    }

}
