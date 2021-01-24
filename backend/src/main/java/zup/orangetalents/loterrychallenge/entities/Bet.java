package zup.orangetalents.loterrychallenge.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tb_bet")
public class Bet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String betNumbers;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant creatAt;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatAt;
	
	
	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;
	
	public Bet() {
	}

	public Bet(Long id, String betNumbers, Instant creatAt, Player player) {
		this.id = id;
		this.betNumbers = betNumbers;
		this.creatAt = creatAt;
		this.player = player;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBetNumbers() {
		return betNumbers;
	}

	public void setBetNumbers(String betNumbers) {
		this.betNumbers = betNumbers;
	}

	public Instant getCreatAt() {
		return creatAt;
	}

	public Instant getUpdatAt() {
		return updatAt;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
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
		return "Bet [id=" + id + ", betNumbers=" + betNumbers + ", creatAt=" + creatAt + "]";
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
		Bet other = (Bet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
