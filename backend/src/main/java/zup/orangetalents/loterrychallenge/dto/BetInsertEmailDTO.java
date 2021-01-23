package zup.orangetalents.loterrychallenge.dto;

import java.io.Serializable;

public class BetInsertEmailDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
