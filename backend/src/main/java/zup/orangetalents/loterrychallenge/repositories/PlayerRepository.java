package zup.orangetalents.loterrychallenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import zup.orangetalents.loterrychallenge.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

	@Query("SELECT DISTINCT obj FROM Player obj JOIN FETCH obj.bets b "
		 + " WHERE 1=1 ORDER BY b.creatAt ASC")
	List<Player> findPlayerWithBets();
	
	//QueryMethod do Spring Data JPA
	Player findByEmail(String email); 
	
}

