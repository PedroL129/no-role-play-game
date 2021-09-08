package com.pedrol129.nrpg.decision;

import lombok.Getter;

@Getter
public class DecisionService {

	private DecisionType type = DecisionType.AUTO;

	private Decision decision = new AutoDecision();

	public void setType(DecisionType type) {
		this.type = type;

		switch (this.type) {
		case AUTO:
			this.decision = new AutoDecision();
			break;
		case MANUAL:
			this.decision = new ManualDecision(0);
			break;
		case MIXED:
			this.decision = new ManualDecision(15);
			break;
		default:
			this.decision = new AutoDecision();
			break;
		}
	}
}
