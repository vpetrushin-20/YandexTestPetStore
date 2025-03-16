package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Pet {

    public enum Status {
        available,
        sold,
        pending
    }

    private Integer id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private List<Tag> tags;
    private Status status;

}
