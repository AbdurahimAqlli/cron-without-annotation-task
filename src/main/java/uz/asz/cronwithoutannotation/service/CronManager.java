package uz.asz.cronwithoutannotation.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.stereotype.Service;
import uz.asz.cronwithoutannotation.event.SchedulerEventListener;
import uz.asz.cronwithoutannotation.event.dto.SchedulerEventDTO;
import uz.asz.cronwithoutannotation.mapper.TaskResultMapper;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class CronManager {
    private final JdbcTemplate jdbcTemplate;
    protected final ApplicationEventPublisher publisher;
    private final SchedulerEventListener schedulerEventListener;

    @Value("${sql}")
    private String sql;

    public CronManager(JdbcTemplate jdbcTemplate, ApplicationEventPublisher publisher, SchedulerEventListener schedulerEventListener) {
        this.jdbcTemplate = jdbcTemplate;
        this.publisher = publisher;
        this.schedulerEventListener = schedulerEventListener;
    }

    @PostConstruct
    public void collectTasks() {
        log.info("Sql for get tasks : {}", sql);
        var taskList = jdbcTemplate.query(sql, new TaskResultMapper());
        log.info("Found all active tasks :{}", taskList);
        taskList.removeIf(task -> !CronExpression.isValidExpression(task.getExpression()));
        log.info("All valid tasks :{}", taskList);
        publisher.publishEvent(new SchedulerEventDTO(taskList));
    }
}
