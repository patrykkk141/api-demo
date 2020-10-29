package pl.paiw.apidemo.dto;

import lombok.Data;

@Data
public class Task {

    private long id;
    private String title;
    private boolean completed;

}
