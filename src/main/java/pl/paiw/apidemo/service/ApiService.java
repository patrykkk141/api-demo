package pl.paiw.apidemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.paiw.apidemo.client.ApiClient;
import pl.paiw.apidemo.dto.User;

import java.util.List;

@Service
@Slf4j
public class ApiService {

    private final ApiClient apiClient;

    @Autowired
    public ApiService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<User> getUsersWithTasks() {
        log.debug("Fetching users");
        var users = apiClient.fetchAllUsers();
        getTasksForUsers(users);

        return users;
    }

    private void getTasksForUsers(final List<User> users) {
        users.forEach(user -> {
            log.debug("Fetching tasks for user ({})", user.getId());
            var tasks = apiClient.fetchUserTasks(user.getId());
            user.setTasks(tasks);
        });
    }

}
