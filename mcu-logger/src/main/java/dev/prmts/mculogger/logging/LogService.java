package dev.prmts.mculogger.logging;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Log4j2
public class LogService {
    private final LogRepository logRepository;

    public void save(McuLog mcuLog) {
        logRepository.save(mcuLog);
    }

    public McuLog test(String macAddress) {
        return logRepository.findByIdAndLatest(macAddress);
    }

    public List<CompartmentLog> getCompartmentLog(Set<String> macAddress) {
        return logRepository.findCompartmentLogByMacAddresses(macAddress);
    }
}
