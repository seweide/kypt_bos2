package net.liangyihui.manager.kypt.bos;

import net.liangyihui.std.web.common.exception.GlobalExceptionHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author liu_y
 */

@SpringBootApplication
@ComponentScan(
        basePackages = {"net.liangyihui"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                value = GlobalExceptionHandler.class))
@MapperScan({"net.liangyihui.manager.kypt.bos.mapper"})
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
    }

}
