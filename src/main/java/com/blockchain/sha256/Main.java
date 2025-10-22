package com.blockchain.sha256;
import java.util.Scanner;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Veuillez saisir la chaîne à hasher");
        Scanner sc = new Scanner(System.in);
        String entree = sc.nextLine();
        System.out.println("empreinte générée :");
        System.out.println(Hashage.Sha265(entree,new String[0]));
        //verification
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(entree.getBytes());
            byte hash[] = md.digest();
            System.out.println("Vérification :");
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
