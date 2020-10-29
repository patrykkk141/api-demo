package pl.paiw.apidemo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.paiw.apidemo.dto.User;

import java.util.List;

@Service
@Profile("consolePrinter")
public class ConsolePrinter implements IPrinter {

    @Override
    public void printUsersWithTasks(final List<User> users) {
        users.forEach(user -> {
            System.out.println();
            printHeader(user.getId(), user.getUsername());
            user.getTasks().forEach(task -> printTask(task.isCompleted(), task.getTitle()));
        });
    }

    private void printHeader(final long userId, final String username) {
        System.out.print(String.format(USER_HEADER_PATTERN, userId, username));
    }

    private void printTask(final boolean completed, final String title) {
        System.out.print(String.format(TASK_PATTERN, completed ? "*" : " ", title));
    }
}
