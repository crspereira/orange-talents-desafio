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

import lombok.Data;


@Data
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
	
	@PrePersist
	public void prePersist() {
		creatAt = Instant.now();
	}
	@PreUpdate
	public void preUpdate() {
		updatAt = Instant.now();
	}

}
