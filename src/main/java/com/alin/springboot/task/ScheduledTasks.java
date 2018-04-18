package com.alin.springboot.task;

import com.alin.springboot.framework.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description 类描述：定时任务范例
 * @Author 创建人：linying
 * @Date 创建时间：2018/4/18 10:07
 * @Version 版本号：v1.0.0
 */
@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    //corn从左到右（用空格隔开）：秒 分 小时 月份中的日期 月份 星期中的日期 年份(可选)
    @Scheduled(cron = "0 */1 * * * ?")
    public void reportCurrentTime() {
        log.info("The time is now {}", DateUtil.formatDatetimeToStr(new Date()));
    }

}
