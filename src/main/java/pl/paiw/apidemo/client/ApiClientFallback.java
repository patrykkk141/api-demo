package pl.paiw.apidemo.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.paiw.apidemo.dto.Task;
import pl.paiw.apidemo.dto.User;

import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class ApiClientFallback implements ApiClient {

    @Override
    public List<User> fetchAllUsers() {
        log.warn("Cannot fetch users, returning empty list");
        return Collections.emptyList();
    }

    @Override
    public List<Task> fetchUserTasks(long userId) {
        log.warn("Cannot fetch user tasks, returning empty list");
        return Collections.emptyList();
    }
}
