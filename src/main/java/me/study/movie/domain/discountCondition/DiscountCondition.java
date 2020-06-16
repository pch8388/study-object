package me.study.movie.domain.discountCondition;

import me.study.movie.domain.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
