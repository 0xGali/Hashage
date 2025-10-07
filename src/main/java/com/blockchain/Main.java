package com.blockchain;
import java.security.MessageDigest;
public class Main {
    public static void main1(String[] args){
        String a = "Acheter 0.5 BTC";
        String b = "Vendre 0.1 ETH";
        String c = "Vendre 2 ADA";
        String d = "Acheter 4 XRP";
        String e = "Acheter 3 Cro";


        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(a.getBytes());
            byte hash_a[] = md.digest();

            md.update(b.getBytes());
            byte hash_b[] = md.digest();
            md.update(c.getBytes());
            byte hash_c[] = md.digest();
            md.update(d.getBytes());
            byte hash_d[] = md.digest();
            md.update(e.getBytes());
            byte hash_e[] = md.digest();

            String ab = hash_a.toString()+hash_b.toString();
            md.update(ab.getBytes());
            byte hash_ab[] = md.digest();

            String cd = hash_c.toString()+hash_d.toString();
            md.update(cd.getBytes());
            byte hash_cd[] = md.digest();

            String ee = hash_e.toString()+hash_e.toString();
            md.update(ee.getBytes());
            byte hash_ee[] = md.digest();

            String abcd = hash_ab.toString()+hash_cd.toString();
            md.update(abcd.getBytes());
            byte hash_abcd[] = md.digest();

            String eeee = hash_ee.toString()+hash_ee.toString();
            md.update(eeee.getBytes());
            byte hash_eeee[] = md.digest();

            String abcdeeee = hash_abcd.toString()+hash_eeee.toString();
            md.update(abcdeeee.getBytes());
            byte hash_abcdeeee[] = md.digest();

            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < hash_abcd.length; i++) {
                sb.append(Integer.toString((hash_abcdeeee[i] & 0xff) + 0x100, 16).substring(1));
            }

            System.out.println("En format hexa : " + sb.toString());
        }
        catch (Exception f){
            System.out.println(f.getMessage());
        }
    }
}