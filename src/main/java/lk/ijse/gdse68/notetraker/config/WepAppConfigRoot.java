package lk.ijse.gdse68.notetraker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="lk.ijse.gdse68.notetraker" )
public class WepAppConfigRoot {
}

//why using web application layer 2 - app config direct blanna  app config// data connection handle root config
//configuration class - source for bean definition // kohend bean gnne mona package walinda //application eke configuration kohed hadann kiyl //bean is a spring object is a managing bean object