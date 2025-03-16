package api.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Order {

    private Integer id;
    private Integer petId;
    private Integer quantity;
    private String shipDate;
    private String status;
    private Boolean complete;

}
