package pl.paiw.apidemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Scheduler {

    private final IPrinter printer;
    private final ApiService apiService;

    private int counter = 1;

    public Scheduler(IPrinter printer, ApiService apiService) {
        this.printer = printer;
        this.apiService = apiService;
    }

    @Scheduled(fixedRate = 10000)
    public void fetchUsersAndPrint() {
        log.info("Running fetchUsersAndPrint {} time", counter);
        var users = apiService.getUsersWithTasks();
        printer.printUsersWithTasks(users);

        counter++;
    }

}
