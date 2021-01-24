package zup.orangetalents.loterrychallenge.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import zup.orangetalents.loterrychallenge.entities.Player;

@Data
public class PlayerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank
	@Email(message = "Please Entry with a Valid E-mail")
	private String email;
	
	private List<BetFindByEmailDTO> bets = new ArrayList<>();
	
	public PlayerDTO() {
	}
	
	public PlayerDTO(Player entity) {
		id = entity.getId();
		email = entity.getEmail();
		bets = entity.getBets().stream().
			   map(x -> new BetFindByEmailDTO(x)).collect(Collectors.toList());
		//Sorts the Bet List by ASC Creation 
		Collections.sort(bets, Comparator.comparing(BetFindByEmailDTO::getCreatAt));
	}

}
