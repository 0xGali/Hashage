package com.blockchain;

import java.security.MessageDigest;

public class Main3 {

    // Méthode utilitaire pour convertir un tableau de bytes en chaîne hexadécimale
    public static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        String a = "ABC025";
        String b = "0F0A";
        Integer nonce = 0;
        String d = "1 octobre 2024";
        String target = "00000ff";

        boolean e = false;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash_a = md.digest(a.getBytes("UTF-8"));
            byte[] hash_b = md.digest(b.getBytes("UTF-8"));
            byte[] hash_d = md.digest(d.getBytes("UTF-8"));

            String ab = bytesToHex(hash_a) + bytesToHex(hash_b);
            while(!e){
                String c = nonce.toString();
                byte[] hash_c = c.getBytes("UTF-8");
                String cd = bytesToHex(hash_c) + bytesToHex(hash_d);
                byte[] hash_ab = md.digest(ab.getBytes("UTF-8"));
                byte[] hash_cd = md.digest(cd.getBytes("UTF-8"));
                String abcd =  bytesToHex(hash_ab) + bytesToHex(hash_cd);
                byte[] hash_abcd = md.digest(abcd.getBytes("UTF-8"));
                if(bytesToHex(hash_abcd).compareTo(target) < 0)
                {
                    System.out.println("nonce trouvé : "+ nonce);
                    System.out.println("hash trouvé : " + bytesToHex(hash_abcd));
                    e = true;
                }
                System.out.println(nonce);
                nonce++;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
