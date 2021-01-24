package zup.orangetalents.loterrychallenge.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import zup.orangetalents.loterrychallenge.entities.Player;

@Data
public class PlayerUpdateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank
	@Email(message = "Please Entry with a Valid E-mail")
	private String email;
	
	public PlayerUpdateDTO() {
	}

	public PlayerUpdateDTO(Player entity) {
		id = entity.getId();
		email = entity.getEmail();
	}

}
