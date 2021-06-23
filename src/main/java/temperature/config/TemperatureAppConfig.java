package temperature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import temperature.TemperatureRunner;

@Configuration
public class TemperatureAppConfig {

    @Bean
    public TemperatureRunner temperatureRunner() {
        return new TemperatureRunner();
    }

}
