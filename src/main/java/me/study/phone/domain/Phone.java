package me.study.phone.domain;

import me.study.movie.domain.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {

	private List<Call> calls = new ArrayList<>();

	public void call(Call call) {
		this.calls.add(call);
	}

	public Money calculateFee() {
		Money result = Money.ZERO;

		for (Call call : calls) {
			result = result.plus(calculateCallFee(call));
		}

		return result;
	}

	protected abstract Money calculateCallFee(Call call);

}
