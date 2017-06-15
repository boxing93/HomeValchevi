package HomeValchevi.Config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Created by Iliya on 15.6.2017 г..
 */

@Configuration
public class MvcConfig {

    @Bean
    public EmbeddedServletContainerCustomizer notFoundCustomizer(){
        return new NotFoundIndexTemplate();
    }

    private static class NotFoundIndexTemplate implements EmbeddedServletContainerCustomizer {
        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/"));
        }

    }
}