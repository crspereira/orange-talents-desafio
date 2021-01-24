package zup.orangetalents.loterrychallenge.dto;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;
import zup.orangetalents.loterrychallenge.entities.Bet;

@Data
public class BetFindByEmailDTO implements Comparable<BetFindByEmailDTO>, Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String betNumbers;
	private Instant creatAt;
	
	public BetFindByEmailDTO() {
	}
	
	public BetFindByEmailDTO(Bet entity) {
		id = entity.getId();
		betNumbers = entity.getBetNumbers();
		creatAt = entity.getCreatAt();
	}

	@Override
	public int compareTo(BetFindByEmailDTO o) {
		return creatAt.compareTo(o.getCreatAt());
	}

}
