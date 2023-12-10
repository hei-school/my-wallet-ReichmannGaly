package com.prog5.items.utils;

import com.prog5.items.Wallet;

import java.util.List;
import java.util.Scanner;

public class MainUtils {
    public static void displayItems(Wallet wallet, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Item Management ---");
            System.out.println(
                    """

                        1. View ID Cards
                        2. View Moneys
                        3. View Credit Cards
                        4. View Business Cards
                        5. View Driving Licences
                        6. View ID Photos
                        7. Back to Main Menu
                        Choose an option (1-7):""");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> printItemList(wallet.getIdCards());
                case 2 -> printItemList(wallet.getMoneyList());
                case 3 -> printItemList(wallet.getCreditCards());
                case 4 -> printItemList(wallet.getBusinessCards());
                case 5 -> printItemList(wallet.getDrivingLicences());
                case 6 -> printItemList(wallet.getIdPhotos());
                case 7 -> {
                    return;
                }
                default ->
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    public static <T> void printItemList(List<T> itemList) {
        System.out.println("\nItems in the list:");
        if (itemList.isEmpty()) {
            System.out.println("No items found.");
        } else {
            for (T item : itemList) {
                System.out.println(item);
            }
        }
    }

    public static void displayItemsCount(Wallet wallet){
        System.out.println("\nID Cards: " + wallet.getIdCards().size());
        System.out.println("Moneys: " + wallet.getMoneyList().size());
        System.out.println("Credits cards: " + wallet.getCreditCards().size());
        System.out.println("Business cards: " + wallet.getBusinessCards().size());
        System.out.println("Driving licences: " + wallet.getDrivingLicences().size());
        System.out.println("ID photos: " + wallet.getIdPhotos().size());
    }

    public static void displayWalletInformation(Wallet wallet) {
        System.out.println("\n--- Wallet Information ---");
        System.out.println("Owner: " + wallet.getOwner());
        System.out.println("Lost: " + wallet.isLost());
        System.out.println("Items in the wallet:");
        displayItemsCount(wallet);
    }

    public static void addItems(Wallet wallet, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Item Management ---");
            System.out.println(
                    """

                        1. Add ID Card
                        2. Add Money
                        3. Add Credit Card
                        4. Add Business Card
                        5. Add Driving Licence
                        6. Add ID Photos
                        7. Back to Main Menu
                        Choose an option (1-7):""");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> wallet.addIdCard();
                case 2 -> wallet.addMoney();
                case 3 -> wallet.addCreditCard();
                case 4 -> wallet.addBusinessCard();
                case 5 -> wallet.addDrivingLicence();
                case 6 -> wallet.addIdPhoto();
                case 7 -> {
                    return;
                }
                default ->
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    public static void removeItem(Wallet wallet, Scanner scanner) {
        System.out.println("\n--- Remove Item ---");
        System.out.println(
                """
                    1. Remove ID Card
                    2. Remove Money
                    3. Remove Credit Card
                    4. Remove Business Card
                    5. Remove Driving Licence
                    6. Remove ID Photo
                    7. Back to Item Management
                    Choose an option (1-7):""");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> wallet.removeItem(WalletUtils.ItemType.ID_CARD);
            case 2 -> wallet.removeItem(WalletUtils.ItemType.MONEY);
            case 3 -> wallet.removeItem(WalletUtils.ItemType.CREDIT_CARD);
            case 4 -> wallet.removeItem(WalletUtils.ItemType.BUSINESS_CARD);
            case 5 -> wallet.removeItem(WalletUtils.ItemType.DRIVING_LICENCE);
            case 6 -> wallet.removeItem(WalletUtils.ItemType.ID_PHOTO);
            case 7 -> {
                return;
            }
            default ->
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
        }
    }
}
