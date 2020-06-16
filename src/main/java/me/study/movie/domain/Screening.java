package me.study.movie.domain;

import java.time.OffsetDateTime;

public class Screening {
    private final Movie movie;

    public Screening(Movie movie) {
        this.movie = movie;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public boolean isSequence(int sequence) {
        return false;
    }

    public Money getMovieFee() {
        return null;
    }

    public OffsetDateTime getStartTime() {
        return null;
    }
}
