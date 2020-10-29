package pl.paiw.apidemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private long id;
    private String name;
    private String username;

    private List<Task> tasks;

}
