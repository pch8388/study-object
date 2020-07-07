package me.study.cooperationPhone.policy;

import me.study.cooperationPhone.Call;
import me.study.cooperationPhone.DateTimeInterval;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DayOfWeekFeeCondition implements FeeCondition {
    private List<DayOfWeek> dayOfWeeks;

    public DayOfWeekFeeCondition(DayOfWeek... dayOfWeeks) {
        this.dayOfWeeks = Arrays.asList(dayOfWeeks);
    }

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return call.getInterval().splitByDay()
                    .stream()
                    .filter(each -> dayOfWeeks.contains(each.getFrom().getDayOfWeek()))
                    .collect(toList());
    }
}
