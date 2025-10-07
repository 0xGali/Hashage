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
            motN0 += "0";
            motN += mot.charAt(i);
        }
        return motN0+motN;
    }

    static String  xorStringBinaire(String mot1, String mot2){
        String xor = "";
        
        // Boucle qui compare chaque caractère des mots
        for (int i = 0; i < mot1.length(); i++)
        {
            //On vérifie si les caractères sont les mêmes
            if (mot1.charAt(i) == mot2.charAt(i))
                xor += "0";
            else
                xor += "1";
        }
        return xor;
    }

    public static String sigma0(String mot){
        return xorStringBinaire(xorStringBinaire(rotation(mot,7) , rotation(mot, 18)),decalage(mot, 3));
    }
}
