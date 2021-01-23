package zup.orangetalents.loterrychallenge.dto;

import java.io.Serializable;
import java.time.Instant;

import zup.orangetalents.loterrychallenge.entities.Bet;

public class BetFindByEmailDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String betNumbers;
	private Instant creatAt;
	
	public BetFindByEmailDTO() {
	}

	public BetFindByEmailDTO(Long id, String betNumbers, Instant creatAt) {
		this.id = id;
		this.betNumbers = betNumbers;
		this.creatAt = creatAt;
	}
	
	public BetFindByEmailDTO(Bet entity) {
		id = entity.getId();
		betNumbers = entity.getBetNumbers();
		creatAt = entity.getCreatAt();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBetNumbers() {
		return betNumbers;
	}

	public void setBetNumbers(String betNumbers) {
		this.betNumbers = betNumbers;
	}

	public Instant getCreatAt() {
		return creatAt;
	}

	public void setCreatAt(Instant creatAt) {
		this.creatAt = creatAt;
	}

}
