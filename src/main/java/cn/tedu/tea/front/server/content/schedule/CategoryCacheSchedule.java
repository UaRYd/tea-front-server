package cn.tedu.tea.front.server.content.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CategoryCacheSchedule {

    public CategoryCacheSchedule() {
        log.debug("创建计划任务组件对象：CategoryCacheSchedule");
    }

    //@Scheduled(fixedRate = 2 * 1000)
    @Scheduled(cron = "* * * * * *")
    public void xxx() {
        log.debug("开始执行【重建缓存中的类别列表】计划任务");
    }
}
