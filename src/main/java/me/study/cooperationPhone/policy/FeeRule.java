package me.study.cooperationPhone.policy;

import me.study.cooperationPhone.Call;
import me.study.movie.domain.Money;

public class FeeRule {
    //적용 조건
    private FeeCondition feeCondition;
    //단위 시간당 요금
    private FeePerDuration feePerDuration;

    public FeeRule(FeeCondition feeCondition, FeePerDuration feePerDuration) {
        this.feeCondition = feeCondition;
        this.feePerDuration = feePerDuration;
    }

    public Money calculateFee(Call call) {
        return feeCondition.findTimeIntervals(call)
                .stream()
                .map(each -> feePerDuration.calculate(each))
                .reduce(Money.ZERO, Money::plus);
    }
}
