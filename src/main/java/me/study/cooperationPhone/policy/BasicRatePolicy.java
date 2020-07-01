package me.study.cooperationPhone.policy;

import me.study.cooperationPhone.Call;
import me.study.cooperationPhone.Phone;
import me.study.movie.domain.Money;

import java.util.Arrays;
import java.util.List;

public final class BasicRatePolicy implements RatePolicy {
    private List<FeeRule> feeRules;

    public BasicRatePolicy(FeeRule... feeRules) {
        this.feeRules = Arrays.asList(feeRules);
    }

    @Override
    public Money calculateFee(Phone phone) {
        return phone.getCalls()
                    .stream()
                    .map(this::calculate)
                    .reduce(Money.ZERO, Money::plus);
    }

    private Money calculate(Call call) {
        return feeRules.stream()
                    .map(rule -> rule.calculateFee(call))
                    .reduce(Money.ZERO, Money::plus);
    }
}
