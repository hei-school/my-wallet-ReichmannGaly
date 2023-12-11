using System;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace Items
{
    public static class MainUtils
    {
        public static void display_items(Wallet wallet)
        {
            while (true)
            {
                Console.WriteLine("\n--- Item Management ---");
                Console.WriteLine(@"
                    1. View ID Cards
                    2. View Moneys
                    3. View Credit Cards
                    4. View Business Cards
                    5. View Driving Licences
                    6. View ID Photos
                    7. Back to Main Menu
                ");
                int choice = get_choice(1, 7);

                switch (choice)
                {
                    case 1:
                        print_item_list(wallet.GetIDCards());
                        break;
                    case 2:
                        print_item_list(wallet.GetMoneyList());
                        break;
                    case 3:
                        print_item_list(wallet.GetCreditCards());
                        break;
                    case 4:
                        print_item_list(wallet.GetBusinessCards());
                        break;
                    case 5:
                        print_item_list(wallet.GetDrivingLicences());
                        break;
                    case 6:
                        print_item_list(wallet.GetIDPhotos());
                        break;
                    case 7:
                        return;
                    default:
                        Console.WriteLine("Invalid choice. Please enter a number between 1 and 7.");
                        break;
                }
            }
        }

        public static void print_item_list<T>(List<T> item_list)
        {
            Console.WriteLine("\nItems in the list:");
            if (item_list.Count == 0)
            {
                Console.WriteLine("No items found.");
            }
            else
            {
                for (int i = 0; i < item_list.Count; i++)
                {
                    Console.WriteLine($"{i + 1}. {JsonConvert.SerializeObject(item_list[i])}");
                }
            }
        }

        public static void display_items_count(Wallet wallet)
        {
            Console.WriteLine("\nID Cards: " + wallet.GetIDCards().Count);
            Console.WriteLine("Moneys: " + wallet.GetMoneyList().Count);
            Console.WriteLine("Credits cards: " + wallet.GetCreditCards().Count);
            Console.WriteLine("Business cards: " + wallet.GetBusinessCards().Count);
            Console.WriteLine("Driving licences: " + wallet.GetDrivingLicences().Count);
            Console.WriteLine("ID photos: " + wallet.GetIDPhotos().Count);
        }

        public static void display_wallet_information(Wallet wallet)
        {
            Console.WriteLine("\n--- Wallet Information ---");
            Console.WriteLine("Owner: " + wallet.GetOwner());
            Console.WriteLine("Lost: " + wallet.IsLostStatus);
            Console.WriteLine("Items in the wallet:");
            display_items_count(wallet);
        }

        public static void add_items(Wallet wallet)
        {
            while (true)
            {
                Console.WriteLine("\n--- Item Management ---");
                Console.WriteLine(@"
                    1. Add ID Card
                    2. Add Money
                    3. Add Credit Card
                    4. Add Business Card
                    5. Add Driving Licence
                    6. Add ID Photos
                    7. Back to Main Menu
                ");
                int choice = get_choice(1, 7);

                switch (choice)
                {
                    case 1:
                        wallet.AddIDCard();
                        break;
                    case 2:
                        wallet.AddMoney();
                        break;
                    case 3:
                        wallet.AddCreditCard();
                        break;
                    case 4:
                        wallet.AddBusinessCard();
                        break;
                    case 5:
                        wallet.AddDrivingLicence();
                        break;
                    case 6:
                        wallet.AddIDPhoto();
                        break;
                    case 7:
                        return;
                    default:
                        Console.WriteLine("Invalid choice. Please enter a number between 1 and 7.");
                        break;
                }
            }
        }

        public static void remove_item(Wallet wallet)
        {
            Console.WriteLine("\n--- Remove Item ---");
            Console.WriteLine(@"
                1. Remove ID Card
                2. Remove Money
                3. Remove Credit Card
                4. Remove Business Card
                5. Remove Driving Licence
                6. Remove ID Photo
                7. Back to Item Management
            ");
            int choice = get_choice(1, 7);

            switch (choice)
            {
                case 1:
                    wallet.RemoveItemByType("ID_CARD");
                    break;
                case 2:
                    wallet.RemoveItemByType("MONEY");
                    break;
                case 3:
                    wallet.RemoveItemByType("CREDIT_CARD");
                    break;
                case 4:
                    wallet.RemoveItemByType("BUSINESS_CARD");
                    break;
                case 5:
                    wallet.RemoveItemByType("DRIVING_LICENCE");
                    break;
                case 6:
                    wallet.RemoveItemByType("ID_PHOTO");
                    break;
                case 7:
                    return;
                default:
                    Console.WriteLine("Invalid choice. Please enter a number between 1 and 7.");
                    break;
            }
        }

        private static int get_choice(int min, int max)
        {
            int choice;
            while (true)
            {
                Console.Write($"\nChoose an option ({min}-{max}): ");
                if (int.TryParse(Console.ReadLine(), out choice) && choice >= min && choice <= max)
                {
                    return choice;
                }
                Console.WriteLine("Invalid input. Please enter a valid number.");
            }
        }
    }
}
