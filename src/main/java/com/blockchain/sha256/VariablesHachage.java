package com.blockchain.sha256;

public class VariablesHachage {

    public String H0;
    public String H1;
    public String H2;
    public String H3;
    public String H4;
    public String H5;
    public String H6;
    public String H7;

    public VariablesHachage() {
        H0 = "6a09e667";
        H1 = "bb67ae85";
        H2 = "3c6ef372";
        H3 = "a54ff53a";
        H4 = "510e527f";
        H5 = "9b05688c";
        H6 = "1f83d9ab";
        H7 = "5be0cd19";
    }

    public void iteration(String[] mots){

    }

    public String sigma0(String mot){
        return "à faire";
    }

    public String sigma1(String mot){
        return "à faire";
    }

    public int Ch(int x,int y, int z){
        return 1;
    }
}
