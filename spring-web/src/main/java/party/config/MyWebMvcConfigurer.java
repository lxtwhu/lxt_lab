package party.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/*env.getSystemProperties().put("spring.freemarker.template-loader-path", "classpath:/static/,classpath:/resources/static/html/");
		env.getSystemProperties().put("spring.freemarker.prefer-file-system-access", "false");
		env.getSystemProperties().put("spring.freemarker.request-context-attribute", "request");
		env.getSystemProperties().put("spring.freemarker.expose-request-attributes", "true");
		env.getSystemProperties().put("spring.freemarker.suffix", ".html");*/

        registry.addResourceHandler("/web/**").addResourceLocations("classpath:/META-INF/resources/", "classpath:/META-INF/resources/static/", "classpath:/resources/static/", "classpath:/resources/", "classpath:/static/", "classpath:/public/");
    }
}
