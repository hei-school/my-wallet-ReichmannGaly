import json

def display_items(wallet):
    while True:
        print("\n--- Item Management ---")
        print("""
            1. View ID Cards
            2. View Moneys
            3. View Credit Cards
            4. View Business Cards
            5. View Driving Licences
            6. View ID Photos
            7. Back to Main Menu
        """)
        choice = int(input("\nChoose an option (1-7): "))

        if choice == 1:
            print_item_list(wallet.get_id_cards())
        elif choice == 2:
            print_item_list(wallet.get_money_list())
        elif choice == 3:
            print_item_list(wallet.get_credit_cards())
        elif choice == 4:
            print_item_list(wallet.get_business_cards())
        elif choice == 5:
            print_item_list(wallet.get_driving_licences())
        elif choice == 6:
            print_item_list(wallet.get_id_photos())
        elif choice == 7:
            return
        else:
            print("Invalid choice. Please enter a number between 1 and 7.")

def print_item_list(item_list):
    print("\nItems in the list:")
    if not item_list:
        print("No items found.")
    else:
        for i, item in enumerate(item_list, start=1):
            print(f"{i}. {json.dumps(item.__dict__)}")

def display_items_count(wallet):
    print("\nID Cards: " + str(len(wallet.get_id_cards())))
    print("Moneys: " + str(len(wallet.get_money_list())))
    print("Credits cards: " + str(len(wallet.get_credit_cards())))
    print("Business cards: " + str(len(wallet.get_business_cards())))
    print("Driving licences: " + str(len(wallet.get_driving_licences())))
    print("ID photos: " + str(len(wallet.get_id_photos())))

def display_wallet_information(wallet):
    print("\n--- Wallet Information ---")
    print("Owner: " + wallet.get_owner())
    print("Lost: " + str(wallet.is_lost_status))
    print("Items in the wallet:")
    display_items_count(wallet)

def add_items(wallet):
    while True:
        print("\n--- Item Management ---")
        print("""
            1. Add ID Card
            2. Add Money
            3. Add Credit Card
            4. Add Business Card
            5. Add Driving Licence
            6. Add ID Photos
            7. Back to Main Menu
        """)
        choice = int(input("\nChoose an option (1-7): "))

        if choice == 1:
            wallet.add_id_card()
        elif choice == 2:
            wallet.add_money()
        elif choice == 3:
            wallet.add_credit_card()
        elif choice == 4:
            wallet.add_business_card()
        elif choice == 5:
            wallet.add_driving_licence()
        elif choice == 6:
            wallet.add_id_photo()
        elif choice == 7:
            return
        else:
            print("Invalid choice. Please enter a number between 1 and 7.")

def remove_item(wallet):
    print("\n--- Remove Item ---")
    print("""
        1. Remove ID Card
        2. Remove Money
        3. Remove Credit Card
        4. Remove Business Card
        5. Remove Driving Licence
        6. Remove ID Photo
        7. Back to Item Management
    """)
    choice = int(input("Choose an option (1-7): "))

    if choice == 1:
        wallet.remove_item_by_type("ID_CARD")
    elif choice == 2:
        wallet.remove_item_by_type("MONEY")
    elif choice == 3:
        wallet.remove_item_by_type("CREDIT_CARD")
    elif choice == 4:
        wallet.remove_item_by_type("BUSINESS_CARD")
    elif choice == 5:
        wallet.remove_item_by_type("DRIVING_LICENCE")
    elif choice == 6:
        wallet.remove_item_by_type("ID_PHOTO")
    elif choice == 7:
        return
    else:
        print("Invalid choice. Please enter a number between 1 and 7.")