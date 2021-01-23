package zup.orangetalents.loterrychallenge.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import zup.orangetalents.loterrychallenge.entities.Player;

public class PlayerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank
	@Email(message = "Please Entry with a Valid E-mail")
	private String email;
	
	private List<BetFindByEmailDTO> bets = new ArrayList<>();
	
	public PlayerDTO() {
	}

	public PlayerDTO(Long id, String email) {
		this.id = id;
		this.email = email;
	}
		
	public PlayerDTO(Player entity) {
		id = entity.getId();
		email = entity.getEmail();
		bets = entity.getBets().stream().
			   map(x -> new BetFindByEmailDTO(x)).collect(Collectors.toList());
		//Sorts the Bet List by ASC Creation 
		Collections.sort(bets, Comparator.comparing(BetFindByEmailDTO::getCreatAt));
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
