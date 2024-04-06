package com.project.shopapp.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.shopapp.models.Product;
import com.project.shopapp.models.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data//toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("content")
    private String content;
}
