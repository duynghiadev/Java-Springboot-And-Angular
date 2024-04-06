package com.project.shopapp.responses.coupon;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.shopapp.models.Comment;
import com.project.shopapp.responses.user.UserResponse;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponCalculationResponse {
    @JsonProperty("result")
    private Double result;
}
