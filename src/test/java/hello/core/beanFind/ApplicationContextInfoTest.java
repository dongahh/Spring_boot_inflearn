package hello.core.beanFind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    public void findAllBean(){
        //빈에 정의된 이름을 모두 저장.
       String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
           Object bean =  ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + "Object = " + bean);


        }
    }

    @Test
    @DisplayName("모든 빈 출력")
    public void findApplicationBean(){
        //빈에 정의된 이름을 모두 저장.
       String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
           BeanDefinition beanDefinition =  ac.getBeanDefinition(beanDefinitionName);

           //Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE : 스프링 내부에서 사용하는 빈

           if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
               Object bean =  ac.getBean(beanDefinitionName);
               System.out.println("name = " + beanDefinitionName + "Object = " + bean);


           }

        }
    }

}
