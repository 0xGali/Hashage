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

    public static boolean intToBoolean(int num) {
        if (num != 0 && num != 1) {
            throw new IllegalArgumentException("Input must be 0 or 1");
        }
        return num == 0? false : true;
    }

    public static String BooleanToString(Boolean bool) {
        if (bool) {
            return "1";
        }
        return "0";
    }

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
