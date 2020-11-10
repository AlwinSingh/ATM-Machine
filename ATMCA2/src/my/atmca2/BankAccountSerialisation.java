/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.atmca2;

import java.io.*;

/**
 *
 * @author Alwin Singh
 */
public class BankAccountSerialisation {

    //Getting information from .txt file and writing it to objects that are exported to DAT File
    String firstAccount;
    String[] firstAccountArr;

    String secondAccount;
    String[] secondAccountArr;

    String thirdAccount;
    String[] thirdAccountArr;

    public void writeText(BankAccount arr[]) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter("ATMAccounts.txt"))) {
            for (int i = 0; i < arr.length; i++) {
                pw.write(arr[i].getAcctNumber() + ";" + arr[i].getAcctPass() + ";" + arr[i].getBalance() + ";" + arr[i].getAcctType() + ";" + arr[i].getAcctHolderName() + "\n");
            }
//            pw.write(arr[0].getAcctNumber() + ";" + arr[0].getAcctPass() + ";" + arr[0].getBalance() + ";" + arr[0].getAcctType() + ";" + arr[0].getAcctHolderName() + "\n");
//            pw.write(arr[1].getAcctNumber() + ";" + arr[1].getAcctPass() + ";" + arr[1].getBalance() + ";" + arr[1].getAcctType() + ";" + arr[1].getAcctHolderName() + "\n");
//            pw.write(arr[1].getAcctNumber() + ";" + arr[1].getAcctPass() + ";" + arr[2].getBalance() + ";" + arr[2].getAcctType() + ";" + arr[2].getAcctHolderName() + "\n");
        }

    }

    public void writeTransactionHistory(String transaction, String username) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("ATMTransaction" + username + ".txt", false))) {
            //clearTransactionHistory(username);
            pw.write("S/N TRANSACTION  BALANCE AMOUNT\n");
            pw.write(transaction);
        } catch (IOException e) {
            System.out.println("Input Output Error!");
        }
    }

    public void clearTransactionHistory(String username) {
        try {
            PrintWriter pw = new PrintWriter("ATMTransaction" + username + ".txt");
            pw.write("S/N TRANSACTION  BALANCE AMOUNT\n");
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void readText() {
        try (BufferedReader br = new BufferedReader(new FileReader("ATMAccounts.txt"))) {
            firstAccount = br.readLine();
            firstAccountArr = firstAccount.split(";");

            secondAccount = br.readLine();
            secondAccountArr = secondAccount.split(";");

            thirdAccount = br.readLine();
            thirdAccountArr = thirdAccount.split(";");

            System.out.println(firstAccountArr[0] + " " + firstAccountArr[1] + " " + firstAccountArr[2] + " " + firstAccountArr[3] + " " + firstAccountArr[4]);
            System.out.println(secondAccountArr[0] + " " + secondAccountArr[1] + " " + secondAccountArr[2] + " " + secondAccountArr[3] + " " + secondAccountArr[4]);
            System.out.println(thirdAccountArr[0] + " " + thirdAccountArr[1] + " " + thirdAccountArr[2] + " " + thirdAccountArr[3] + " " + thirdAccountArr[4]);

        } catch (IOException e) {
        } finally {
        }
    }

    public void Serialisation(String filename) {
        try {
            BankAccount[] acctArr = new BankAccount[3];
            //Creating the object  
            acctArr[0] = new BankAccount(Integer.parseInt(firstAccountArr[0]), Integer.parseInt(firstAccountArr[1]), Double.valueOf(firstAccountArr[2]), firstAccountArr[3], firstAccountArr[4]);
            acctArr[1] = new BankAccount(Integer.parseInt(secondAccountArr[0]), Integer.parseInt(secondAccountArr[1]), Double.valueOf(secondAccountArr[2]), secondAccountArr[3], secondAccountArr[4]);
            acctArr[2] = new BankAccount(Integer.parseInt(thirdAccountArr[0]), Integer.parseInt(thirdAccountArr[1]), Double.valueOf(thirdAccountArr[2]), thirdAccountArr[3], thirdAccountArr[4]);
            //Creating stream and writing the object  
            FileOutputStream fout = new FileOutputStream(filename);
            try (ObjectOutputStream out = new ObjectOutputStream(fout)) {
                out.writeObject(acctArr);
                out.flush();
                //closing the stream
            }
            System.out.println("success");
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
