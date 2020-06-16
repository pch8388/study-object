package me.study.movie.domain.discountPolicy;

import me.study.movie.domain.Money;
import me.study.movie.domain.Screening;
import me.study.movie.domain.discountCondition.DiscountCondition;

public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
