package uz.asz.cronwithoutannotation.event.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import uz.asz.cronwithoutannotation.domain.Task;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class SchedulerEventDTO extends ApplicationEvent {
    private List<Task> tasks;

    public SchedulerEventDTO(List<Task> source) {
        super(source);
        this.tasks = source;
    }

}
