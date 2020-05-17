package me.study.domain.discountPolicy;

import me.study.domain.Money;
import me.study.domain.Screening;
import me.study.domain.discountCondition.DiscountCondition;

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
