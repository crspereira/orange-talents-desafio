package zup.orangetalents.loterrychallenge.dto;

import java.io.Serializable;
import java.time.Instant;

import zup.orangetalents.loterrychallenge.entities.Bet;

public class BetDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String betNumbers;
	private String name;
	private Instant creatAt;
	
	public BetDTO() {
	}

	public BetDTO(Long id, String betNumbers, String name, Instant creatAt) {
		this.id = id;
		this.betNumbers = betNumbers;
		this.name = name;
		this.creatAt = creatAt;	
	}
	
	public BetDTO(Bet entity) {
		id = entity.getId();
		betNumbers = entity.getBetNumbers();
		name = entity.getPlayer().getEmail();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
