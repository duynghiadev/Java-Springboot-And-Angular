package com.project.shopapp.responses;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.shopapp.models.Category;
import com.project.shopapp.models.Comment;
import com.project.shopapp.models.OrderDetail;
import com.project.shopapp.models.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentResponse {
    @JsonProperty("content")
    private String content;

    //user's information
    @JsonProperty("user")
    private UserResponse userResponse;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    public static CommentResponse fromComment(Comment comment) {
        return CommentResponse.builder()
                .content(comment.getContent())
                .userResponse(UserResponse.fromUser(comment.getUser()))
                .updatedAt(comment.getUpdatedAt())
                .build();
    }
}
