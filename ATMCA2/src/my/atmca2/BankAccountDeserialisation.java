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
public class BankAccountDeserialisation {

    //Retrieving object information from .dat file
    public void Deserialise() throws FileNotFoundException, IOException, ClassNotFoundException {
        //Creating stream to read the object  
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("bankaccount.dat"));
        BankAccount bankaccount = (BankAccount) in.readObject();
        BankAccount bankaccount2 = (BankAccount) in.readObject();
        BankAccount bankaccount3 = (BankAccount) in.readObject();
        //closing the stream  
        in.close();
    }

}
