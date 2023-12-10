package com.prog5.items;

import com.prog5.items.utils.WalletUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Wallet {
    private String owner;

    private boolean isLost;

    private List<IDCard> idCards;

    private List<Money> moneyList;

    private List<CreditCard> creditCards;

    private List<BusinessCard> businessCards;

    private List<DrivingLicence> drivingLicences;

    private List<IDPhoto> idPhotos;

    public Wallet(
            String owner,
            boolean isLost,
            List<IDCard> idCards,
            List<Money> moneyList,
            List<CreditCard> creditCards,
            List<DrivingLicence> drivingLicences,
            List<IDPhoto> idPhotos,
            List<BusinessCard> businessCards) {
        this.owner = owner;
        this.isLost = isLost;
        this.idCards = idCards;
        this.moneyList = moneyList;
        this.creditCards = creditCards;
        this.drivingLicences = drivingLicences;
        this.idPhotos = idPhotos;
        this.businessCards = businessCards;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isLost() {
        return isLost;
    }

    public void setLost() {
        isLost = !isLost;
    }

    public List<IDCard> getIdCards() {
        return idCards;
    }

    Scanner scanner = new Scanner(System.in);

    public void addIdCard() {
        if (!isLost) {
            System.out.println("Enter ID Card name: ");
            String idCardName = scanner.nextLine();

            System.out.print("Enter ID Card number: ");
            String idCardNumber = scanner.nextLine();

            IDCard newIdCard = new IDCard(idCardName, idCardNumber, false);

            idCards.add(newIdCard);

            System.out.println("ID Card added to the wallet.");
        } else {
            System.out.println("Cannot add ID Card. The wallet is lost.");
        }
    }

    public List<Money> getMoneyList() {
        return moneyList;
    }

    public void addMoney() {
        if (!isLost) {
            System.out.print("Enter the amount of money: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Choose currency:");
            System.out.println("\n1. Dollars\n2. Euro\n3. Ariary");
            System.out.print("\nEnter currency choice (1-3): ");
            int currencyChoice = scanner.nextInt();
            scanner.nextLine();

            Money.Currency currency;
            switch (currencyChoice) {
                case 1 -> currency = Money.Currency.Dollars;
                case 2 -> currency = Money.Currency.Euro;
                case 3 -> currency = Money.Currency.Ariary;
                default -> {
                    System.out.println("Invalid currency choice. Using Dollars by default.");
                    currency = Money.Currency.Dollars;
                }
            }

            Money money = new Money(currency, amount);
            moneyList.add(money);
            System.out.println("Money added to the wallet.");
        } else {
            System.out.println("Cannot add money. The wallet is lost.");
        }
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void addCreditCard() {
        if (!isLost) {
            System.out.print("Enter Credit Card owner: ");
            String cardOwner = scanner.nextLine();

            System.out.print("Enter Credit Card number: ");
            String cardNumber = scanner.nextLine();

            System.out.print("Enter expiration date (yyyy-MM-dd): ");
            String dateString = scanner.nextLine();
            LocalDate expirationDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);

            CreditCard newCreditCard = new CreditCard(cardOwner, cardNumber, expirationDate);
            creditCards.add(newCreditCard);

            System.out.println("Credit Card added to the wallet.");
        } else {
            System.out.println("Cannot add Credit Card. The wallet is lost.");
        }
    }

    public List<DrivingLicence> getDrivingLicences() {
        return drivingLicences;
    }

    public void addDrivingLicence() {
        if (!isLost) {
            System.out.print("Enter Driving Licence owner: ");
            String licenceOwner = scanner.nextLine();

            System.out.println("Choose Driving Licence category:");
            System.out.println("1. A");
            System.out.println("2. B");
            System.out.println("3. C");
            System.out.println("4. D");
            System.out.println("5. E");
            System.out.print("Enter category choice (1-5): ");
            int categoryChoice = scanner.nextInt();
            scanner.nextLine();

            DrivingLicence.Category licenceCategory;
            switch (categoryChoice) {
                case 1 -> licenceCategory = DrivingLicence.Category.A;
                case 2 -> licenceCategory = DrivingLicence.Category.B;
                case 3 -> licenceCategory = DrivingLicence.Category.C;
                case 4 -> licenceCategory = DrivingLicence.Category.D;
                case 5 -> licenceCategory = DrivingLicence.Category.E;
                default -> {
                    System.out.println("Invalid category choice. Using A by default.");
                    licenceCategory = DrivingLicence.Category.A;
                }
            }

            DrivingLicence newDrivingLicence = new DrivingLicence(licenceOwner, licenceCategory);
            drivingLicences.add(newDrivingLicence);

            System.out.println("Driving Licence added to the wallet.");
        } else {
            System.out.println("Cannot add Driving Licence. The wallet is lost.");
        }
    }

    public List<IDPhoto> getIdPhotos() {
        return idPhotos;
    }

    public void addIdPhoto() {
        if (!isLost) {
            System.out.print("Enter ID Photo owner: ");
            String photoOwner = scanner.nextLine();

            IDPhoto newIdPhoto = new IDPhoto(photoOwner);
            idPhotos.add(newIdPhoto);

            System.out.println("ID Photo added to the wallet.");
        } else {
            System.out.println("Cannot add ID Photo. The wallet is lost.");
        }
    }

    public List<BusinessCard> getBusinessCards() {
        return businessCards;
    }

    public void addBusinessCard() {
        if (!isLost) {
            System.out.print("Enter Business Card owner: ");
            String cardOwner = scanner.nextLine();

            System.out.print("Enter Company Name: ");
            String companyName = scanner.nextLine();

            BusinessCard newBusinessCard = new BusinessCard(cardOwner, companyName);
            businessCards.add(newBusinessCard);

            System.out.println("Business Card added to the wallet.");
        } else {
            System.out.println("Cannot add Business Card. The wallet is lost.");
        }
    }

    public void removeItem(WalletUtils.ItemType itemType) {
        switch (itemType) {
            case ID_CARD -> removeItem(getIdCards(), "ID Card");
            case MONEY -> removeItem(getMoneyList(), "Money item");
            case CREDIT_CARD -> removeItem(getCreditCards(), "Credit Card");
            case BUSINESS_CARD -> removeItem(getBusinessCards(), "Business Card");
            case DRIVING_LICENCE -> removeItem(getDrivingLicences(), "Driving Licence");
            case ID_PHOTO -> removeItem(getIdPhotos(), "ID Photo");
        }
    }

    private <T> void removeItem(List<T> itemList, String itemType) {
        if (itemList.isEmpty()) {
            System.out.println("\nNo " + itemType + "s found in the wallet.");
            return;
        }

        System.out.println("\n"+ itemType + "s in the wallet:");
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println("\n" +(i + 1) + ". " + itemList.get(i));
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number of the " + itemType + " to remove: ");
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= itemList.size()) {
            T removedItem = itemList.remove(choice - 1);
            System.out.println("\nRemoved " + itemType + ": " + removedItem);
        } else {
            System.out.println("\nInvalid choice. No " + itemType + " removed.");
        }
    }
}
