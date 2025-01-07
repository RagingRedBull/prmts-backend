package dev.prmts.mculogger.logging;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
@RequiredArgsConstructor
public class LogAop {
    @Pointcut("execution(* dev.prmts.mculogger.logging.LogService.*(..))")
    public void allLogProcessor() {};

    @Before("allLogProcessor() && args(mcuLog,..)")
    public void logNewMcuLog(JoinPoint joinPoint, McuLog mcuLog) {
        log.info("New Log from {} with sensor values {}", mcuLog.getMacAddress(), mcuLog.getSensorLogs());
    }
}
