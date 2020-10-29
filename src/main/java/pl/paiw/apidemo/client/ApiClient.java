package pl.paiw.apidemo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.paiw.apidemo.dto.Task;
import pl.paiw.apidemo.dto.User;

import java.util.List;

@FeignClient(value = "jesonplaceholder",
        url = "https://jsonplaceholder.typicode.com/",
        fallback = ApiClientFallback.class)
public interface ApiClient {

    @GetMapping("/users")
    List<User> fetchAllUsers();

    @GetMapping("/users/{userID}/todos")
    List<Task> fetchUserTasks(@PathVariable("userID") final long userId);

}
