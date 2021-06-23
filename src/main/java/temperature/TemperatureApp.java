package temperature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import temperature.config.TemperatureAppConfig;

@SpringBootApplication
public class TemperatureApp {

    public static void main(String[] args) {
        SpringApplication.run(TemperatureAppConfig.class, args);
    }

}
