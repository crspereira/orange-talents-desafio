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

import lombok.Data;

@Data
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
	
	@OneToMany(mappedBy = "player")
	private List<Bet> bets = new ArrayList<>();
	
	public Player() {
	}
	
	public Player(Long id, String email) {
		this.id = id;
		this.email = email;
	}
	
	@PrePersist
	public void prePersist() {
		creatAt = Instant.now();
	}
	@PreUpdate
	public void preUpdate() {
		updatAt = Instant.now();
	}

}
