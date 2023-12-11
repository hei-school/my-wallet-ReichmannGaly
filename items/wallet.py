import datetime, json

from items.id_card import IDCard
from items.credit_card import CreditCard
from items.driving_licence import DrivingLicence
from items.id_photo import IDPhoto
from items.business_card import BusinessCard
from items.money import Money

class Wallet:
    def __init__(self, owner, is_lost, id_cards, money_list, credits_cards, driving_licences, id_photos,business_cards):
        self.owner = owner
        self.is_lost_status = is_lost
        self.id_cards = id_cards
        self.money_list = money_list
        self.credit_cards = credits_cards
        self.driving_licences = driving_licences
        self.id_photos = id_photos
        self.business_cards = business_cards

    def get_owner(self):
        return self.owner
    
    def set_lost(self):
        self.is_lost_status = not self.is_lost_status

    def get_id_cards(self):
        return self.id_cards
    
    def add_id_card(self):
        if not self.is_lost_status:
            id_card_name = input("Enter ID Card name: ")
            id_card_number = input("Enter ID Card number: ")
            new_id_card = IDCard(id_card_name, id_card_number, False)
            self.id_cards.append(new_id_card)
            print("ID Card added to the wallet.")
        else:
            print("Cannot add ID Card. The wallet is lost.")

    def get_money_list(self):
        return self.money_list

    def add_money(self):
        if not self.is_lost_status:
            amount = float(input("Enter the amount of money: "))
            print("Choose currency:")
            print("\n1. Dollars\n2. Euro\n3. Ariary")
            currency_choice = int(input("\nEnter currency choice (1-3): "))
            currencies = ["Dollars", "Euro", "Ariary"]
            currency = currencies[currency_choice - 1] if 1 <= currency_choice <= 3 else "Dollars"
            money = Money(currency, amount)
            self.money_list.append(money)
            print("Money added to the wallet.")
        else:
            print("Cannot add money. The wallet is lost.")

    def get_credit_cards(self):
        return self.credit_cards

    def add_credit_card(self):
        if not self.is_lost_status:
            card_owner = input("Enter Credit Card owner: ")
            card_number = input("Enter Credit Card number: ")
            expiration_date_string = input("Enter expiration date (yyyy-MM-dd): ")
            new_credit_card = CreditCard(card_owner, card_number, expiration_date_string)
            self.credit_cards.append(new_credit_card)
            print("Credit Card added to the wallet.")
        else:
            print("Cannot add Credit Card. The wallet is lost.")

    def get_driving_licences(self):
        return self.driving_licences

    def add_driving_licence(self):
        if not self.is_lost_status:
            licence_owner = input("Enter Driving Licence owner: ")
            print("Choose Driving Licence category:")
            print("1. A\n2. B\n3. C\n4. D\n5. E")
            category_choice = int(input("Enter category choice (1-5): "))
            categories = ["A", "B", "C", "D", "E"]
            licence_category = categories[category_choice - 1] if 1 <= category_choice <= 5 else "A"
            new_driving_licence = DrivingLicence(licence_owner, licence_category)
            self.driving_licences.append(new_driving_licence)
            print("Driving Licence added to the wallet.")
        else:
            print("Cannot add Driving Licence. The wallet is lost.")

    def get_id_photos(self):
        return self.id_photos

    def add_id_photo(self):
        if not self.is_lost_status:
            photo_owner = input("Enter ID Photo owner: ")
            new_id_photo = IDPhoto(photo_owner)
            self.id_photos.append(new_id_photo)
            print("ID Photo added to the wallet.")
        else:
            print("Cannot add ID Photo. The wallet is lost.")

    def get_business_cards(self):
        return self.business_cards

    def add_business_card(self):
        if not self.is_lost_status:
            card_owner = input("Enter Business Card owner: ")
            company_name = input("Enter Company Name: ")
            new_business_card = BusinessCard(card_owner, company_name)
            self.business_cards.append(new_business_card)
            print("Business Card added to the wallet.")
        else:
            print("Cannot add Business Card. The wallet is lost.")

    def remove_item_by_type(self, item_type):
        switcher = {
            "ID_CARD": lambda: self.remove_item(self.get_id_cards(), "ID Card"),
            "MONEY": lambda: self.remove_item(self.get_money_list(), "Money item"),
            "CREDIT_CARD": lambda: self.remove_item(self.get_credit_cards(), "Credit Card"),
            "BUSINESS_CARD": lambda: self.remove_item(self.get_business_cards(), "Business Card"),
            "DRIVING_LICENCE": lambda: self.remove_item(self.get_driving_licences(), "Driving Licence"),
            "ID_PHOTO": lambda: self.remove_item(self.get_id_photos(), "ID Photo")
        }
        switcher.get(item_type, lambda: print("Invalid item type."))()

    def remove_item(self, item_list, item_type):
        if not item_list:
            print(f"\nNo {item_type}s found in the wallet.")
            return

        print(f"\n{item_type}s in the wallet:")
        for i, item in enumerate(item_list, start=1):
            print(f"\n{i}. {json.dumps(item.__dict__)}")

        choice = int(input(f"\nEnter the number of the {item_type} to remove: "))

        if 1 <= choice <= len(item_list):
            removed_item = item_list.pop(choice - 1)
            print(f"\nRemoved {item_type}: {json.dumps(removed_item.__dict__)}")
        else:
            print(f"\nInvalid choice. No {item_type} removed.")