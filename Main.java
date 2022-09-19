package com.ATMInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String name = "Prince";
		String pass = "qwertyuiop";
		int choice, accno, transfer, withdraw, deposit, balance = 0;
		String uname, password, message, accholder;

		ArrayList<String> history = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Username : ");
		uname = sc.nextLine();
		System.out.println("Enter Password : ");
		password = sc.nextLine();

		if (name.equals(uname)) {
			if (pass.equals(password)) {
				while (true) {
					
					System.out.println("\n-------------------------------------ATM Services-------------------------------------");

					System.out.println("1. Transaction History");
					System.out.println("2. Withdraw");
					System.out.println("3. Deposit");
					System.out.println("4. Transfer");
					System.out.println("5. Quit");
					System.out.print("\nChoose an action to be done --> ");

					choice = sc.nextInt();
					switch (choice) {
					case 1: {
						System.out.println("\n~~~~ Your Transaction History ~~~~");
						for (String hist : history) {
							System.out.println(hist);
						}
						break;
					}
					case 2: {
						System.out.println("Enter Amount to be withdrawn : ");
						withdraw = sc.nextInt();
						if (balance >= withdraw) {
							balance = balance - withdraw;
							message = String.format("Withdrawl of Rs. %d", withdraw);
							history.add(message);
							System.out.println("\nYou have successfull withdrawn Rs. " + withdraw
									+ "\nyour current balance is Rs. " + balance);
						} else {
							System.out.println("Insufficient Balance !");
						}
						break;
					}
					case 3: {
						System.out.println("Enter Amount to be Deposited : ");
						deposit = sc.nextInt();
						balance = balance + deposit;
						message = String.format("Deposit of Rs. %d", deposit);
						history.add(message);
						System.out.println("\nYou have successfully deposited Rs. " + deposit
								+ "\nyour current balance is Rs. " + balance);
						break;
					}
					case 4: {
						Scanner input = new Scanner(System.in);
						System.out.println("Enter the name of the beneficiary : ");
						accholder = input.nextLine();
						System.out.println("Enter Amount to be transferred : ");
						transfer = input.nextInt();
						if (balance >= transfer) {
							balance = balance - transfer;
							message = String.format("Transfer of Rs. %d to %s", transfer, accholder);
							history.add(message);
							System.out.println("\nYou have successfully transferred Rs. " + transfer);
							System.out.println("Your current balance is Rs. " + balance);
						} else {
							System.out.println("Insufficient Balance !");
						}
						break;
					}
					case 5: {
						System.out.println("Thank You !");
						System.exit(0);
					}
					}
				}
			}else {
				System.out.println("Incorrect Username or Password");
			}
		}else {
			System.out.println("Incorrect Username or Password");
		}
	}

}
