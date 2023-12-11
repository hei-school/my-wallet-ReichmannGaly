using Items;
using System;
using System.Collections.Generic;

class Program
{
    static void Main(string[] args)
    {
        string ownerName = GetUserInput("Enter the name of the wallet owner: ");
        Wallet walletInstance = new Wallet(ownerName, false, new List<IDCard>(), new List<Money>(), new List<CreditCard>(),
          new List<DrivingLicence>(), new List<IDPhoto>(), new List<BusinessCard>());

        while (true)
        {
            if (!walletInstance.IsLostStatus)
            {
                Console.WriteLine("\n--- Wallet Management System ---");
                Console.WriteLine(@"
                        1. Display Wallet Information
                        2. Display Items in the wallet
                        3. Add Items
                        4. Remove an Item
                        5. Change isLost status
                        6. Exit
                    ");
                int mainChoice = GetChoice(1, 6);

                switch (mainChoice)
                {
                    case 1:
                        MainUtils.display_wallet_information(walletInstance);
                        break;
                    case 2:
                        MainUtils.display_items(walletInstance);
                        break;
                    case 3:
                        MainUtils.add_items(walletInstance);
                        break;
                    case 4:
                        MainUtils.remove_item(walletInstance);
                        break;
                    case 5:
                        walletInstance.SetLost();
                        break;
                    case 6:
                        Console.WriteLine("Exiting...");
                        return;
                    default:
                        Console.WriteLine("Invalid choice. Please enter a number between 1 and 6.");
                        break;
                }
            }
            else
            {
                Console.WriteLine("\n--- Wallet Management System ---");
                Console.WriteLine(@"
                        1. Display Wallet Information
                        2. Change isLost status
                        3. Exit
                    ");

                int mainChoice = GetChoice(1, 3);

                switch (mainChoice)
                {
                    case 1:
                        MainUtils.display_wallet_information(walletInstance);
                        break;
                    case 2:
                        walletInstance.SetLost();
                        break;
                    case 3:
                        Console.WriteLine("Exiting...");
                        return;
                    default:
                        Console.WriteLine("Invalid choice. Please enter a number between 1 and 3.");
                        break;
                }
            }
        }
    }

    static int GetChoice(int min, int max)
    {
        int choice;
        while (true)
        {
            Console.Write($"\nEnter your choice ({min}-{max}): ");
            if (int.TryParse(Console.ReadLine(), out choice) && choice >= min && choice <= max)
            {
                return choice;
            }
            Console.WriteLine("Invalid input. Please enter a valid number.");
        }
    }

    static string GetUserInput(string prompt)
    {
        Console.Write(prompt);
        return Console.ReadLine();
    }
}
