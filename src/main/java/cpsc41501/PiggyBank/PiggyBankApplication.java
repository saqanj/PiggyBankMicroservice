package cpsc41501.PiggyBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Map;


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

	@GetMapping("/config")
	public String config(){
		Collection<Map.Entry<String, String>> configData = System.getenv().entrySet();

		// Logging the configuration data
		for (Map.Entry<String, String> entry : configData) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		// Convert the collection to JSON array manually
		StringBuilder jsonArrayBuilder = new StringBuilder("[");
		boolean firstEntry = true;
		for (Map.Entry<String, String> entry : configData) {
			if (!firstEntry) {
				jsonArrayBuilder.append(",");
			} else {
				firstEntry = false;
			}
			jsonArrayBuilder.append("{\"key\":\"")
					.append(entry.getKey())
					.append("\",\"value\":\"")
					.append(entry.getValue())
					.append("\"}");
		}
		jsonArrayBuilder.append("]");

		return jsonArrayBuilder.toString();
	}

	@RequestMapping(value = "/fib", method = RequestMethod.GET)
	public String fib(@RequestParam("length") int length) {
		if (length <= 0) {
			return "Invalid length. Please provide a positive integer.";
		}

		// Generate Fibonacci sequence
		int[] fibonacci = new int[length];
		fibonacci[0] = 0;
		if (length > 1) {
			fibonacci[1] = 1;
			for (int i = 2; i < length; i++) {
				fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
			}
		}

		// Convert the array to JSON format
		StringBuilder result = new StringBuilder("[");
		for (int i = 0; i < length; i++) {
			result.append(fibonacci[i]);
			if (i < length - 1) {
				result.append(",");
			}
		}
		result.append("]");

		return result.toString();
	}
}
