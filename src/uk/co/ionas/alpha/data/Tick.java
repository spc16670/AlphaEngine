package uk.co.ionas.alpha.data;

import java.time.LocalDateTime;

public class Tick {

	private final Pair pair;
	private final Double bid;
	private final Double ask;
	private final LocalDateTime dateTime;
	
	public Tick(Pair pair, Double bid, Double ask, LocalDateTime dateTime) {
		this.pair = pair;
		this.bid = bid;
		this.ask = ask;
		this.dateTime = dateTime;
	}

	public Pair getPair() {
		return pair;
	}

	public Double getBid() {
		return bid;
	}

	public Double getAsk() {
		return ask;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	@Override
	public String toString() {
		return "Tick [pair=" + pair + ", bid=" + bid + ", ask=" + ask + ", dateTime=" + dateTime + "]";
	}
	
}
