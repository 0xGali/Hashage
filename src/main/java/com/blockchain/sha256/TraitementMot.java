package com.blockchain.sha256;

public class TraitementMot {

    public static String sigma0(String mot){
        return Operations.xorBinaryStrings(Operations.xorBinaryStrings(Operations.rotation(mot,7) ,
                    Operations.rotation(mot, 18)),
                        Operations.decalage(mot, 3));
    }

    public static String sigma1(String mot){
        return Operations.xorBinaryStrings(Operations.xorBinaryStrings(Operations.rotation(mot,17) ,
                    Operations.rotation(mot, 19)),
                        Operations.decalage(mot, 10));
    }

    public static String[] creerMots(String[] mots){
        for(int index=16;index<64;index++){
            mots[index]=Operations.add_Binary(Operations.add_Binary(Operations.add_Binary(sigma1(mots[index-2]),mots[index-7]),sigma0(mots[index-15])),mots[index-16]);
        }
        return mots;
    }
}
