package com.ATMInterface;

import java.util.Scanner;

class Bank_Account {
	String name;
	String username;
	String password;
	String account_no;
	float balance = 100000f;
	int transactions = 0;
	String transaction_history = "";

	public void registeration() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter Your Name : ");
		this.name = sc.nextLine();
		System.out.println("\nEnter Your User Name : ");
		this.username = sc.nextLine();
		System.out.println("\nEnter Your Password : ");
		this.password = sc.nextLine();
		System.out.println("\nEnter Your Account Number : ");
		this.username = sc.nextLine();
		System.out.println("Registration Successfull....");
	}

	public boolean login() {
		boolean is_login = false;
		Scanner sc = new Scanner(System.in);
		while (!is_login) {
			System.out.println("\nEnter Your User Name : ");
			String username = sc.nextLine();
			if (username.equals(username)) {
				while (!is_login) {
					System.out.println("\nEnter Your Password : ");
					String password = sc.nextLine();
					if (password.equals(password)) {
						System.out.println("\nLogin Successfull");
						is_login = true;
					} else {
						System.out.println("\n Incorrect Password");
					}
				}
			} else {
				System.out.println("User Not Registered...");
			}
		}
		return is_login;
	}

	public void withdraw() {
		System.out.println("\nEnter Withdraw Amount : ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			if (balance >= amount) {
				transactions++;
				balance -= amount;
				System.out.println("\nWithdrawl Successfull");
				String trns = amount + "Rs Withdrawed\n";
				transaction_history = transaction_history.concat(trns);
			} else {
				System.out.println("\nInsufficient Balance");
			}
		} catch (Exception e) {
		}
	}

	public void deposit() {
		System.out.println("\nEnter Depositing Amount : ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			if (amount <= 100000f) {
				transactions++;
				balance += amount;
				System.out.println("\n" + amount + " Rs Amount Deposited Successfully");
				String trns = amount + " Rs deposited\n";
				transaction_history = transaction_history.concat(trns);
			} else {
				System.out.println("\nSorry...Your limit is 100000.00 Rs");
			}
		} catch (Exception e) {
		}
	}

	public void transfer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Receipent's Name : ");
		String receipent = sc.nextLine();
		System.out.println("Enter Receipent's Account number : ");
		String acc_no = sc.nextLine();
		System.out.println("Enter Amount : ");
		float amount = sc.nextFloat();

		try {
			if (balance >= amount) {
				if (amount <= 25000f) {
					transactions++;
					balance -= amount;
					System.out.println("\n Amount Transfered Successfully to " + receipent);
					String trns = amount + " Rs Transfered to " + receipent + "\n";
					transaction_history = transaction_history.concat(trns);
				} else {
					System.out.println("\nYou can not transfer more than 25000 Rs in a day.");
				}
			} else {
				System.out.println("\nInsufficient Balance");
			}
		} catch (Exception e) {
		}
	}

	public void checkBalance() {
		System.out.println("\n" + balance + " Rs");
	}

	public void transaction_history() {
		if (transactions == 0) {
			System.out.println("No Transaction Done Yet");
		} else {
			System.out.println("\n" + transaction_history);
		}
	}
}

public class ATM_Interface {
	public static int take_input(int limit) {
		int input = 0;
		boolean flag = false;

		while (!flag) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;

				if (flag && input > limit || input < 1) {
					System.out.println("Choose the Number between 1 to " + limit);
					flag = false;
				}
			} catch (Exception e) {
				System.out.println("Enter only integer value");
				flag = false;
			}
		};
		return input;
	}

	public static void main(String args[]) {
		System.out.println("\n-----------------------Welcome to PRINCE ATM-----------------------\n");
		System.out.println("\nEnter 1 for Registration\nEnter 2 for Exit ");
		System.out.println("Enter Your Choice Here : ");
		int choice = take_input(2);
		
		if(choice == 1) {
			Bank_Account ba = new Bank_Account();
			ba.registeration();
			while(true) {
				System.out.println("\nEnter 1 for Login\nEnter 2 for Exit ");
				System.out.println("Enter Your Choice Here : ");
				int cc = take_input(2);
				if(cc==1) {
					if(ba.login()) {
						System.out.println("\n\n-----------------------Welcome "+ba.name+"-----------------------\n");
						boolean is_Finished = false;
						while(!is_Finished) {
							System.out.println("\n1.Withdraw\n2.Deposit\n3.Transfer\n4.Check Balance\n5.Transaction History\n6.Exit");
							System.out.println("Enter Your Choice Here : ");
							int cb = take_input(6);
							switch(cb) {
							case 1 : ba.withdraw();
							break;
							case 2 : ba.deposit();
							break;
							case 3 : ba.transfer();
							break;
							case 4 : ba.checkBalance();
							break;
							case 5 : ba.transaction_history();
							break;
							case 6 : is_Finished=true;
							break;
							}
						}
					}
				}else {
				System.exit(0);
			}
		}
	}else {
		System.exit(0);
	}
	}
}
