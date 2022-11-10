package com.wallet.app.controller;

import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;
import com.wallet.app.service.WalletService;
import com.wallet.app.service.WalletServiceImpl;

import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {

		WalletService walletService = new WalletServiceImpl();


		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter your ID:");
		int id = sc.nextInt();
		System.out.println("Please enter your name:");
		String name = sc.next();
		System.out.println("Please enter your balance:");
		double balance = sc.nextDouble();
		System.out.println("Please enter your password:");
		String password = sc.next();

		try {
			Wallet wallet = walletService.registerWallet(new Wallet(id, name, balance, password));
			System.out.println(wallet);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Wallet wallet = walletService.registerWallet(new Wallet(1, "Ford", 1000.0, "123"));
			System.out.println(wallet);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Wallet wallet = walletService.registerWallet(new Wallet(2, "Pat", 600.0, "5617"));
			System.out.println(wallet);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Please enter your ID:");
		int id1 = sc1.nextInt();
		System.out.println("Please enter your password:");
		String password1 = sc1.next();
		System.out.println("Please enter amount you want to top up:");
		double amount1 = sc1.nextDouble();


		try {
			Boolean check = walletService.login(id1, password1);
			System.out.println(check);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Double topUp = walletService.addFundsToWallet(id1, amount1);
			System.out.println("you're new balance is:");
			System.out.println(topUp);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
