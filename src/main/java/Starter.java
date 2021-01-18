import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class Starter {

    private static final Logger LOGGER = Logger.getLogger(Starter.class);

    public static void main(String[] args) {
        new Starter().init();
    }



    private void init() {
        Settings settings = new Settings();
        settings.load(Settings.class.getClassLoader().getResourceAsStream("app.properties"));
        long repeatInterval = Long.parseLong(settings.getValue("REPEAT_INTERVAL"));
        JobDetail parserJob = newJob(Parser.class).build();
        Trigger trigger = newTrigger()
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInMilliseconds(repeatInterval).repeatForever())
                .build();
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            scheduler.scheduleJob(parserJob, trigger);
        } catch (SchedulerException exception) {
            LOGGER.log(Level.WARN, exception.getMessage(), exception);
        }
    }
}

