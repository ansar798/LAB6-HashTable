/**
 * MutualFund.java
 * @author PARTNER_NAME_1
 * @author PARTNER_NAME_1
 * CIS 22C, Lab 6
 */

import java.text.DecimalFormat;

public class MutualFund {
	private final String fundName;
	private final String ticker;
	private double pricePerShare;
	private double tradingFee;
	
	/**CONSTRUCTORS*/
	
	/**
	 * One arguement constructor,
	 * when only ticker is known
	 * @param ticker the ticker symbol
	 * sets fundName to "No name"
	 * and assigns 0 to pricePerShare
	 * and tradingFee
	 */
	public MutualFund(String ticker) {
	
	}
	
	/**
        * One arguement constructor,
        * when only name and ticker are known
        * @param name the name of the fund
        * @param ticker the ticker symbol
        * Assigns 0 to pricePerShare
        * and tradingFee
        */
       public MutualFund(String name, String ticker) {
        
       }
	
	/**
	 * Multi-argument constructor when all
	 * MutualFund information is known
	 * @param fundName the name of the fund
	 * @param ticker the ticker symbol
	 * @param pricePerShare the price per share
	 * @param tradingFee the trading fee as a percent
	 */
	public MutualFund(String fundName, String ticker, double pricePerShare, double tradingFee) {
		
	}
	
	/**ACCESSORS*/

	/**
	 * Accesses the name of the fund
	 * @return the fund name
	 */
	public String getFundName() {
		return null;
	}

	/**
	 * Accesses the ticker symbol
	 * @return the ticker symbol
	 */
	public String getTicker() {
		return null;
	}

	/**
	 * Accesses the price per share
	 * @return the price per share
	 */
	public double getPricePerShare() {
		return 0.0;
	}

	/**
	 * Accesses the trading fee
	 * @return the trading fee
	 */
	public double getTradingFee() {
		return 0.0;
	}
	
	/**MUTATORS*/
	
	/**
	 * Updates the share price
	 * @param pricePerShare the new share price
	 */
	public void setPricePerShare(double pricePerShare) {
		
	}
	
	/**
	 * Updates the trading fee
	 * @param tradingFee the new trading fee
	 */
	public void setTradingFee(double tradingFee) {
		
	}
	
	/**ADDITIONAL OPERATIONS*/

	@Override public String toString() {
		return null;
	}
	
	/**
	 * Compares this MutualFund to
	 * another Object for equality
         * You must use the formula presented
         * in class for full credit (see Lesson 4)
	 * @param o another Object 
	 * (MutualFund or otherwise)
	 * @return whether o is a MutualFund
	 * and has the same ticker as this MutualFund
	 */
	@Override public boolean equals(Object o) {
	    return false;
	}
	
	/**
        * Returns a consistent hash code for
        * each MutualFund by summing the Unicode values
        * of each character in the key
        * Key = ticker
        * @return the hash code
        */
       @Override public int hashCode() {
           return -1;
       }
}