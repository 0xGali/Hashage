package com.blockchain.sha256;

public class TraitementMot {

    public static String sigma0(String mot){
        return Operations.xorBinaryStrings(Operations.xorBinaryStrings(Operations.rotation(mot,7) ,
                Operations.rotation(mot, 18)),Operations.decalage(mot, 3));
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
