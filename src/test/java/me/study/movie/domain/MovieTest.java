package me.study.movie.domain;

import me.study.movie.domain.discountCondition.PeriodCondition;
import me.study.movie.domain.discountCondition.SequenceCondition;
import me.study.movie.domain.discountPolicy.AmountDiscountPolicy;
import me.study.movie.domain.discountPolicy.NoneDiscountPolicy;
import me.study.movie.domain.discountPolicy.PercentDiscountPolicy;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class MovieTest {

    @Test
    public void movie_create() {
        Movie avatar = new Movie("아바타",
            Duration.ofMinutes(120),
            Money.wons(10000),
            new AmountDiscountPolicy(Money.wons(800),
                new SequenceCondition(1),
                new SequenceCondition(10),
                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));

        assertThat(avatar).isInstanceOf(Movie.class);

        Movie titanic = new Movie("타이타닉",
            Duration.ofMinutes(180),
            Money.wons(11000),
            new PercentDiscountPolicy(0.1,
                new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                new SequenceCondition(2),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))));

        assertThat(titanic).isInstanceOf(Movie.class);

        Movie starWars = new Movie("스타워즈",
            Duration.ofMinutes(210),
            Money.wons(10000),
            new NoneDiscountPolicy());

        assertThat(starWars).isInstanceOf(Movie.class);

    }

    @Test
    public void change_discountPolicy() {
        Movie avatar = new Movie("아바타",
            Duration.ofMinutes(120),
            Money.wons(10000),
            new AmountDiscountPolicy(Money.wons(800),
                new SequenceCondition(1),
                new SequenceCondition(10),
                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));

        avatar.changeDiscountPolicy(new PercentDiscountPolicy(0.1,
            new SequenceCondition(1),
            new SequenceCondition(10),
            new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
            new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));

        // FIXME: 2020/05/18  정상적인 실행만 확인 , 테스트 코드 추가 필요 -ksc
    }
}