package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailDTO {
    @JsonProperty("order_id")
    @Min(value=1, message = "Order's ID must be > 0")
    private Long orderId;

    @Min(value=1, message = "Product's ID must be > 0")
    @JsonProperty("product_id")
    private Long productId;

    @Min(value=0, message = "Product's ID must be >= 0")
    private Float price;

    @Min(value=1, message = "number_of_products must be >= 1")
    @JsonProperty("number_of_products")
    private int numberOfProducts;

    @Min(value=0, message = "total_money must be >= 0")
    @JsonProperty("total_money")
    private Float totalMoney;

    private String color;
}
