package annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("annotations")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

}
