package zup.orangetalents.loterrychallenge.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import zup.orangetalents.loterrychallenge.entities.Player;

public class PlayerUpdateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank
	@Email(message = "Please Entry with a Valid E-mail")
	private String email;
	
	public PlayerUpdateDTO() {
	}

	public PlayerUpdateDTO(Long id, String email) {
		this.id = id;
		this.email = email;
	}
		
	public PlayerUpdateDTO(Player entity) {
		id = entity.getId();
		email = entity.getEmail();
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
}
