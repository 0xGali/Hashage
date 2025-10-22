package com.blockchain.sha256;

public class Operations {

    public static String xorBinaryStrings(String a, String b) {
        if (a.length() != b.length()) {
            throw new IllegalArgumentException("Les chaînes binaires doivent avoir la même longueur.");
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            result.append((a.charAt(i) == b.charAt(i)) ? '0' : '1');
        }
        return result.toString();
    }

    // Addition de 2 nombres binaires
    static String addBinary(String x, String y){
        long a = Long.parseLong(x, 2);
        long b = Long.parseLong(y, 2);
        long somme = (a + b) & 0xFFFFFFFFL;

        String result = Long.toBinaryString(somme);
        while (result.length() < 32) {
            result = "0" + result;
        }

        return result;
    }

    public static String rotation(String mot,int nbRota){
        String motN = ""+mot.charAt(mot.length()-1);
        for(int i=2;i<=nbRota;i++){
            motN = mot.charAt(mot.length()-i)+motN;
        }
        return motN+mot.substring(0,mot.length()-nbRota);
    }

    public static String decalage(String mot,int nbDecal){
        String motN0="";
        String motN="";
        for(int i=0;i<nbDecal;i++){
            motN0 +="0";
        }
        return motN0+mot.substring(0,mot.length()-motN0.length());
    }

    public static String BinaryAnd(String x,String y){
        String reponse = "";
        for(int i =0;i<x.length();i++){
            if(x.charAt(i) == y.charAt(i)){
                reponse += x.charAt(i);
            }
            else {
                reponse += "0";
            }
        }
        return reponse;
    }

    public static String BinaryNot(String x){
        String reponse = "";
        for(int i =0;i<x.length();i++){
            if(x.charAt(i) == '0'){
                reponse+='1';
            }
            else {
                reponse += "0";
            }
        }
        return reponse;
    }

    public static String modulo32Binary(String binary) {
        long value = Long.parseUnsignedLong(binary, 2);
        long mod = value & 0xFFFFFFFFL;
        String modBinary = Long.toBinaryString(mod);
        modBinary = String.format("%32s", modBinary).replace(' ', '0');
        return modBinary;
    }
}