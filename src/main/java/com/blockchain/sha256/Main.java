package com.blockchain.sha256;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(Hashage.Sha265("abc"));
        System.out.println(Operations.decalage("111111",3));
        System.out.println(101^010);

        String motsDecoupe = Hashage.Sha265("abc");
        String[] mots = TraitementMot.creerMots(motsDecoupe);
        System.out.println("Mots generes :");
        for(int i=0;i<mots.length;i++){
            System.out.println("mot "+i+" : "+mots[i]);
        }
    }
}
