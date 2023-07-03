package cn.tedu.tea.front.server.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@Configuration
@EnableScheduling
public class ScheduleConfiguration {

    public ScheduleConfiguration() {
        log.debug("创建配置类对象：ScheduleConfiguration");
    }

}