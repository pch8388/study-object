package me.study.cooperationPhone.policy;

import me.study.cooperationPhone.Call;
import me.study.cooperationPhone.DateTimeInterval;

import java.time.Duration;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class DurationFeeCondition implements FeeCondition {
    private Duration from;
    private Duration to;

    public DurationFeeCondition(Duration from, Duration to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        if (call.getInterval().duration().compareTo(from) < 0) {
            return emptyList();
        }

        return singletonList(DateTimeInterval.of(
            call.getInterval().getFrom().plus(from),
            call.getInterval().duration().compareTo(to) > 0 ?
                call.getInterval().getFrom().plus(to) :
                call.getInterval().getTo()
        ));
    }
}
