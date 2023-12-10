package com.prog5;

import com.prog5.items.Wallet;

import java.util.ArrayList;
import java.util.Scanner;

import static com.prog5.items.utils.MainUtils.addItems;
import static com.prog5.items.utils.MainUtils.displayItems;
import static com.prog5.items.utils.MainUtils.displayWalletInformation;
import static com.prog5.items.utils.MainUtils.removeItem;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the wallet owner: ");
        String ownerName = scanner.nextLine();

        Wallet userWallet = new Wallet(
                ownerName,
                false,
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>());

        while (true) {
            if (!userWallet.isLost()){
                System.out.println("\n--- Wallet Management System ---");
                System.out.println("1. Display Wallet Information");
                System.out.println("2. Display items in the wallet");
                System.out.println("3. Add Items");
                System.out.println("4. Remove an item");
                System.out.println("5. Change isLost status");
                System.out.println("6. Exit");
                System.out.print("Choose an option (1-6): ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> displayWalletInformation(userWallet);
                    case 2 -> displayItems(userWallet, scanner);
                    case 3 -> addItems(userWallet, scanner);
                    case 4 -> removeItem(userWallet, scanner);
                    case 5 -> userWallet.setLost();
                    case 6 -> {
                        System.out.println("Exiting Wallet Management System. Goodbye!");
                        scanner.close();
                        System.exit(0);
                    }
                    default ->
                            System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } else {
                System.out.println("\n--- Wallet Management System ---");
                System.out.println("1. Display Wallet Information");
                System.out.println("2. Change isLost status");
                System.out.println("3. Exit");
                System.out.println("\nWallet is currently lost, choose an option (1-3): ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> displayWalletInformation(userWallet);
                    case 2 -> userWallet.setLost();
                    case 3 -> {
                        System.out.println("Exiting Wallet Management System. Goodbye!");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            }
        }
    }
}