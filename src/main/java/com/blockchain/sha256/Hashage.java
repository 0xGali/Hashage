package com.blockchain.sha256;


public class Hashage {

    //fonction qui effectue le hachage complet
    static String Sha265(String entree,String[] blocsPrecedents){
        String entreeBinaire = Convertion.stringToBinary(entree);
        String[] blocs = new String[blocsPrecedents.length+1];
        for (int i=0;i<blocsPrecedents.length;i++){
            blocs[i] = blocsPrecedents[i];
        }
        if(entreeBinaire.length() > 447){
            blocs[blocs.length-1] = entreeBinaire.substring(0,447);
            return Sha265(entreeBinaire.substring(447), blocs);
        }
        else{
            blocs[blocs.length-1] = entreeBinaire;
            try {
                String mots[][] = new String[blocs.length][64];
                for (int i = 0; i < blocs.length; i++) {
                    String messageRempli = Remplissage.remplir(entreeBinaire);
                    String messageDecoupe[] = Decoupage.decoupe(messageRempli);
                    mots[i] = TraitementMot.creerMots(messageDecoupe);
                }
                VariablesHachage vh = new VariablesHachage();
                String reponse = vh.iterations(mots);
                return Convertion.binaryToHex(reponse);
            }
            //Gestion erreur
            catch(Exception e){
                e.printStackTrace();
                return "erreur";
            }
        }
    }
}
