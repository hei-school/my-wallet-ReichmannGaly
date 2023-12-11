const prompt = require("prompt-sync")(); 


class IDCard {
    constructor(name, number, lost) {
        this.name = name;
        this.number = number;
        this.lost = lost;
    }
}

class Money {
    constructor(currency, amount) {
        this.currency = currency;
        this.amount = amount;
    }
}

class CreditCard {
    constructor(owner, number, expirationDate) {
        this.owner = owner;
        this.number = number;
        this.expirationDate = expirationDate;
    }
}

class DrivingLicence {
    constructor(owner, category) {
        this.owner = owner;
        this.category = category;
    }
}

class IDPhoto {
    constructor(owner) {
        this.owner = owner;
    }
}

class BusinessCard {
    constructor(owner, companyName) {
        this.owner = owner;
        this.companyName = companyName;
    }
}

class Wallet {
    constructor(owner, isLost, idCards, moneyList, creditCards, drivingLicences, idPhotos, businessCards) {
        this.owner = owner;
        this.isLostStatus = isLost;
        this.idCards = idCards;
        this.moneyList = moneyList;
        this.creditCards = creditCards;
        this.drivingLicences = drivingLicences;
        this.idPhotos = idPhotos;
        this.businessCards = businessCards;
    }

    getOwner() {
        return this.owner;
    }

    setLost() {
        this.isLostStatus = !this.isLostStatus;
    }

    getIdCards() {
        return this.idCards;
    }

    addIdCard() {
        if (!this.isLostStatus) {
            const idCardName = prompt("Enter ID Card name: ");

            const idCardNumber = prompt("Enter ID Card number: ");

            const newIdCard = new IDCard(idCardName, idCardNumber, false);

            this.idCards.push(newIdCard);

            console.log("ID Card added to the wallet.");
        } else {
            console.log("Cannot add ID Card. The wallet is lost.");
        }
    }

    getMoneyList() {
        return this.moneyList;
    }

    addMoney() {
        if (!this.isLostStatus) {
            const amount = parseFloat(prompt("Enter the amount of money: "));

            console.log("Choose currency:");
            console.log("\n1. Dollars\n2. Euro\n3. Ariary");
            console.log();
            const currencyChoice = parseInt(prompt("\nEnter currency choice (1-3): "));

            let currency;
            switch (currencyChoice) {
                case 1:
                    currency = "Dollars";
                    break;
                case 2:
                    currency = "Euro";
                    break;
                case 3:
                    currency = "Ariary";
                    break;
                default:
                    console.log("Invalid currency choice. Using Dollars by default.");
                    currency = "Dollars";
            }

            const money = new Money(currency, amount);
            this.moneyList.push(money);
            console.log("Money added to the wallet.");
        } else {
            console.log("Cannot add money. The wallet is lost.");
        }
    }

    getCreditCards() {
        return this.creditCards;
    }

    addCreditCard() {
        if (!this.isLostStatus) {
            const cardOwner = prompt("Enter Credit Card owner: ");

            const cardNumber = prompt("Enter Credit Card number: ");

            const dateString = prompt("Enter expiration date (yyyy-MM-dd): ");
            const expirationDate = new Date(dateString);

            const newCreditCard = new CreditCard(cardOwner, cardNumber, expirationDate);
            this.creditCards.push(newCreditCard);

            console.log("Credit Card added to the wallet.");
        } else {
            console.log("Cannot add Credit Card. The wallet is lost.");
        }
    }

    getDrivingLicences() {
        return this.drivingLicences;
    }

    addDrivingLicence() {
        if (!this.isLostStatus) {
            const licenceOwner = prompt("Enter Driving Licence owner: ");

            console.log("Choose Driving Licence category:");
            console.log("1. A");
            console.log("2. B");
            console.log("3. C");
            console.log("4. D");
            console.log("5. E");
            const categoryChoice = parseInt(prompt("Enter category choice (1-5): "));

            let licenceCategory;
            switch (categoryChoice) {
                case 1:
                    licenceCategory = "A";
                    break;
                case 2:
                    licenceCategory = "B";
                    break;
                case 3:
                    licenceCategory = "C";
                    break;
                case 4:
                    licenceCategory = "D";
                    break;
                case 5:
                    licenceCategory = "E";
                    break;
                default:
                    console.log("Invalid category choice. Using A by default.");
                    licenceCategory = "A";
            }

            const newDrivingLicence = new DrivingLicence(licenceOwner, licenceCategory);
            this.drivingLicences.push(newDrivingLicence);

            console.log("Driving Licence added to the wallet.");
        } else {
            console.log("Cannot add Driving Licence. The wallet is lost.");
        }
    }

    getIdPhotos() {
        return this.idPhotos;
    }

    addIdPhoto() {
        if (!this.isLostStatus) {
            const photoOwner = prompt("Enter ID Photo owner: ");

            const newIdPhoto = new IDPhoto(photoOwner);
            this.idPhotos.push(newIdPhoto);

            console.log("ID Photo added to the wallet.");
        } else {
            console.log("Cannot add ID Photo. The wallet is lost.");
        }
    }

    getBusinessCards() {
        return this.businessCards;
    }

    addBusinessCard() {
        if (!this.isLostStatus) {
            const cardOwner = prompt("Enter Business Card owner: ");

            const companyName = prompt("Enter Company Name: ");

            const newBusinessCard = new BusinessCard(cardOwner, companyName);
            this.businessCards.push(newBusinessCard);

            console.log("Business Card added to the wallet.");
        } else {
            console.log("Cannot add Business Card. The wallet is lost.");
        }
    }

    removeItemByType(itemType) {
        switch (itemType) {
            case "ID_CARD":
                this.removeItem(this.getIdCards(), "ID Card");
                break;
            case "MONEY":
                this.removeItem(this.getMoneyList(), "Money item");
                break;
            case "CREDIT_CARD":
                this.removeItem(this.getCreditCards(), "Credit Card");
                break;
            case "BUSINESS_CARD":
                this.removeItem(this.getBusinessCards(), "Business Card");
                break;
            case "DRIVING_LICENCE":
                this.removeItem(this.getDrivingLicences(), "Driving Licence");
                break;
            case "ID_PHOTO":
                this.removeItem(this.getIdPhotos(), "ID Photo");
                break;
        }
    }
    
    removeItem(itemList, itemType) {
        if (itemList.length === 0) {
            console.log("\nNo " + itemType + "s found in the wallet.");
            return;
        }
    
        console.log("\n" + itemType + "s in the wallet:");
        for (let i = 0; i < itemList.length; i++) {
            console.log(`\n${i + 1}. ${JSON.stringify(itemList[i])}`);
        }
    
        const choice = parseInt(prompt("\nEnter the number of the " + itemType + " to remove:"));
    
        if (choice >= 1 && choice <= itemList.length) {
            const removedItem = itemList.splice(choice - 1, 1)[0];
            console.log("\nRemoved " + itemType + ": " + JSON.stringify(removedItem));
        } else {
            console.log("\nInvalid choice. No " + itemType + " removed.");
        }
    }
}

module.exports = Wallet;