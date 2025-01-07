package dev.prmts.mculogger.logging;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/logs")
@RequiredArgsConstructor
@Log4j2
public class LogController {
    private final LogService logService;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public McuLog greeting(McuLog s) {
        log.info("received greeting {}", s);
        return s;
    }

    @GetMapping("/{macAddress}/latest")
    public McuLog test(@PathVariable String macAddress) {
        return logService.test(macAddress);
    }

    @PostMapping("/compartment")
    public List<CompartmentLog> compartment(@RequestBody Set<String> macAddresses) {
        return logService.getCompartmentLog(macAddresses);
    }
}
