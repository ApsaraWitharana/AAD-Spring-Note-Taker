package lk.ijse.gdse68.notetraker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="lk.ijse.gdse68.notetraker" )
@EnableJpaRepositories
@EnableTransactionManagement
public class WebAppConfig {
    //direct interface wen nati  config danne

}
