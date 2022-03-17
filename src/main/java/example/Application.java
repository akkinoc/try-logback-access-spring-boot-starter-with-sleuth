package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import javax.servlet.DispatcherType;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean<SleuthAttrsFilter> sleuthAttrsFilter() {
        SleuthAttrsFilter filter = new SleuthAttrsFilter();
        FilterRegistrationBean<SleuthAttrsFilter> bean = new FilterRegistrationBean<>(filter);
        bean.setDispatcherTypes(DispatcherType.FORWARD, DispatcherType.INCLUDE,
                DispatcherType.REQUEST, DispatcherType.ASYNC, DispatcherType.ERROR);
        return bean;
    }

}
