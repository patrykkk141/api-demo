package pl.paiw.apidemo.service;

import pl.paiw.apidemo.dto.User;

import java.util.List;

public interface IPrinter {

    String USER_HEADER_PATTERN = "User #%d (%s) \n";
    String TASK_PATTERN = "[%s] task: %s \n";

    void printUsersWithTasks(final List<User> users);

}
