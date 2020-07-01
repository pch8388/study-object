package me.study.cooperationPhone.policy;

import me.study.cooperationPhone.Call;
import me.study.cooperationPhone.DateTimeInterval;

import java.util.List;

import static java.util.Collections.singletonList;

public class FixedFeeCondition implements FeeCondition {
    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return singletonList(call.getInterval());
    }
}
