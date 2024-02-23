package cpsc41501.PiggyBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


/**
 * Personal Piggy Bank Class.
 *
 * @author Saqlain Anjum
 * @since 02/20/2024
 * @version 1.0.0
 */
@SpringBootApplication
@RestController
public class PiggyBankApplication implements PiggyBank{

	public static void main(String[] args) {
		SpringApplication.run(PiggyBankApplication.class, args);
	}

	/**
	 * Private field for the money amount.
	 */
	private double money;


	/**
	 * Adding more money to your piggy bank.
	 *
	 * @param moreMoney the amount of additional money to add.
	 */
	@PostMapping("/addMoney/{amount}")
	@Override
	public void addMoney(double moreMoney) {
		money += moreMoney;
	}

	/**
	 * Removing money from your piggy bank.
	 *
	 * @param moneyToGrab Amount desired to remove from piggy bank.
	 * @return The amount removed.
	 * @throws ResponseStatusException If amount desired is greater than the amount in the bank.
	 */
	@DeleteMapping("/removeMoney/{moneyToGrab}")
	@Override
	public double removeMoney(double moneyToGrab) throws ResponseStatusException{
		if(moneyToGrab <= money){
			money -= moneyToGrab;
			return moneyToGrab;
		} else{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bro, you don't have all that bling!");
		}
	}

	/**
	 * Changing the total money amount in your piggy bank.
	 * @param newMoney new money amount.
	 */
	@PutMapping("/updateMoney/{newMoney}")
	@Override
	public void updateMoney(double newMoney){
		this.money = newMoney;
	}

	/**
	 * Returns a string output, stating the amount of money in your piggy bank.
	 *
	 * @return Statement regarding the amount of money in your piggy bank.
	 */
	@GetMapping("/totalMoney")
	@Override
	public String totalMoney() {
		return "You have: " + money + "$" + " in the Piggy Bank.";
	}

	@GetMapping("/")
	public String defaultResponse() {
		return "Hello.";
	}

}
