package me.study.cooperationPhone.policy;

import me.study.cooperationPhone.Phone;
import me.study.movie.domain.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
