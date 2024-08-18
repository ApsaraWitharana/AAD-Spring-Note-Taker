package lk.ijse.gdse68.notetraker;

import lk.ijse.gdse68.notetraker.config.WebAppConfig;
import lk.ijse.gdse68.notetraker.config.WepAppConfigRoot;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WepAppConfigRoot.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

//    public String [] get
}
