package zup.orangetalents.loterrychallenge.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import zup.orangetalents.loterrychallenge.entities.Player;

public class PlayerFindByEmailDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	//private Integer betNumber;
	
	private List<BetFindByEmailDTO> bets = new ArrayList<>();
	
	public PlayerFindByEmailDTO() {
	}

	public PlayerFindByEmailDTO(Long id, String email) {
		this.id = id;
		this.email = email;
	}
	
	public PlayerFindByEmailDTO(Player entity) {
		id = entity.getId();
		email = entity.getEmail();
		//Includes the Bet List 
		bets = entity.getBets().stream().
			   map(x -> new BetFindByEmailDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<BetFindByEmailDTO> getBets() {
		return bets;
	}
}
