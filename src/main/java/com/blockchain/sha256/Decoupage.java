package com.blockchain.sha256;

public class Decoupage {

    public static String[] decoupe(String message) throws Exception{
        if(message.length()!= 512){
            System.out.println(message.length());
            throw new Exception();
        }
        String messageDecoupe[] = new String[64];
        for (int i = 0; i < 16; i++) {
            messageDecoupe[i] = message.substring(32*i, 32*i+32);
        }
        for (int j = 16; j < messageDecoupe.length; j++) {
            messageDecoupe[j] = "00000000000000000000000000000000";
        }
        return messageDecoupe;
    }
}
