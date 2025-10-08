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

    public void iterations(String[] mots){
        char S[] = new char[7];
        for(int i=0;i<8;i++){
            S = H[i].toCharArray();
        }
        for(int t=0;t<64;t++){
            Operations.add_Binary(Operations.add_Binary
                    (Operations.add_Binary(
                            Operations.add_Binary(String.valueOf(S[7]),sigma1(String.valueOf(S[4]))),
                            Ch(String.valueOf(S[4]),String.valueOf(S[5]),String.valueOf(S[6]))),K[t]
                            ),mots[t]);
        }
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
        Boolean boolx = Convertion.intToBoolean(Integer.parseInt(x));
        Boolean booly = Convertion.intToBoolean(Integer.parseInt(x));
        Boolean boolz = Convertion.intToBoolean(Integer.parseInt(x));
        Boolean operation1 = (boolx && booly);
        Boolean operation2 = (!boolx && boolz);
        return Operations.xorBinaryStrings(Convertion.BooleanToString(operation1),
                Convertion.BooleanToString(operation2));
    }

    public String Maj(String x,String y, String z){
        Boolean boolx = Convertion.intToBoolean(Integer.parseInt(x));
        Boolean booly = Convertion.intToBoolean(Integer.parseInt(x));
        Boolean boolz = Convertion.intToBoolean(Integer.parseInt(x));
        Boolean operation1 = (boolx && booly);
        Boolean operation2 = (boolx && boolz);
        Boolean operation3 = (booly && boolz);
        return Operations.xorBinaryStrings(Operations.xorBinaryStrings(Convertion.BooleanToString(operation1),
                        Convertion.BooleanToString(operation2))
                ,Convertion.BooleanToString(operation3));
    }

    public String[] recuperationDesK(){
        String K[] = new String[64];
        return K;
    };


}
