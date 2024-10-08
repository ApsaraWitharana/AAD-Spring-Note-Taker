package lk.ijse.gdse68.notetraker.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="lk.ijse.gdse68.notetraker" )
@EnableJpaRepositories
@EnableTransactionManagement
//@MultipartConfig //flie system cofige krnne -  // multipart form data handle krnne config wenwa meken  //nikmm dmmot eket applies wenne default value //multipart form data wl blandish configuration  handle krnn use we //
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, //2MB //upload krn file eke -ekathuwa file wal 1MB nam eke file ek process krn use krnne ram ek ek 2 t adu unam primary memory eke //4MB unot ek use krnne  ek file system ek//tiyen mb gane ekk awot ek ram ekt ynw nattm threshold ekk dal  seconder memary ekt ynw
        maxFileSize = 1024 * 1024 * 10, // upload krn allow krn maximum file eke size eke //ex-10MB
        maxRequestSize = 1024 * 1024 * 50 // upload file ekth ekk sampurna data wal ekthuwa //50MB
)
public class WebAppConfig {
    //direct interface wen nati  config danne
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") // This allows CORS for all endpoints
//                .allowedOrigins("http://localhost:63343") // Allow only your frontend domain
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // Specify allowed HTTP methods
//                .allowedHeaders("*") // Allow all headers
//                .allowCredentials(true);
//    }

}
