package com.blockchain.sha256;

public class Operations {

    //fonction qui applique un xor entre 2 chaine binaires
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

    // Addition de 2 chaines binaires
    static String addBinary(String x, String y){
        long a = Long.parseLong(x, 2);
        long b = Long.parseLong(y, 2);
        long somme = (a + b) & 0xFFFFFFFFL;

        StringBuilder result = new StringBuilder(Long.toBinaryString(somme));
        while (result.length() < 32) {
            result.insert(0, "0");
        }

        return result.toString();
    }

    //rotation : pour un nombre de rotation donné, le dernier caractere de la chaine est ramené devant et les autres avance de 1
    public static String rotation(String mot,int nbRota){
        String motN = ""+mot.charAt(mot.length()-1);
        for(int i=2;i<=nbRota;i++){
            motN = mot.charAt(mot.length()-i)+motN;
        }
        return motN+mot.substring(0,mot.length()-nbRota);
    }

    //decalage : pour un nombre de decalage donné, on ajoute un zero au début de la chaine et la fin on coupe les caractères qui
    //dépassent de la taille initiale
    public static String decalage(String mot,int nbDecal){
        String motN0="";
        for(int i=0;i<nbDecal;i++){
            motN0 +="0";
        }
        return (motN0+mot).substring(0,mot.length());
    }

    //fonction qui reproduit un ET binaire sur 2 chaines binaires
    public static String BinaryAnd(String x,String y){
        if (x.length() != y.length()) {
            throw new IllegalArgumentException("Les chaînes binaires doivent avoir la même longueur.");
        }
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

    //fonction qui reproduit le NON binaire sur une chaine binaire (0 devient 1 et 1 devient 0)
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

    //fonction qui applique un modulo 2 puissance 32 à une chaine binaire
    public static String modulo32Binary(String binary) {
        long value = Long.parseUnsignedLong(binary, 2);
        long mod = value & 0xFFFFFFFFL;
        String modBinary = Long.toBinaryString(mod);
        modBinary = String.format("%32s", modBinary).replace(' ', '0');
        return modBinary;
    }

}