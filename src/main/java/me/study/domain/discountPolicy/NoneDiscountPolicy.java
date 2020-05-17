package me.study.domain.discountPolicy;

import me.study.domain.Money;
import me.study.domain.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
