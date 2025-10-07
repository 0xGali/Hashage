package com.blockchain.sha256;

public class Convertion {

    //fonction qui convertit un string en une chaine de chiffres binaire
    public static String stringToBinary(String input) {
        StringBuilder binaryOutput = new StringBuilder();
        for (char c : input.toCharArray()) {
            int asciiValue = (int) c;
            String binaryChar = Integer.toBinaryString(asciiValue);
            binaryChar = String.format("%8s", binaryChar).replace(' ', '0');
            binaryOutput.append(binaryChar);
        }
        return binaryOutput.toString();
    }

}
