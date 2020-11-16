package popelos.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import popelos.converter.AuthorConverter;
import popelos.converter.CategoryConverter;

@Configuration//This class is the equivalent of dispatcher-servlet.xml
@EnableWebMvc
@ComponentScan(basePackages = "popelos")
public class MyWebAppConfig implements WebMvcConfigurer {
    
    
    @Autowired
    AuthorConverter authorConverter;
    @Autowired
    CategoryConverter categoryConverter;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

//    @Bean//this annotation puts the returning object into the Spring Container
//    MyInterceptor myInterceptor() {
//        return new MyInterceptor();
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyInterceptor());
//    }

//    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }

    @Bean
    @Override
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        bean.setValidationMessageSource(messageSource);
        return bean;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
      registry.addConverter(authorConverter);
      registry.addConverter(categoryConverter);
    }
    
    

}
