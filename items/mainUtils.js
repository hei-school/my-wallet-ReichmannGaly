const prompt = require("prompt-sync")(); 

function displayItems(wallet) {
    while (true) {
        console.log("\n--- Item Management ---");
        console.log(
            `
            1. View ID Cards
            2. View Moneys
            3. View Credit Cards
            4. View Business Cards
            5. View Driving Licences
            6. View ID Photos
            7. Back to Main Menu`);

        const choice = parseInt(prompt("\nChoose an option (1-7): "));

        switch (choice) {
            case 1:
                printItemList(wallet.getIdCards());
                break;
            case 2:
                printItemList(wallet.getMoneyList());
                break;
            case 3:
                printItemList(wallet.getCreditCards());
                break;
            case 4:
                printItemList(wallet.getBusinessCards());
                break;
            case 5:
                printItemList(wallet.getDrivingLicences());
                break;
            case 6:
                printItemList(wallet.getIdPhotos());
                break;
            case 7:
                return;
            default:
                console.log("Invalid choice. Please enter a number between 1 and 7.");
        }
    }
}

function printItemList(itemList) {
    console.log("\nItems in the list:");
    if (itemList.length === 0) {
        console.log("No items found.");
    } else {
        for (let i = 0; i < itemList.length; i++) {
            console.log(`${i + 1}. ${JSON.stringify(itemList[i])}`);
        }
    }
}

function displayItemsCount(wallet) {
    console.log("\nID Cards: " + wallet.getIdCards().length);
    console.log("Moneys: " + wallet.getMoneyList().length);
    console.log("Credits cards: " + wallet.getCreditCards().length);
    console.log("Business cards: " + wallet.getBusinessCards().length);
    console.log("Driving licences: " + wallet.getDrivingLicences().length);
    console.log("ID photos: " + wallet.getIdPhotos().length);
}

function displayWalletInformation(wallet) {
    console.log("\n--- Wallet Information ---");
    console.log("Owner: " + wallet.getOwner());
    console.log("Lost: " + wallet.isLostStatus);
    console.log("Items in the wallet:");
    displayItemsCount(wallet);
}

function addItems(wallet) {
    while (true) {
        console.log("\n--- Item Management ---");
        console.log(
            `
            1. Add ID Card
            2. Add Money
            3. Add Credit Card
            4. Add Business Card
            5. Add Driving Licence
            6. Add ID Photos
            7. Back to Main Menu`);

        const choice = parseInt(prompt("\nChoose an option (1-7) :"));

        switch (choice) {
            case 1:
                wallet.addIdCard();
                break;
            case 2:
                wallet.addMoney();
                break;
            case 3:
                wallet.addCreditCard();
                break;
            case 4:
                wallet.addBusinessCard();
                break;
            case 5:
                wallet.addDrivingLicence();
                break;
            case 6:
                wallet.addIdPhoto();
                break;
            case 7:
                return;
            default:
                console.log("Invalid choice. Please enter a number between 1 and 7.");
        }
    }
}

function removeItem(wallet) {
    console.log("\n--- Remove Item ---");
    console.log(
        `
        1. Remove ID Card
        2. Remove Money
        3. Remove Credit Card
        4. Remove Business Card
        5. Remove Driving Licence
        6. Remove ID Photo
        7. Back to Item Management`);

    const choice = parseInt(prompt("Choose an option (1-7): "));

    switch (choice) {
        case 1:
            wallet.removeItemByType("ID_CARD");
            break;
        case 2:
            wallet.removeItemByType("MONEY");
            break;
        case 3:
            wallet.removeItemByType("CREDIT_CARD");
            break;
        case 4:
            wallet.removeItemByType("BUSINESS_CARD");
            break;
        case 5:
            wallet.removeItemByType("DRIVING_LICENCE");
            break;
        case 6:
            wallet.removeItemByType("ID_PHOTO");
            break;
        case 7:
            return;
        default:
            console.log("Invalid choice. Please enter a number between 1 and 7.");
    }
}

module.exports = {
    displayItems,
    printItemList,
    displayItemsCount,
    displayWalletInformation,
    addItems,
    removeItem
};
