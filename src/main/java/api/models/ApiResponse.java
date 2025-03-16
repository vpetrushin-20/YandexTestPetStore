package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiResponse {

    private Integer code;
    private String type;
    private String message;

}
