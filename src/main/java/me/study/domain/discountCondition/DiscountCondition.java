package me.study.domain.discountCondition;

import me.study.domain.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
