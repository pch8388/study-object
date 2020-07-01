package me.study.cooperationPhone;

import me.study.cooperationPhone.policy.BasicRatePolicy;
import me.study.cooperationPhone.policy.FeePerDuration;
import me.study.cooperationPhone.policy.FeeRule;
import me.study.cooperationPhone.policy.FixedFeeCondition;
import me.study.movie.domain.Money;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneTest {

    @Test
    void calculateFee() {
        Phone phone = new Phone(
            new BasicRatePolicy(
                new FeeRule(
                    new FixedFeeCondition(), new FeePerDuration(Money.wons(10), Duration.ofMinutes(10))
                )));

        assertThat(phone).isNotNull();

        phone.call(new Call(
            LocalDateTime.of(2020, 1, 10, 10, 10),
            LocalDateTime.of(2020, 1, 10, 10, 20)));

        final Money fee = phone.calculateFee();
        assertThat(fee.isGreaterThanOrEqual(Money.wons(10))).isTrue();
    }
}