package com.blockchain;
import java.security.MessageDigest;

public class Main2 {
    public static void main(String[] args) {
        String T1 = "Jean -> Bob : 10";
        String T2 = "Bob -> Julien : 5";
        String T3 = "Julien -> Omar : 7";
        String T4 = "Omar -> Alice : 2";
        String T5 = "Anaïs -> Frank : 3";
        String T6 = "Frank -> Grace : 8";
        String T7 = "Omar -> Lili : 6";
        String T8 = "Heidi -> JF : 4";

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Hash des feuilles
            byte[] hash_T1 = md.digest(T1.getBytes("UTF-8"));
            byte[] hash_T2 = md.digest(T2.getBytes("UTF-8"));
            byte[] hash_T3 = md.digest(T3.getBytes("UTF-8"));
            byte[] hash_T4 = md.digest(T4.getBytes("UTF-8"));
            byte[] hash_T5 = md.digest(T5.getBytes("UTF-8"));
            byte[] hash_T6 = md.digest(T6.getBytes("UTF-8"));
            byte[] hash_T7 = md.digest(T7.getBytes("UTF-8"));
            byte[] hash_T8 = md.digest(T8.getBytes("UTF-8"));

            // Niveau 1 : concaténation des feuilles
            String T1T2 = bytesToHex(hash_T1) + bytesToHex(hash_T2);
            String T3T4 = bytesToHex(hash_T3) + bytesToHex(hash_T4);
            String T5T6 = bytesToHex(hash_T5) + bytesToHex(hash_T6);
            String T7T8 = bytesToHex(hash_T7) + bytesToHex(hash_T8);

            // Hash des nœuds du niveau 1
            byte[] hash_T1T2 = md.digest(T1T2.getBytes("UTF-8"));
            byte[] hash_T3T4 = md.digest(T3T4.getBytes("UTF-8"));
            byte[] hash_T5T6 = md.digest(T5T6.getBytes("UTF-8"));
            byte[] hash_T7T8 = md.digest(T7T8.getBytes("UTF-8"));

            // Niveau 2 : concaténation des nœuds du niveau 1
            String T12T34 = bytesToHex(hash_T1T2) + bytesToHex(hash_T3T4);
            String T56T78 = bytesToHex(hash_T5T6) + bytesToHex(hash_T7T8);

            // Hash des nœuds du niveau 2
            byte[] hash_T12T34 = md.digest(T12T34.getBytes("UTF-8"));
            byte[] hash_T56T78 = md.digest(T56T78.getBytes("UTF-8"));

            // Racine : concaténation des nœuds du niveau 2
            String T12345678 = bytesToHex(hash_T12T34) + bytesToHex(hash_T56T78);

            // Hash de la racine
            byte[] hash_T12345678 = md.digest(T12345678.getBytes("UTF-8"));

            System.out.println("Racine de l'arbre de Merkle : " + bytesToHex(hash_T12345678));

            // Test valeur T3
            String T3test = "Julien -> Omar : 70";
            byte[] hash_T3test = md.digest(T3test.getBytes("UTF-8"));
            String T3T4test = bytesToHex(hash_T3test) + bytesToHex(hash_T4);
            byte[] hash_T3T4test = md.digest(T3T4test.getBytes("UTF-8"));

            String T34testT12 = bytesToHex(hash_T1T2) + bytesToHex(hash_T3T4test);

            byte[] hash_T34testT12 = md.digest(T34testT12.getBytes("UTF-8"));

            String T1234testT5678 = bytesToHex(hash_T34testT12) + bytesToHex(hash_T56T78);

            byte[] hash_T1234testT5678 = md.digest(T1234testT5678.getBytes("UTF-8"));

            System.out.println("Test T3 modifié : " + bytesToHex(hash_T1234testT5678));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
}


//2048 transaction = 2^11 donc je dirais 12 calculs de hash