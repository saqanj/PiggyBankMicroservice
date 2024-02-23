package cpsc41501.PiggyBank;
import org.springframework.web.server.ResponseStatusException;
/**
 * Simple Piggy Bank Interface.
 *
 * @author Saqlain Anjum
 * @since 02/22/2024
 * @version 1.0.0
 */
public interface PiggyBank{

    /**
     * Adding more money to your piggy bank.
     *
     * @param moreMoney the amount of additional money to add.
     */
    void addMoney(double moreMoney);

    /**
     * Removing money from your piggy bank.
     *
     * @param moneyToGrab Amount desired to remove from piggy bank.
     * @return The amount removed.
     * @throws ResponseStatusException If amount desired is greater than the amount in the bank.
     */
    double removeMoney(double moneyToGrab) throws ResponseStatusException;

    /**
     * Returns a string output, stating the amount of money in your piggy bank.
     *
     * @return Statement regarding the amount of money in your piggy bank.
     */
    String totalMoney();

    /**
     * Changing the total money amount in your piggy bank.
     * @param newMoney new money amount.
     */
    void updateMoney(double newMoney);
}