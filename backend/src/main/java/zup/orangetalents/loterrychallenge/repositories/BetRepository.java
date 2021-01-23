package zup.orangetalents.loterrychallenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import zup.orangetalents.loterrychallenge.entities.Bet;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long>{

	@Query("SELECT DISTINCT obj FROM Bet obj JOIN FETCH obj.player p "
			+ " ORDER BY obj.creatAt DESC")
	List<Bet> findBetWithPlayers();
	
//	@Query("SELECT DISTINCT obj FROM Bet obj JOIN FETCH obj.player p "
//			+ " WHERE p.email LIKE %:email% ORDER BY obj.creatAt DESC")
//	List<Bet> findBetWithPlayerByEmail(@Param("email") String email);
	
}
