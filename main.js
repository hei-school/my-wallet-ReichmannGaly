const Wallet = require('./items/wallet');
const MainUtils = require('./items/mainUtils');

const prompt = require("prompt-sync")();

function main() {
    const ownerName = prompt("Enter the name of the wallet owner: ");

    const userWallet = new Wallet(
        ownerName,
        false,
        [],
        [],
        [],
        [],
        [],
        []
    );

    while (true) {
        if (!userWallet.isLostStatus) {
            console.log("\n--- Wallet Management System ---");
            console.log("1. Display Wallet Information");
            console.log("2. Display items in the wallet");
            console.log("3. Add Items");
            console.log("4. Remove an item");
            console.log("5. Change isLost status");
            console.log("6. Exit");
            console.log();

            const choice = parseInt(prompt("Choose an option (1-6): "));

            switch (choice) {
                case 1:
                    MainUtils.displayWalletInformation(userWallet);
                    break;
                case 2:
                    MainUtils.displayItems(userWallet);
                    break;
                case 3:
                    MainUtils.addItems(userWallet);
                    break;
                case 4:
                    MainUtils.removeItem(userWallet);
                    break;
                case 5:
                    userWallet.setLost();
                    break;
                case 6:
                    console.log("Exiting Wallet Management System. Goodbye!");
                    process.exit(0);
                    break;
                default:
                    console.log("Invalid choice. Please enter a number between 1 and 6.");
            }
        } else {
            console.log("\n--- Wallet Management System ---");
            console.log("1. Display Wallet Information");
            console.log("2. Change isLost status");
            console.log("3. Exit");
            console.log();

            const choice = parseInt(prompt("\nWallet is currently lost, choose an option (1-3): "));

            switch (choice) {
                case 1:
                    MainUtils.displayWalletInformation(userWallet);
                    break;
                case 2:
                    userWallet.setLost();
                    break;
                case 3:
                    console.log("Exiting Wallet Management System. Goodbye!");
                    process.exit(0);
                    break;
                default:
                    console.log("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
    }
}

main();