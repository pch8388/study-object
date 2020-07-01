package me.study.cooperationPhone.policy;

import me.study.cooperationPhone.Call;
import me.study.cooperationPhone.DateTimeInterval;

import java.util.List;

// 적용조건
public interface FeeCondition {
    List<DateTimeInterval> findTimeIntervals(Call call);
}
