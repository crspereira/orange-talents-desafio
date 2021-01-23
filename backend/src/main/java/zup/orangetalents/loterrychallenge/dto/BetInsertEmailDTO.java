package zup.orangetalents.loterrychallenge.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class BetInsertEmailDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Required Field")
	@Email(message = "Please Entry with a Valid E-Mail")
	private String email;
	
	public BetInsertEmailDTO() {	
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
