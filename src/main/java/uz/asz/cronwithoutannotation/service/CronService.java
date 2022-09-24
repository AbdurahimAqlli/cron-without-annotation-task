package uz.asz.cronwithoutannotation.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import uz.asz.cronwithoutannotation.domain.Task;

import java.time.LocalDateTime;

@Service
@Slf4j
public class CronService implements SchedulingConfigurer {
    private final JdbcTemplate jdbcTemplate;

    public CronService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ScheduledTaskRegistrar createScheduler(Task task) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.info("Start process at : {}", LocalDateTime.now());
                jdbcTemplate.execute(task.getSql());
            }
        };
        CronTask cronTask = createCronTask(runnable, task.getExpression());
        ScheduledTaskRegistrar taskRegistrar = new ScheduledTaskRegistrar();
        taskRegistrar.addCronTask(cronTask);
        configureTasks(taskRegistrar);
        return taskRegistrar;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.afterPropertiesSet();
    }

    public CronTask createCronTask(Runnable action, String expression) {
        return new CronTask(action, new CronTrigger(expression));
    }
}
