package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {

    private Integer id;

    @JsonProperty("username")
    private String  userName;

    private String firstName;
    private String lastName;

    @JsonProperty("email")
    private String eMail;

    private String password;
    private String phone;
    private String userStatus;

}
