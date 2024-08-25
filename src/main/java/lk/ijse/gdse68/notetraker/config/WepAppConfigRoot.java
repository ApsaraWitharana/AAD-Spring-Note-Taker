package lk.ijse.gdse68.notetraker.config;

import jakarta.persistence.EntityManagerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="lk.ijse.gdse68.notetraker" )
@EnableJpaRepositories(basePackages ="lk.ijse.gdse68.notetraker" )
@EnableTransactionManagement
public class WepAppConfigRoot {
    @Bean //cource code ek nati hinda bean danw nattm component dnna
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean // source for bean definition
    public DataSource dataSource() {
//
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        return builder.setType(EmbeddedDatabaseType.HSQL).build();//testing walat use krn db ekk//test context wlat use krnw //as note connect hibernate so won't to mysql

        //driver manger data source -note connection pool
     var dmds =  new DriverManagerDataSource();
     dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
     dmds.setUrl("jdbc:mysql://localhost:3306/noteTrakerAAD68?createDatabaseIfNotExist=true");
     dmds.setUsername("root");
     dmds.setPassword("ijse@2001");
     return dmds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//vendorAdapter -kenekw connect krnwa hybernet connect krl tiyenne
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
//
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("lk.ijse.gdse68.notetraker.entity");
        factory.setDataSource(dataSource());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        //jpl- eken enne -EntityManagerFactory -hibernate connecter
//translation manage krnn
 //set orm implementation to this method
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
//db confic -application ek puram web patt natuwa ew manage krnne meke
//why using web application layer 2 - app config direct blanna  app config// data connection handle root config
//configuration class - source for bean definition // kohend bean gnne mona package walinda //application eke configuration kohed hadann kiyl //bean is a spring object is a managing bean object
//bean -spring t manage krnn puluwan objec hdnwa