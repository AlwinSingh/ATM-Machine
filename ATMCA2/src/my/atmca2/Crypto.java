/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.atmca2;

/**
 *
 * @author Alwin Singh
 */
public interface Crypto {

    byte[] encrypt(byte[] data);

    byte[] decrypt(byte[] data);

}
