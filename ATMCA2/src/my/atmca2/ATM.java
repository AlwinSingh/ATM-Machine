/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.atmca2;

import java.awt.Dimension;
import java.io.IOException;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Alwin Singh
 */
public class ATM extends BankAccountDeserialisation {

    JFrame jf = new JFrame();
    DecimalFormat df = new DecimalFormat("###.#");
    BankAccountSerialisation serialise = new BankAccountSerialisation();
    BankAccountDeserialisation deserialise = new BankAccountDeserialisation();

    public boolean proceed, activatebutton = false;
    private String transaction = "";
    private int transactionindex = 0;
    String filename = "bankaccount.dat";
    File datFile = new File("bankaccount.dat");

    //Defines 3 bank account objects with the format (Acc Number, Acc Pin, Balance)
    BankAccount bankaccount = new BankAccount();
    BankAccount bankaccount2 = new BankAccount();
    BankAccount bankaccount3 = new BankAccount();

    BankAccount[] arr = null; //Defines an Array with the name 'arr' which will contain 3 objects
    BankAccount[] CurrentUser = new BankAccount[1]; //Defines an Array with the name 'CurrentUser' which will contain 1 object
    //CurrentUser will hold the object of the current account in use
    //SavingsAccount will hold the savings object if the current user is of Savings Acct
    SavingsAccount[] savingsUser = new SavingsAccount[1];
    MoneyMarketAccount[] moneymarketUser = new MoneyMarketAccount[1];

    public void validateFile() throws IOException, FileNotFoundException, ClassNotFoundException {
        if (datFile.exists() && !datFile.isDirectory()) {
            System.out.println(datFile + " exist, serialisating and deserialising from DAT file");
            loadDATBankAccts();
        } else {
            System.out.println(datFile + " does not exist, reading from text file & creating dat file");
            loadTXTBankAccts();
        }
    }

    public void loadTXTBankAccts() {
        serialise.readText();
        bankaccount = new BankAccount(Integer.parseInt(serialise.firstAccountArr[0]), Integer.parseInt(serialise.firstAccountArr[1]),
                Double.valueOf(serialise.firstAccountArr[2]), serialise.firstAccountArr[3], serialise.firstAccountArr[4]);

        bankaccount2 = new BankAccount(Integer.parseInt(serialise.secondAccountArr[0]), Integer.parseInt(serialise.secondAccountArr[1]),
                Double.valueOf(serialise.secondAccountArr[2]), serialise.secondAccountArr[3], serialise.secondAccountArr[4]);

        bankaccount3 = new BankAccount(Integer.parseInt(serialise.thirdAccountArr[0]), Integer.parseInt(serialise.thirdAccountArr[1]),
                Double.valueOf(serialise.thirdAccountArr[2]), serialise.thirdAccountArr[3], serialise.thirdAccountArr[4]);
    }

    public void loadDATBankAccts() throws FileNotFoundException, IOException, ClassNotFoundException {
        serialise.readText();
        serialise.Serialisation(filename);
        //Defines 3 bank account objects with the format (Acc Number, Acc Pin, Balance)

        //Below is Deserialisation
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("bankaccount.dat"));
        arr = (BankAccount[]) in.readObject();
    }

    public void ATMDialogValidateNum(String accnum) {
        if (Integer.parseInt(accnum) == arr[0].getAcctNumber()) {
            proceed = true;
            CurrentUser[0] = arr[0];
            callSavingsAcctRate();
        } else if (Integer.parseInt(accnum) == arr[1].getAcctNumber()) {
            proceed = true;
            CurrentUser[0] = arr[1];
            callSavingsAcctRate();
        } else if (Integer.parseInt(accnum) == arr[2].getAcctNumber()) {
            proceed = true;
            CurrentUser[0] = arr[2];
            callSavingsAcctRate();
        } else {
            proceed = false;
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Invalid account number", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void callSavingsAcctRate() {
        if ("Savings".equals(CurrentUser[0].getAcctType())) {
            System.out.println("Savings Account!");
            savingsUser[0] = new SavingsAccount(CurrentUser[0].getAcctNumber(), CurrentUser[0].getAcctPass(), CurrentUser[0].getBalance(), CurrentUser[0].getAcctType(), CurrentUser[0].getAcctHolderName());

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() { // Function runs every MINUTES minutes.
                    // Run the code you want here
                    try {
                        double newInterestBalance = savingsUser[0].interestRate(CurrentUser[0].getBalance());
                        CurrentUser[0].setBalance(newInterestBalance);
                        System.out.println("After Interest: " + CurrentUser[0].getBalance());
                    } catch (NullPointerException e) {
                        System.out.println("No logged in user, savings interest rate will hold!");
                        timer.cancel();
                    }
                }
             ;
            }, 0, 6000);
        }

        if ("MoneyMarket".equals(CurrentUser[0].getAcctType())) {
            System.out.println("Money Market Account!");
            moneymarketUser[0] = new MoneyMarketAccount(CurrentUser[0].getAcctNumber(), CurrentUser[0].getAcctPass(), CurrentUser[0].getBalance(), CurrentUser[0].getAcctType(), CurrentUser[0].getAcctHolderName());

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() { // Function runs every MINUTES minutes.
                    // Run the code you want here
                    try {
                        double newInterestBalance = moneymarketUser[0].interestRate(CurrentUser[0].getBalance());
                        CurrentUser[0].setBalance(newInterestBalance);
                        System.out.println("After Interest: " + CurrentUser[0].getBalance());
                    } catch (NullPointerException e) {
                        System.out.println("No logged in user, money market interest rate will hold!");
                        timer.cancel();
                    }
                }
             ;
            }, 0, 6000);
        }

        if ("Current".equals(CurrentUser[0].getAcctType())) {
            System.out.println("Current Account!");
        }
    }

    public void ATMDialogValidatePin(String accpass) {
        if (Integer.parseInt(accpass) == CurrentUser[0].getAcctPass()) {
            activatebutton = true;
        } else {
            activatebutton = false;
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Invalid account pin", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public double checkBalance() {
        return CurrentUser[0].getBalance();
    }

    public void ATMWithdraw(double withdraw) {
        jf.setAlwaysOnTop(true);
        double currentbalance = CurrentUser[0].getBalance();
        boolean displayBal = true; //Boolean value used to display balance messageDialog

        if ("MoneyMarket".equals(CurrentUser[0].getAcctType())) {
            if (moneymarketUser[0].dailyTransaction() > 4) {
                JOptionPane.showMessageDialog(jf, "Exceeded daily transaction limit", "Error", JOptionPane.OK_OPTION);
                displayBal = false;
                return;
            }
        }

        if ("Current".equals(CurrentUser[0].getAcctType())) {
            if (currentbalance < 400) {
                JOptionPane.showMessageDialog(jf, "To withdraw, account must have $400", "Error", JOptionPane.OK_OPTION);
                displayBal = false;
                return;
            }
        }

        if (currentbalance < 1) {
            JOptionPane.showMessageDialog(jf, "Insufficient funds to withdraw!", "Error", JOptionPane.OK_OPTION);
            displayBal = false;
            return;
        } else {
            //Requests user's string input for withdrawal and converts it to a Double
            if (withdraw < 1 || withdraw > currentbalance) {
                //Displays a message dialog if withdrawal amount is invalid
                JOptionPane.showMessageDialog(jf, "Invalid amount! The amount to withdraw must be greater than 0 and less than $" + currentbalance, "Error", JOptionPane.OK_OPTION);
                return;
            }

            if (withdraw % 1 != 0) {
                JOptionPane.showMessageDialog(jf, "Machine does not dispense coins!", "Error", JOptionPane.OK_OPTION);
                return;
            }
        }

        double newbalance = currentbalance - withdraw; //Retrieves the new balance after withdrawal
        CurrentUser[0].setBalance(newbalance); //Sets the new balance to the account

        transactionindex++;
        transaction += transactionindex + ". Withdrawed" + " " + " " + df.format(withdraw) + " " + "$" + newbalance + "\n";
        serialise.writeTransactionHistory(transaction, CurrentUser[0].getAcctHolderName());
    }

    public void ATMDeposit(double deposit) {
        jf.setAlwaysOnTop(true);
        //System.out.println(CurrentUser[0].getBalance());

        if ("MoneyMarket".equals(CurrentUser[0].getAcctType())) {
            if (moneymarketUser[0].dailyTransaction() >= 5) {
                JOptionPane.showMessageDialog(jf, "Exceeded daily transaction limit", "Error", JOptionPane.OK_OPTION);
                return;
            }
        }

        double currentbalance = CurrentUser[0].getBalance(); //stores the new balance after withdrawal for the setBalance method
        boolean isWhole; //Checks if number is a whole number as ATM only accepts notes

        if (deposit < 1) {
            JOptionPane.showMessageDialog(jf, "Invalid amount! The amount to be deposited must be greater than 0.", "Error", JOptionPane.OK_OPTION);
            return;
        }

        if (deposit % 1 == 0) {
            //Uses modulus to identify if number has decimal places (Whole number / Not)
            //Whole number will have a remainder of 0
            isWhole = true; //
        } else {
            //Floating point numbers will have a remainder of the decimal value
            JOptionPane.showMessageDialog(jf, "Machine does not accept coins! Only notes!.", "Error", JOptionPane.OK_OPTION);
            isWhole = false;
            return;
        }

        double newbalance = currentbalance + deposit; //Gets the new balance after deposit
        CurrentUser[0].setBalance(newbalance); //Sets the new balance to the user's account
        //System.out.println("New Balance: " + newbalance);

        transactionindex++;
        transaction += transactionindex + "\tDeposited\t" + df.format(deposit) + "\t" + newbalance + "\n";
        serialise.writeTransactionHistory(transaction, CurrentUser[0].getAcctHolderName());
    }

    public void ATMClearTransaction() {
        serialise.clearTransactionHistory(CurrentUser[0].getAcctHolderName());
    }

    public void ATMChangePass() {
        jf.setAlwaysOnTop(true);
        int pass = Integer.parseInt(JOptionPane.showInputDialog(jf, "Please enter your password", "ATM", JOptionPane.QUESTION_MESSAGE));
        int confirmpass = Integer.parseInt(JOptionPane.showInputDialog(jf, "Please reenter your password", "ATM", JOptionPane.QUESTION_MESSAGE));

        if (pass != confirmpass) {
            //pass must equal to confirmpass else it will exit as Security
            JOptionPane.showMessageDialog(jf, "The passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (pass == CurrentUser[0].getAcctPass()) {
            JOptionPane.showMessageDialog(jf, "That is your current password!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            CurrentUser[0].setPassword(pass); //Updates the current user's password
            JOptionPane.showMessageDialog(jf, "You have successfully changed your password!", "Success", JOptionPane.QUESTION_MESSAGE);
        }

    }

    public void ATMExit() {
        try {
            serialise.writeText(arr);
        } catch (IOException e) {
            System.out.println("Input Output Exception!");
        }
        transaction = "";
        transactionindex = 0;
        serialise.readText();
        serialise.Serialisation(filename);
        jf.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(jf, "Card Removed! \nThank you for banking with us!", "Message", JOptionPane.INFORMATION_MESSAGE);
        CurrentUser[0] = null;
        //System.exit(0);
    }

    // Below are methods used to Log the account number
    public String ATMLogAccNum() {
        //getAcctNumber() returns a Integer
        //Since this method returns a String hence Integer.toString converts it from int to String
        return Integer.toString(CurrentUser[0].getAcctNumber());
    }

    public String ATMLogBalance() {
        //getBalance() returns a Double
        //Since this method returns a String hence Double.toString converts it from double to String
        return Double.toString(CurrentUser[0].getBalance());
    }

    public void displayTXTStatements(String username) {
        JTextArea ta = new JTextArea();
        JScrollPane scroll = new JScrollPane(ta,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        ta.setPreferredSize(new Dimension(520, 500));

        try {
            BufferedReader br = new BufferedReader(new FileReader("ATMTransaction" + username + ".txt"));
            try {
                String fileLine = null;
                String concatText = "";
                while ((fileLine = br.readLine()) != null) {
                    concatText += (fileLine + "\n");
                    concatText = concatText.replaceAll(" ", "\t");
                    System.out.println(concatText);
                }
                ta.setToolTipText("You are viewing your transaction history");
                ta.setText(concatText);
                ta.setEditable(false);

                JOptionPane.showConfirmDialog(jf, scroll);

                switch (JOptionPane.showConfirmDialog(null, new JScrollPane(ta))) {
                    case JOptionPane.OK_OPTION:
                        System.out.println(ta.getText());
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        System.out.println(ta.getText());
                        break;
                    case JOptionPane.YES_NO_CANCEL_OPTION:
                        System.out.println("Universal");
                        break;
                }
            } catch (IOException e) {
                System.out.println("I/O Error!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found, fret not, we will create it for you!");
            serialise.writeTransactionHistory(transaction, CurrentUser[0].getAcctHolderName());
        }
    }

    public void callDisplayStatements() {
        displayTXTStatements(CurrentUser[0].getAcctHolderName());
    }

    public void displayWelcome() {
        JOptionPane.showMessageDialog(jf, CurrentUser[0].getAcctHolderName() + ", Welcome to the ATM! \n "
                + "Account Type: " + CurrentUser[0].getAcctType() + "\n"
                + "Balance: " + CurrentUser[0].getBalance());
    }

    public void PlaySound(File Sound) {
        //Uses Try-Catch Error

        String errorMessage = null; //Initialises errorMessage
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();
            //Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            errorMessage = e.getMessage();
        } finally {
            System.out.println(errorMessage);
        }
    }

    public void PlayBtnSound(File Sound) {
        //Uses Try-Catch Error

        String errorMessage = null; //Initialises errorMessage
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();
            //Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            errorMessage = e.getMessage();
        } finally {
            if (errorMessage == null) {
                System.out.println("Audio played successfully!");
            } else {
                System.out.println(errorMessage);
            }
        }
    }
}
