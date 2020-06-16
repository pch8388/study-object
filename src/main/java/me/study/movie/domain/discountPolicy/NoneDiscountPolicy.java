package me.study.movie.domain.discountPolicy;

import me.study.movie.domain.Money;
import me.study.movie.domain.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
