package com.blockchain.sha256;

public class Convertion {

    //fonction qui convertit un string en une chaine binaire
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

    //fonction qui convertit une chaine de caractères hexadécimale en chaine binaire
    public static String hexToBin(String hex){
        hex = hex.replaceAll("0", "0000");
        hex = hex.replaceAll("1", "0001");
        hex = hex.replaceAll("2", "0010");
        hex = hex.replaceAll("3", "0011");
        hex = hex.replaceAll("4", "0100");
        hex = hex.replaceAll("5", "0101");
        hex = hex.replaceAll("6", "0110");
        hex = hex.replaceAll("7", "0111");
        hex = hex.replaceAll("8", "1000");
        hex = hex.replaceAll("9", "1001");
        hex = hex.replaceAll("a", "1010");
        hex = hex.replaceAll("b", "1011");
        hex = hex.replaceAll("c", "1100");
        hex = hex.replaceAll("d", "1101");
        hex = hex.replaceAll("e", "1110");
        hex = hex.replaceAll("f", "1111");
        return hex;
    }

    //fonction qui convertit une chaine de caractères binaire en chaine hexadecimale
    public static String binToHex(String binary) {
        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 8) {
            String byteStr = binary.substring(i, i + 8);
            int byteValue = Integer.parseInt(byteStr, 2);
            // Formate en 2 chiffres hexadécimaux
            String hexByte = String.format("%02x", byteValue);
            hex.append(hexByte);
        }
        return hex.toString();
    }

    //fonction qui convertit une valeur décimale en une chaine binaire de taille 32 caractères
    public static String doubleToBinary32(double partieDecimale) {
        StringBuilder binaire = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            partieDecimale *= 2;
            int bit = (int) partieDecimale;
            binaire.append(bit);
            partieDecimale -= bit;
        }
        return binaire.toString();
    }

}
