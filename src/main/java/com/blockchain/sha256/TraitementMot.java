package com.blockchain.sha256;

public class TraitementMot {

    public static String sigma0(String mot){
        return Operations.xorBinaryStrings(Operations.xorBinaryStrings(Operations.rotation(mot,7) ,
                Operations.rotation(mot, 18)),Operations.decalage(mot, 3));
    }
}
