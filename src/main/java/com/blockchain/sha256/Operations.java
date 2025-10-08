package com.blockchain.sha256;

public class Operations {

    public static String xorBinaryStrings(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            result.append((a.charAt(i) == b.charAt(i)) ? '0' : '1');
        }
        return result.toString();
    }

    // Addition de 2 nombres binaires
    static String add_Binary(String x, String y)
    {
        int num1 = Integer.parseInt(x, 2);
        int num2 = Integer.parseInt(y, 2);
        int sum = num1 + num2;
        String result = Integer.toBinaryString(sum);
        return result;
    }

    public static String rotation(String mot,int nbRota){
        String motN = ""+mot.charAt(mot.length()-1);
        for(int i=2;i<=nbRota;i++){
            motN = mot.charAt(mot.length()-i)+motN;
        }
        return motN+mot.substring(0,nbRota+2);
    }

    public static String decalage(String mot,int nbDecal){
        String motN0="";
        String motN="";
        for(int i=0;i<nbDecal;i++){
            motN0 = motN0+"0";
            motN = motN+mot.charAt(i);
        }
        return motN0+motN;
    }
}
