package lk.ijse.gdse68.notetraker.config;

import jakarta.servlet.annotation.MultipartConfig;
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
//@MultipartConfig //flie system cofige krnne -  // multipart form data handle krnne config wenwa meken  //nikmm dmmot eket applies wenne default value
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, //2MB //upload krn file eke -ekathuwa file wal 1MB nam eke file ek process krn use krnne ram ek ek 2 t adu unam primary memory eke //4MB unot ek use krnne  ek file system ek
        maxFileSize = 1024 * 1024 * 10, // upload krn allow krn maximum file eke size eke //ex-10MB
        maxRequestSize = 1024 * 1024 * 50 // upload file ekth ekk sampurna data wal ekthuwa //50MB
)
public class WebAppConfig {
    //direct interface wen nati  config danne

}
