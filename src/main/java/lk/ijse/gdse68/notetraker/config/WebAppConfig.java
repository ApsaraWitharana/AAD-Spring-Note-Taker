package lk.ijse.gdse68.notetraker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="lk.ijse.gdse68.notetraker" )
public class WebAppConfig {

}
