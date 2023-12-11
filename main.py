from random import choice
from items.wallet import Wallet
from items.main_utils import display_items, display_wallet_information, add_items, remove_item

if __name__ == "__main__":

    owner_name = str(input("Enter the name of the wallet owner: "))
    wallet_instance = Wallet(owner_name, False, [], [], [], [], [], [])
    
    while True:
        if not wallet_instance.is_lost_status:
            print("\n--- Wallet Management System ---")
            print("""
                1. Display Wallet Information
                2. Display Items in the wallet
                3. Add Items
                4. Remove an Item
                5. Change isLost status
                6. Exit
            """)
            main_choice = int(input("\nEnter your choice (1-6): "))

            if main_choice == 1:
                display_wallet_information(wallet_instance)
            elif main_choice == 2:
                display_items(wallet_instance)
            elif main_choice == 3:
                add_items(wallet_instance)
            elif main_choice == 4:
                remove_item(wallet_instance)
            elif main_choice == 5:
                wallet_instance.set_lost()
            elif main_choice == 6:
                print("Exiting...")
                break
            else:
                print("Invalid choice. Please enter a number between 1 and 6.")
        else:
            print("\n--- Wallet Management System ---")
            print("""
                1. Display Wallet Information
                2. Change isLost status
                3. Exit""")
            
            main_choice = int(input("\nWallet is currently lost, choose an option (1-3): "))

            if main_choice == 1:
                display_wallet_information(wallet_instance)
            elif main_choice == 2:
                wallet_instance.set_lost()
            elif main_choice == 3:
                print("Exiting...")
                break
            else:
                print("Invalid choice. Please enter a number between 1 and 3.")