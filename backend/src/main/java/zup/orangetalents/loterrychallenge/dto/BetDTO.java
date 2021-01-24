package zup.orangetalents.loterrychallenge.dto;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;
import zup.orangetalents.loterrychallenge.entities.Bet;

@Data
public class BetDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String betNumbers;
	private String email;
	private Instant creatAt;
	
	public BetDTO() {
	}

	public BetDTO(Bet entity) {
		id = entity.getId();
		betNumbers = entity.getBetNumbers();
		email = entity.getPlayer().getEmail();
		creatAt = entity.getCreatAt();
	}

}
