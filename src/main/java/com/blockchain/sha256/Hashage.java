package com.blockchain.sha256;


public class Hashage {

    //fonction qui effectue le hachage complet
    static String Sha265(String entree){
        String entreeBinaire = Convertion.stringToBinary(entree);
        if(entreeBinaire.length() > 447){
            return Sha265(entreeBinaire.substring(0, 447))+Sha265(entreeBinaire.substring(447));
        }
        else{
            try {
                String messageRempli = Remplissage.remplir(entreeBinaire);
                String messageDecoupe[] = Decoupage.decoupe(messageRempli);
                String reponse = "";
                for(int i=0; i<messageDecoupe.length; i++){
                    reponse += messageDecoupe[i]+" ";
                }
                return reponse;
            }
            //Gestion erreur
            catch(Exception e){
                e.printStackTrace();
                return "erreur";
            }
        }
    }
}
