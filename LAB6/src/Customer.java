/**
* Customer.java
* @author Yadwinder Grewal
* @author Ansar Shaikh
* CIS 22C, Lab 6
*/

import java.util.ArrayList;
import java.text.DecimalFormat;

public class Customer {
private String firstName;
private String lastName;
private String email;
private String password;
private String accountNum;
private double cash;

private BST<MutualFundAccount> funds_value = new BST<>();
private BST<MutualFundAccount> funds_name = new BST<>();


/**CONSTRUCTORS*/

/**
* Creates a new Customer when only email
* and password are known
* @param email the Customer email
* @param password the Customer password
* Assigns firstName to "first name unknown"
* Assigns lastName to "last name unknown"
* Assigns cash to 0
* Assigns accountNum to "none"
*/

public Customer(String email, String password) {
	this.email = email;
	this.password = password;
	this.firstName = "first name unknown";
	this.lastName = "last name unknown";
	this.cash = 0;
	this.accountNum = "none";
}

/**
* Creates a new Customer with no cash
* @param firstName member first name
* @param lastName member last name
* Assigns cash to 0
* Calls getAccountSeed and assigns accountNum to this value
* after converting it to a String BY USING CONCATENATION (easiest way)
* Hint: Make sure you get no warnings or you did not call getAccountSeed
* correctly!
*/
public Customer(String firstName, String lastName, String email, String password) {
	this.email = email;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.cash = 0;
	this.accountNum = MutualFundAccount.getAccountSeed() + "";
}

/**
* Creates a new Customer when all information is known
* @param firstName member first name
* @param lastName member last name
* @param cash the starting amount of cash
* @param al the MutualFundAccounts owned by this Customer
* (Hint: add these to the BSTs)
* Calls getAccountSeed and assigns accountNum to this value
* after converting it to a String BY USING CONCATENATION (easiest way)
* Hint: Make sure you get no warnings or you did not call getAccountSeed
* correctly!
*/
public Customer(String firstName, String lastName, String email, String password, double cash, ArrayList<MutualFundAccount> al) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.cash = cash;
	this.accountNum = MutualFundAccount.getAccountSeed() + "";
	
}

/**ACCESORS*/

/**
* Accesses the customer first name
* @return the first name
*/
public String getFirstName() {
return this.firstName;
}

/**
* Accesses the customer last name
* @return the last name
*/
public String getLastName() {
return this.lastName;
}

/**
* Accesses the user's account number
* @return the account number
*/
public String getAccountNum() {
return this.accountNum;
}

/**
* Accesses the email address
* @return the email address
*/
public String getEmail() {
return this.email;
}

/** Determines whether a given password matches the customer password 
* @param anotherPassword the password to compare 
* @return whether the two passwords match 
*/ 
public boolean passwordMatch(String anotherPassword) { 
	if(this.password == anotherPassword) {
		return true;
	}
	return false;
}


/**
* Accesses a specific fund
* @param name the chosen fund
* @return the specified mutual fund
*/
public MutualFundAccount getAccountByName(String name) {
return null;
}

/**
* Accesses the amount of cash in your account
* @return the amount of cash
*/
public double getCash() {
return cash;
}

/**
* Accesses whether any accounts exist
* for this customer
* @return whether the customer currently
* holds any accounts
*/
public boolean hasOpenAccounts() {
return false;
}

/**MUTATORS*/

/**
* Updates the customer first name
* @param firstName a new first name
*/
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

/**
* Updates the customer last name
* @param lastName a new last name
*/
public void setLastName(String lastName) {
	this.lastName = lastName;
}

/**
* Updates the value of the email address
* @param name the Customer's email address
*/
public void setEmail(String email) {
	this.email = email;
}

/**
* Updates the value of the password
* @param name the Customer password
*/
public void setPassword(String password) {
	this.password = password;
}

/**
* Increases/Decreases the amount of cash
* by adding to the existing cash
* @param cash the amount of cash to add
*/
public void updateCash(double cash) {
	this.cash = cash;
}

/**
* Adds a new mutual fund to the user's 
* list of funds or updates a fund to
* increase the number of shares held
* @param shares the desired number of shares
* @param mf a new or existing mutual fund
* @return whether the fund was added
* to the customer's account - i.e. the 
* customer had sufficient cash to add
* the MutualFund
* Decreases the amount of cash if purchase made
*/
public boolean addFund(double shares, MutualFund mf) {

return false;
}

/**
* Sells a Mutual Fund and
* returns (the price per share
* times the number of shares) 
* to cash minus the fee
* fee is % * price per share * number of shares
* @param name the name of the fund
*/
public void sellFund(String name) {

}

/**
* Sells a Mutual Fund and
* returns (the price per share
* times the number of shares) 
* to cash minus the fee
* fee is % * price per share * number of shares
* @param name the name of the fund
*/
public void sellShares(String name, double shares) {

}


/**ADDITIONAL OPERATIONS*/

/**
* Creates a String of customer information
* in the form
* Name: <firstName> <lastName>
* Account Number: <accountNum>
* Total Cash: $<cash>
* Note that cash is formatted $XXX,XXX,XXX.XX
*/

@Override public String toString() {

}

/**
* Prints out all the customer accounts
* alphabetized by name
*/
public void printAccountsByName() {

}

/**
* Prints out all the customer accounts
* in increasing order of value
*/
public void printAccountsByValue() {

}

/**
* Compares this Customer to another
* Object for equality
* You must use the formula presented
* in class for full credit. (See Lesson 4)
* @param o another Object
* @return true if o is a Customer
* and has a matching email and password
* to this Customer
*/
@Override public boolean equals(Object o) {
return false;
}

/**
* Returns a consistent hash code for
* each Customer by summing the Unicode values
* of each character in the key
* Key = email + password
* @return the hash code
*/
@Override public int hashCode() {
return -1;
}

}
