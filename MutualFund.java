
/**
 * MutualFund.java
 * @author Yadwinder Grewal
 * @author Ansar Shaikh
 * CIS 22C, Lab 6
 */
import java.text.DecimalFormat;

public class MutualFund {
	private final String fundName;
	private final String ticker;
	private double pricePerShare;
	private double tradingFee;

	/** CONSTRUCTORS */

	/**
	 * One arguement constructor, when only ticker is known
	 * 
	 * @param ticker the ticker symbol sets fundName to "No name" and assigns 0 to
	 *               pricePerShare and tradingFee
	 */
	public MutualFund(String ticker) {
		this.ticker = ticker;
		this.fundName = "No Name";
		this.pricePerShare = 0;
		this.tradingFee = 0;
	}

	/**
	 * two arguement constructor, when only name and ticker are known
	 * 
	 * @param name   the name of the fund
	 * @param ticker the ticker symbol Assigns 0 to pricePerShare and tradingFee
	 */
	public MutualFund(String name, String ticker) {
		this.ticker = ticker;
		this.fundName = name;
		this.pricePerShare = 0;
		this.tradingFee = 0;
	}

	/**
	 * Multi-argument constructor when all MutualFund information is known
	 * 
	 * @param fundName      the name of the fund
	 * @param ticker        the ticker symbol
	 * @param pricePerShare the price per share
	 * @param tradingFee    the trading fee as a percent
	 */
	public MutualFund(String fundName, String ticker, double pricePerShare, double tradingFee) {
		this.ticker = ticker;
		this.fundName = fundName;
		this.pricePerShare = pricePerShare;
		this.tradingFee = tradingFee;
	}

	/** ACCESSORS */

	/**
	 * Accesses the name of the fund
	 * 
	 * @return the fund name
	 */
	public String getFundName() {
		return this.fundName;
	}

	/**
	 * Accesses the ticker symbol
	 * 
	 * @return the ticker symbol
	 */
	public String getTicker() {
		return this.ticker;
	}

	/**
	 * Accesses the price per share
	 * 
	 * @return the price per share
	 */
	public double getPricePerShare() {
		return this.pricePerShare;
	}

	/**
	 * Accesses the trading fee
	 * 
	 * @return the trading feef
	 */
	public double getTradingFee() {
		return this.tradingFee;
	}

	/** MUTATORS */

	/**
	 * Updates the share price
	 * 
	 * @param pricePerShare the new share price
	 */
	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	/**
	 * Updates the trading fee
	 * 
	 * @param tradingFee the new trading fee
	 */
	public void setTradingFee(double tradingFee) {
		this.tradingFee = tradingFee;
	}

	/** ADDITIONAL OPERATIONS */

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("###.00");
		return fundName + "\n"
				+ ticker + "\n"
				+ "Share Price: $" + df.format(pricePerShare)
				+ "\nTrading Fee: " + tradingFee + "%";
	}

	/**
	 * Compares this MutualFund to another Object for equality You must use the
	 * formula presented in class for full credit (see Lesson 4)
	 * 
	 * @param o another Object (MutualFund or otherwise)
	 * @return whether o is a MutualFund and has the same ticker as this MutualFund
	 */
	@Override
	public boolean equals(Object o) {
		{
			if (o == this) {
				return true;
			} else if (!(o instanceof MutualFund)) {
				return false;
			} else {
				MutualFund L = (MutualFund) o;
				if (this.ticker.equals(L.ticker)) {
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * Returns a consistent hash code for each MutualFund by summing the Unicode
	 * values of each character in the key Key = ticker
	 * 
	 * @return the hash code
	 */
	@Override
	public int hashCode() {
		String key = ticker;
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += (int) key.charAt(i);
        }
        return sum;
	}
}