package com.blockchain.sha256;

public class VariablesHachage {

    public String H[];
    public String K[];

    public VariablesHachage() {
        H = new String[8];
        H[0] = Convertion.hexToBin("6a09e667");
        H[1] = Convertion.hexToBin("bb67ae85");
        H[2] = Convertion.hexToBin("3c6ef372");
        H[3] = Convertion.hexToBin("a54ff53a");
        H[4] = Convertion.hexToBin("510e527f");
        H[5] = Convertion.hexToBin("9b05688c");
        H[6] = Convertion.hexToBin("1f83d9ab");
        H[7] = Convertion.hexToBin("5be0cd19");
        K = recuperationDesK();
    }

    public String iterations(String[][] mots){
        String reponse = "";
        for(int i=0;i<mots.length;i++) {
            String S[] = new String[8];
            for (int j = 0; j < 8; j++) {
                S[j] = H[j];
            }
            for (int t = 0; t < 64; t++) {
                String T1 = Operations.addBinary(Operations.addBinary
                        (Operations.addBinary(
                                Operations.addBinary(String.valueOf(S[7]), sigma1(String.valueOf(S[4]))),
                                Ch(String.valueOf(S[4]), String.valueOf(S[5]), String.valueOf(S[6]))), K[t]
                        ), mots[i][t]);
                String T2 = Operations.addBinary(sigma1(String.valueOf(S[0])),
                        Maj(String.valueOf(S[0]), String.valueOf(S[1]), String.valueOf(S[2])));
                S[7] = S[6];
                S[6] = S[5];
                S[5] = S[4];
                S[4] = S[3];
                S[3] = S[2];
                S[2] = S[1];
                S[1] = S[0];
                S[0] = Operations.addBinary(T1, T2);
            }
            for (int j = 0; j < 8; j++) {
                H[j] = Operations.addBinary(H[j], S[j]);
                H[j] = Operations.modulo32Binary(H[j]);
            }
        }
        for (int i = 0; i < 8; i++) {
            reponse += H[i];
        }
        return reponse;
    }

    public String sigma0(String mot){
        return Operations.xorBinaryStrings(Operations.xorBinaryStrings(Operations.rotation(mot,2),
                        Operations.rotation(mot,13)),
                            Operations.rotation(mot,22));
    }

    public String sigma1(String mot){
        return Operations.xorBinaryStrings(Operations.xorBinaryStrings(Operations.rotation(mot,6),
                        Operations.rotation(mot,11)),
                            Operations.rotation(mot,25));
    }

    public String Ch(String x,String y, String z){
        String operation1 = (Operations.BinaryAnd(x,y));
        String operation2 = (Operations.BinaryAnd(Operations.BinaryNot(x),z));
        return Operations.xorBinaryStrings(operation1,
                operation2);
    }

    public String Maj(String x,String y, String z){
        String operation1 = (Operations.BinaryAnd(x,y));
        String operation2 = (Operations.BinaryAnd(x,z));
        String operation3 = (Operations.BinaryAnd(y,z));
        return Operations.xorBinaryStrings(Operations.xorBinaryStrings(operation1, operation2),operation3);
    }

    public String[] recuperationDesK(){
        String K[] = new String[64];
        Integer premiers[] = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53,
                59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131,
                137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223,
                227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311
        };

        for (int i = 0; i < 64; i++) {
            double racineCubique = Math.cbrt(premiers[i]);
            double partieDecimale = racineCubique - (int) racineCubique;
            String binaire = Convertion.doubleToBinary32(partieDecimale);
            K[i] = binaire;
        }

        return K;
    };


}
