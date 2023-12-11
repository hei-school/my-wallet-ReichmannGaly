using System;
using System.Collections.Generic;
using System.Linq;
using Newtonsoft.Json;

namespace Items
{
    public class Wallet
    {
        public string Owner { get; set; }
        public bool IsLostStatus { get; set; }
        public List<IDCard> IDCards { get; set; }
        public List<Money> MoneyList { get; set; }
        public List<CreditCard> CreditCards { get; set; }
        public List<DrivingLicence> DrivingLicences { get; set; }
        public List<IDPhoto> IDPhotos { get; set; }
        public List<BusinessCard> BusinessCards { get; set; }

        public Wallet(string owner, bool isLost, List<IDCard> idCards, List<Money> moneyList, List<CreditCard> creditCards, List<DrivingLicence> drivingLicences, List<IDPhoto> idPhotos, List<BusinessCard> businessCards)
        {
            Owner = owner;
            IsLostStatus = isLost;
            IDCards = idCards;
            MoneyList = moneyList;
            CreditCards = creditCards;
            DrivingLicences = drivingLicences;
            IDPhotos = idPhotos;
            BusinessCards = businessCards;
        }

        public string GetOwner()
        {
            return Owner;
        }

        public void SetLost()
        {
            IsLostStatus = !IsLostStatus;
        }

        public List<IDCard> GetIDCards()
        {
            return IDCards;
        }

        public void AddIDCard()
        {
            if (!IsLostStatus)
            {
                Console.Write("Enter ID Card name: ");
                string idCardName = Console.ReadLine();
                Console.Write("Enter ID Card number: ");
                string idCardNumber = Console.ReadLine();
                IDCard newIDCard = new IDCard(idCardName, idCardNumber, false);
                IDCards.Add(newIDCard);
                Console.WriteLine("ID Card added to the wallet.");
            }
            else
            {
                Console.WriteLine("Cannot add ID Card. The wallet is lost.");
            }
        }

        public List<Money> GetMoneyList()
        {
            return MoneyList;
        }

        public void AddMoney()
        {
            if (!IsLostStatus)
            {
                Console.Write("Enter the amount of money: ");
                double amount = Convert.ToDouble(Console.ReadLine());
                Console.WriteLine("Choose currency:\n1. Dollars\n2. Euro\n3. Ariary");
                int currencyChoice = Convert.ToInt32(Console.ReadLine());
                string[] currencies = { "Dollars", "Euro", "Ariary" };
                string currency = (1 <= currencyChoice && currencyChoice <= 3) ? currencies[currencyChoice - 1] : "Dollars";
                Money money = new Money(currency, Convert.ToDecimal(amount));
                MoneyList.Add(money);
                Console.WriteLine("Money added to the wallet.");
            }
            else
            {
                Console.WriteLine("Cannot add money. The wallet is lost.");
            }
        }

        public List<CreditCard> GetCreditCards()
        {
            return CreditCards;
        }

        public void AddCreditCard()
        {
            if (!IsLostStatus)
            {
                Console.Write("Enter Credit Card owner: ");
                string cardOwner = Console.ReadLine();
                Console.Write("Enter Credit Card number: ");
                string cardNumber = Console.ReadLine();
                Console.Write("Enter expiration date (yyyy-MM-dd): ");
                string expirationDateString = Console.ReadLine();
                CreditCard newCreditCard = new CreditCard(cardOwner, cardNumber, expirationDateString);
                CreditCards.Add(newCreditCard);
                Console.WriteLine("Credit Card added to the wallet.");
            }
            else
            {
                Console.WriteLine("Cannot add Credit Card. The wallet is lost.");
            }
        }

        public List<DrivingLicence> GetDrivingLicences()
        {
            return DrivingLicences;
        }

        public void AddDrivingLicence()
        {
            if (!IsLostStatus)
            {
                Console.Write("Enter Driving Licence owner: ");
                string licenceOwner = Console.ReadLine();
                Console.WriteLine("Choose Driving Licence category:\n1. A\n2. B\n3. C\n4. D\n5. E");
                int categoryChoice = Convert.ToInt32(Console.ReadLine());
                string[] categories = { "A", "B", "C", "D", "E" };
                string licenceCategory = (1 <= categoryChoice && categoryChoice <= 5) ? categories[categoryChoice - 1] : "A";
                DrivingLicence newDrivingLicence = new DrivingLicence(licenceOwner, licenceCategory);
                DrivingLicences.Add(newDrivingLicence);
                Console.WriteLine("Driving Licence added to the wallet.");
            }
            else
            {
                Console.WriteLine("Cannot add Driving Licence. The wallet is lost.");
            }
        }

        public List<IDPhoto> GetIDPhotos()
        {
            return IDPhotos;
        }

        public void AddIDPhoto()
        {
            if (!IsLostStatus)
            {
                Console.Write("Enter ID Photo owner: ");
                string photoOwner = Console.ReadLine();
                IDPhoto newIDPhoto = new IDPhoto(photoOwner);
                IDPhotos.Add(newIDPhoto);
                Console.WriteLine("ID Photo added to the wallet.");
            }
            else
            {
                Console.WriteLine("Cannot add ID Photo. The wallet is lost.");
            }
        }

        public List<BusinessCard> GetBusinessCards()
        {
            return BusinessCards;
        }

        public void AddBusinessCard()
        {
            if (!IsLostStatus)
            {
                Console.Write("Enter Business Card owner: ");
                string cardOwner = Console.ReadLine();
                Console.Write("Enter Company Name: ");
                string companyName = Console.ReadLine();
                BusinessCard newBusinessCard = new BusinessCard(cardOwner, companyName);
                BusinessCards.Add(newBusinessCard);
                Console.WriteLine("Business Card added to the wallet.");
            }
            else
            {
                Console.WriteLine("Cannot add Business Card. The wallet is lost.");
            }
        }

        public void RemoveItemByType(string itemType)
        {
            switch (itemType)
            {
                case "ID_CARD":
                    RemoveItem(GetIDCards(), "ID Card");
                    break;
                case "MONEY":
                    RemoveItem(GetMoneyList(), "Money item");
                    break;
                case "CREDIT_CARD":
                    RemoveItem(GetCreditCards(), "Credit Card");
                    break;
                case "BUSINESS_CARD":
                    RemoveItem(GetBusinessCards(), "Business Card");
                    break;
                case "DRIVING_LICENCE":
                    RemoveItem(GetDrivingLicences(), "Driving Licence");
                    break;
                case "ID_PHOTO":
                    RemoveItem(GetIDPhotos(), "ID Photo");
                    break;
                default:
                    Console.WriteLine("Invalid item type.");
                    break;
            }
        }

        private void RemoveItem<T>(List<T> itemList, string itemType)
        {
            if (!itemList.Any())
            {
                Console.WriteLine($"\nNo {itemType}s found in the wallet.");
                return;
            }

            Console.WriteLine($"\n{itemType}s in the wallet:");
            for (int i = 0; i < itemList.Count; i++)
            {
                Console.WriteLine($"\n{i + 1}. {JsonConvert.SerializeObject(itemList[i])}");
            }

            Console.Write($"\nEnter the number of the {itemType} to remove: ");
            int choice = Convert.ToInt32(Console.ReadLine());

            if (1 <= choice && choice <= itemList.Count)
            {
                T removedItem = itemList[choice - 1];
                itemList.RemoveAt(choice - 1);
                Console.WriteLine($"\nRemoved {itemType}: {JsonConvert.SerializeObject(removedItem)}");
            }
            else
            {
                Console.WriteLine($"\nInvalid choice. No {itemType} removed.");
            }
        }
    }
}
