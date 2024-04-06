package com.project.shopapp.repositories;
import com.project.shopapp.models.CouponCondition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface CouponConditionRepository extends JpaRepository<CouponCondition, Long> {
    List<CouponCondition> findByCouponId(long couponId);
}
