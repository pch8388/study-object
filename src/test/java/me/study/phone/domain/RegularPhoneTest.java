package me.study.phone.domain;

import me.study.movie.domain.Money;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class RegularPhoneTest {

	@Test
	public void calculateFee() {
		Phone phone = new RegularPhone(Money.wons(5), Duration.ofSeconds(10), 0.1);
		phone.call(new Call(LocalDateTime.of(2018, 1, 1, 12, 10, 0),
							LocalDateTime.of(2018, 1, 1, 12, 11, 0)));
		phone.call(new Call(LocalDateTime.of(2018, 1, 2, 12, 10, 0),
							LocalDateTime.of(2018, 1, 2, 12, 11, 0)));

		assertThat(phone.calculateFee()).isEqualTo(Money.wons(66));
	}

	@Test
	public void utilClass() {
		Stack<String> stack = new Stack<>();
		stack.push("1st");
		stack.push("2nd");
		stack.push("3rd");

		stack.add(0, "4th");

		assertThat(stack.pop()).isEqualTo("3rd");

		Properties properties = new Properties();
		properties.setProperty("Bjarne Stroustrup", "C++");
		properties.setProperty("James Gosling", "Java");

		properties.put("Dennis Ritchie", 67);
		assertThat(properties.getProperty("Dennis Ritchie")).isNull();
	}
}