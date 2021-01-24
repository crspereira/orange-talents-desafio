package zup.orangetalents.loterrychallenge.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tb_player")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant creatAt;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatAt;
	
	//@JsonIgnore
	@OneToMany(mappedBy = "player")
	private List<Bet> bets = new ArrayList<>();
	
	public Player() {
	}

	public Player(Long id, String email) {
		this.id = id;
		this.email = email;
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
	
	public Instant getCreatAt() {
		return creatAt;
	}

	public Instant getUpdatAt() {
		return updatAt;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> list) {
		this.bets = list;
	}
	
	@PrePersist
	public void prePersist() {
		creatAt = Instant.now();
	}
	@PreUpdate
	public void preUpdate() {
		updatAt = Instant.now();
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
