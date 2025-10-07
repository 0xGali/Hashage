package com.blockchain.sha256;

import java.security.NoSuchAlgorithmException;

public class Remplissage {

    //fonction permettant le remplissage d'un message pour que sa taille atteigne 512 bits
    public static String remplir(String message) throws Exception{
        if(message.length()>447){
            throw new Exception();
        }
        int tailleInitiale = message.length();
        message += "1";
        StringBuilder messageBuilder = new StringBuilder(message);
        while(messageBuilder.length()<448){
            messageBuilder.append("0");}
        message = messageBuilder.toString();
        return message + padLeftZeros(Integer.toBinaryString(tailleInitiale), 64);
    }

    //fonction permettant de rajouter des 0 à gauche
    public static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }
}
