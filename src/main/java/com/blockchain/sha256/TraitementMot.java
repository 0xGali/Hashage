package com.blockchain.sha256;

public class TraitementMot {
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
