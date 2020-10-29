package pl.paiw.apidemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.paiw.apidemo.dto.Task;
import pl.paiw.apidemo.dto.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@Profile("filePrinter")
public class FilePrinter implements IPrinter {

    private static final String FILE_NAME = "users_with_tasks.txt";

    @Override
    public void printUsersWithTasks(List<User> users) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            users.forEach(user -> {
                appendUserToFile(fw, user);
                user.getTasks().forEach(task -> {
                    appendTaskToFile(fw, task);
                });
            });
        } catch (Exception e) {
            log.error("Cannot open or create file {}", FILE_NAME);
        }
    }

    private void appendUserToFile(FileWriter fw, User user) {
        try {
            printHeader(fw, user.getId(), user.getUsername());
        } catch (IOException e) {
            throw new RuntimeException("Cannot append user to file", e);
        }
    }

    private void appendTaskToFile(FileWriter fw, Task task) {
        try {
            printTask(fw, task.isCompleted(), task.getTitle());
        } catch (IOException e) {
            throw new RuntimeException("Cannot append task to file", e);
        }
    }

    private void printHeader(final FileWriter fw, final long userId, final String username) throws IOException {
        fw.write(String.format(USER_HEADER_PATTERN, userId, username));
    }

    private void printTask(final FileWriter fw, final boolean completed, final String title) throws IOException {
        fw.write(String.format(TASK_PATTERN, completed ? "*" : " ", title));
    }

}
