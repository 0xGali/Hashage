package com.blockchain.sha256;


public class Hashage {

    private Boolean conversion = false;
    //fonction qui effectue le hachage complet
    public String Sha265(String entree,String[] blocsPrecedents){
        //conversion en chaîne binaire dans le cas où la conversion en binaire n'a pas été effectué
        if(conversion==false) {
            entree = Convertion.stringToBinary(entree);
            conversion = true;
        }
        String[] blocs = new String[blocsPrecedents.length+1];
        for (int i=0;i<blocsPrecedents.length;i++){
            blocs[i] = blocsPrecedents[i];
        }
        //si entree trop longue, on la stocke en tant que bloc et on utilise la recursivité pour appliquer l'algorithme
        //sur le reste de l'entree
        if(entree.length() > 447){
            blocs[blocs.length-1] = entree.substring(0,447);
            return Sha265(entree.substring(447), blocs);
        }
        else{
            blocs[blocs.length-1] = entree;
            try {
                String mots[][] = new String[blocs.length][64];
                for (int i = 0; i < blocs.length; i++) {
                    String messageRempli = Remplissage.remplir(entree);
                    String messageDecoupe[] = Decoupage.decoupe(messageRempli);
                    mots[i] = TraitementMot.creerMots(messageDecoupe);
                }
                VariablesHachage vh = new VariablesHachage();
                String reponse = vh.iterations(mots);
                conversion = false;
                return Convertion.binToHex(reponse);
            }
            //Gestion erreur
            catch(Exception e){
                e.printStackTrace();
                conversion = false;
                return "erreur";
            }
        }
    }
}
