package me.study.phone.domain;

import me.study.movie.domain.Money;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneTest {

	@Test
	public void calculateFee() {
		Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));
		phone.call(new Call(LocalDateTime.of(2018, 1, 1, 12, 10, 0),
							LocalDateTime.of(2018, 1, 1, 12, 11, 0)));
		phone.call(new Call(LocalDateTime.of(2018, 1, 2, 12, 10, 0),
							LocalDateTime.of(2018, 1, 2, 12, 11, 0)));

		assertThat(phone.calculateFee()).isEqualTo(Money.wons(60));
	}
}