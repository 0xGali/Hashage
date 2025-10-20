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
                String mots[] = TraitementMot.creerMots(messageDecoupe);
                System.out.println("Mots generes :");
                for(int i=0;i<mots.length;i++){
                    System.out.println("mot "+i+" : "+mots[i]);
                }
                String reponse = "";
                VariablesHachage vh = new VariablesHachage();
                vh.iterations(mots);
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
