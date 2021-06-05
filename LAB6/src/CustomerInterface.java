/**
* CustomerInterface.java
* @author Yadwinder Grewal
* @author Ansar Shaikh
* CIS 22C, Lab 6
*/
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;

public class CustomerInterface {
    public static void main(String[] args) throws IOException{
	final int NUM_MUTUAL_FUNDS = 7;
	final int NUM_CUSTOMERS = 100;
	HashTable<MutualFund> funds = new HashTable<>(NUM_MUTUAL_FUNDS * 2);
	HashTable<Customer> customers = new HashTable<>(NUM_CUSTOMERS);	
	DecimalFormat df = new DecimalFormat("###,##0.00");
	String first = "", last = "", email, password, mutualName, ticker;
	double cash, sharePrice, numShares, fee;
	File file1 = new File("mutual_funds.txt");
	File file2 = new File("customers.txt");
	
	//Reading Files
	Scanner inputfile1 = new Scanner(file1);
	while(inputfile1.hasNextLine())
	{
		mutualName = inputfile1.nextLine();
		ticker = inputfile1.nextLine();
		sharePrice = inputfile1.nextDouble();
		inputfile1.nextLine();
		fee = inputfile1.nextDouble();
		inputfile1.nextLine();
		
		funds.insert(new MutualFund(mutualName, ticker,sharePrice, fee));
	}
	inputfile1.close();
	
	Scanner inputfile2 = new Scanner(file2);
	ArrayList<MutualFundAccount> mutuFundAcc = new ArrayList<>();
	
	while(inputfile2.hasNextLine())
	{
		first = inputfile2.next();
		last = inputfile2.next();
		inputfile2.nextLine();
		email = inputfile2.nextLine();
		password = inputfile2.nextLine();
		cash = inputfile2.nextDouble();
		int totalfunds = inputfile2.nextInt();
		inputfile2.nextLine();
		for (int i = 0; i < totalfunds; i++) {
			ticker = inputfile2.nextLine();
			numShares = inputfile2.nextDouble();
			inputfile2.nextLine();
			
			MutualFund mutufund = funds.get(new MutualFund(ticker));
			mutuFundAcc.add(new MutualFundAccount(mutufund, numShares));
		}	
		
		customers.insert(new Customer(first, last, email, password, cash, mutuFundAcc));
	}
	//System.out.println(customers);
	inputfile2.close();
	//Scanner
	Scanner input = new Scanner(System.in);
	// Console Output
	System.out.print("Welcome to Mutual Fund InvestorTrack (TM)!\n\nPlease enter your email address: ");
	email = input.nextLine();
	System.out.print("Please enter your password: ");
	password = input.nextLine();
	Customer cstmr = new Customer(email, password);
	if(!customers.contains(cstmr))
	{
		System.out.println("\nWe don't have your account on file...\n\nLet's create an account for you!");
		System.out.print("Enter your first name: ");
		first = input.nextLine();
		System.out.print("Enter your last name: ");
		last = input.nextLine();
		customers.insert(new Customer(first, last, email, password));
	}
	System.out.println("\nWelcome, " + first + " " + last + "!\n");
	boolean isFinished = false;
	String userChoices = "";
	while(!isFinished)
	{
		System.out.print("\nPlease select from the following options:\n\n"
				+ "A. Purchase a Fund\n"
				+ "B. Sell a Fund\n"
				+ "C. Add Cash\n"
				+ "D. Display Your Current Funds\n"
				+ "X. Exit\n"
				+ "\nEnter your choice: ");
		userChoices = input.next().toUpperCase();
		switch(userChoices) {
		case("A"): // Purchase a funds
		{
			System.out.println("\nPlease select from the options below:\n");
			System.out.println(funds);
			input.nextLine();
			System.out.print("Enter the ticker of the fund to purchase: ");
			String purchesTicker = input.nextLine();
			System.out.print("\nEnter the number of shares to purchase: ");
			double purchesShares = input.nextDouble();
			MutualFund temp = new MutualFund(purchesTicker);
			MutualFund tempfunds = funds.get(temp);
			if(!cstmr.addFund(purchesShares, tempfunds))
			{
				System.out.println("\nYou don't have enough cash to purchase that fund: \n"
						+ "Please add cash to make a purchase\n");
			}
			else
			{
				System.out.println("\nYou Successfully added shares of the following fund:\n");
				System.out.println(tempfunds);
				System.out.println("Number of shares added: " + purchesShares);
			}
			break;
		}
		case("B"):
		{
			String mutualFundName;
			String shares;
			
			if (!cstmr.hasOpenAccounts()) {
				System.out.println("\nYou don't have any funds to sell at this time.");
			} else {
				System.out.println("\nYou own the following mutual funds:\n");
				cstmr.printAccountsByName();
				System.out.print("\nEnter the name of the fund to sell: ");
				mutualFundName = input.nextLine();
				MutualFundAccount fSell = cstmr.getAccountByName(mutualFundName);
				if (fSell == null) {
					System.out.println("Sorry you don't own an account by that name.");
				} else {
					System.out.print("Enter the number of shares to sell or \"all\" to sell everything: ");
					shares = input.nextLine();
					if (shares.compareTo("all") == 0) {
						cstmr.sellFund(mutualFundName);
					} else {
						double sharesDouble = Double.parseDouble(shares);
						cstmr.sellShares(mutualFundName, sharesDouble);
					}
					System.out.println("\nYou own the following funds:");
					cstmr.printAccountsByName();
					System.out.println("\nYour current cash balance is $" + df.format(cstmr.getCash()) + "\n");
				}
			}
			break;
		}
		case("C"):
		{
			System.out.println("\nYour current cash balance is $" + df.format(cstmr.getCash()));
			System.out.print("\nEnter the amount of cash to add: $");
			cash = input.nextDouble();
			input.nextLine();
			cstmr.updateCash(cash);
			System.out.println("\nYour current cash balance is $" + df.format(cstmr.getCash()) + "\n");
			break;
		}
		case("D"): // Display Funds
		{
			if (funds.getNumElements() == 0 || !cstmr.hasOpenAccounts()) {
				System.out.println("\nYou don't have any funds to display at this time.");				
			}
			else
			{
				System.out.print("\nView Your Mutual Funds By:.\n\n1. Name\n2. Value\n\nEnter your choice (1 or 2): ");
				int userNum = input.nextInt();
				if (userNum == 1) {
					cstmr.printAccountsByName();
				} else if (userNum == 2) {
					cstmr.printAccountsByValue();

				} else {
					System.out.println("\nInvalid choice!");
				}
			}

			break;
		}
		case("X"):
		{
			System.out.println("\nGoodbye!");
			isFinished = true;
			break;
		}
		default: 
		{
			System.out.println("\nInvalid menu option. Please enter A-D or X to exit.\n");
			break;
		}
		}
	}
	
	
	
	input.close();
   }
}
