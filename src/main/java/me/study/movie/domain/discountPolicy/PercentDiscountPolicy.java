package me.study.movie.domain.discountPolicy;

import me.study.movie.domain.Money;
import me.study.movie.domain.Screening;
import me.study.movie.domain.discountCondition.DiscountCondition;

public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
