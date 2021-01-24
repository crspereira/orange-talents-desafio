package zup.orangetalents.loterrychallenge.services;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zup.orangetalents.loterrychallenge.dto.BetDTO;
import zup.orangetalents.loterrychallenge.dto.BetInsertEmailDTO;
import zup.orangetalents.loterrychallenge.entities.Bet;
import zup.orangetalents.loterrychallenge.entities.Player;
import zup.orangetalents.loterrychallenge.entities.util.LotteryNumberGenerator;
import zup.orangetalents.loterrychallenge.repositories.BetRepository;
import zup.orangetalents.loterrychallenge.repositories.PlayerRepository;
import zup.orangetalents.loterrychallenge.services.exceptions.ControllerNotFoundException;

@Service
public class BetService {
	
	@Autowired
	private BetRepository betRepository;
	@Autowired
	private PlayerRepository playerRepository;
	
	@Transactional(readOnly = true)
	public List<BetDTO> findAll() {
		//List<Bet> list = betRepository.findAll();
		List<Bet> list = betRepository.findBetWithPlayers();
		return list.stream().map(x -> new BetDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public BetDTO findById(Long id) {
		Optional<Bet> obj = betRepository.findById(id);
		//Bet entity = obj.get();
		Bet entity = obj.orElseThrow(() -> new ControllerNotFoundException("Entity Not Found!"));
		return new BetDTO(entity);
	}
	
	@Transactional
	public BetDTO insert(BetInsertEmailDTO obj) {
		Player player = playerRepository.findByEmail(obj.getEmail());
		Bet bet;
		System.out.println(obj.getEmail());
		
		if (player != null) {
			System.out.println("This email already exist!");
			bet = new Bet(null, LotteryNumberGenerator.randomLotteryNumber(), Instant.now(), player);
			player.getBets().add(bet);
		} else {
			player = new Player(null, obj.getEmail());
			bet = new Bet(null, LotteryNumberGenerator.randomLotteryNumber(), Instant.now(), player);
			player.setBets(Arrays.asList(bet));
		}
		playerRepository.saveAll(Arrays.asList(player));
		bet = betRepository.save(bet);
		return new BetDTO(bet);
	}
	
}
