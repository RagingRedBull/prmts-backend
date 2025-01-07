package dev.prmts.mcusimulator;

import dev.prmts.mcusimulator.log.SendJob;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Configuration
@RequiredArgsConstructor
public class SendLogJobConfig {
    @Bean
    public JobDetail sendLogJob() {
        return JobBuilder.newJob()
                .ofType(SendJob.class)
                .withIdentity("sendLogJob")
                .withDescription("Send Log Job 1")
                .usingJobData("INDEX", 0)
                .build();
    }

    @Bean
    public JobDetail sendLogJob1() {
        return JobBuilder.newJob()
                .ofType(SendJob.class)
                .withIdentity("sendLogJob1")
                .withDescription("Send Log Job 1")
                .usingJobData("INDEX", 1)
                .build();
    }

    @Bean
    public JobDetail sendLogJob2() {
        return JobBuilder.newJob()
                .ofType(SendJob.class)
                .withIdentity("sendLogJob2")
                .withDescription("Send Log Job 2")
                .usingJobData("INDEX", 2)
                .build();
    }

    @Bean
    public JobDetail sendLogJob3() {
        return JobBuilder.newJob()
                .ofType(SendJob.class)
                .withIdentity("sendLogJob3")
                .withDescription("Send Log Job 3")
                .usingJobData("INDEX", 3)
                .build();
    }

    @Bean
    public JobDetail sendLogJob4() {
        return JobBuilder.newJob()
                .ofType(SendJob.class)
                .withIdentity("sendLogJob4")
                .withDescription("Send Log Job 4")
                .usingJobData("INDEX", 4)
                .build();
    }

    @Bean
    public Trigger sendLogTrigger(@Qualifier("sendLogJob") JobDetail jd) {
        return TriggerBuilder.newTrigger()
                .forJob(jd)
                .withDescription("Send Log Trigger 0")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(5))
                .build();
    }

    @Bean
    public Trigger sendLogTrigger1(@Qualifier("sendLogJob1") JobDetail jd) {
        return TriggerBuilder.newTrigger()
                .forJob(jd)
                .withDescription("Send Log Trigger 1")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(3))
                .build();
    }
    @Bean
    public Trigger sendLogTrigger2(@Qualifier("sendLogJob2") JobDetail jd) {
        return TriggerBuilder.newTrigger()
                .forJob(jd)
                .withDescription("Send Log Trigger 2")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(6))
                .build();
    }
    @Bean
    public Trigger sendLogTrigger3(@Qualifier("sendLogJob3") JobDetail jd) {
        return TriggerBuilder.newTrigger()
                .forJob(jd)
                .withDescription("Send Log Trigger 3")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(4))
                .build();
    }@Bean
    public Trigger sendLogTrigger4(@Qualifier("sendLogJob4") JobDetail jd) {
        return TriggerBuilder.newTrigger()
                .forJob(jd)
                .withDescription("Send Log Trigger 4")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(4))
                .build();
    }

}
