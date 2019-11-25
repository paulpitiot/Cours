package cours; // Ce package doit contenir Clavier.java 

/**
 * Ce programme résout automatiquement le casse-tête de la tour d'hanoi sans récursivité et affiche la procédure à suivre.
 * @author BRETON Fabien
 */
public class tourDHanoi {
    static int nombreDAnneau; //Nombre d'anneaux que l'on place dans la tour
    static int tour; //Numero du tour actuel
    static int dernierMouvementDeLAnneau[]; //Tableau qui mémorise le dernier tour ou on a bougé chaque anneau
    static int anneauxPiquetA[],anneauxPiquetB[],anneauxPiquetC[]; //Tableaux qui listent les anneaux se trouvant sur les trois piquets. Un tableau par piquet.
    static int numeroAnneauActuel; //Numero de l'anneau que l'on bouge actuellement
            
    // Piste de reflexion :
    // 1er anneau : A-->B
    // 2em anneau : A-->C B-->C
    // 3em anneau : A-->B C-->A C-->B A-->B
    // 4em anneau : A-->C B-->C B-->A C-->A B-->C A-->B A-->C B-->C
    // Constatation 1 : Pour 1 anneau, on a 1 mouvement a faire,
    //                  pour2, 3 mouvements,
    //                  pour3, 7 mouvements,
    //                  --> pour N anneaux, on a (2^N)-1 mouvements à faire
    // Constatation 2 : le premier anneau bouge tout les 2 tours a partir du premier ; tour = 1 3 5 7 9 
    //                  le deuxieme, tout les 4 tours a partir du 2nd; tour = 2 6 10 14
    //                  le troisieme, tout les 8 tours a partir du 4em etc... tour = 4 12 20
    //                  --> L'anneau bouge quand tour = 2^(n°anneau-1) ou quand tour = derniertourbougé + 2^(n°anneau)

    // Par conséquent, au tour X : 
    // S'il n'y a d'anneaux que sur B ou que sur C, on a fini.
    // Sinon, on regarde l'anneau le plus petit 
    // Si c'est à son tour de bouger (utilisation de la Constatation2), on bouge.
    // Sinon on réessaye de même avec l'anneau suivant.
    // Lorsqu'on bouge un anneau, on mémorise d'ou il vient. 
    // S'il n'a jamais bougé, on en déduit qu'il vient de A, donc :
    //      S'il est impaire, il va en B.
    //      Sinon, il va en C. 
    // Sinon, il va la d'ou il ne vient pas.
    
    /**
     * Fonction principale qui réalise la totalité de l'opération.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Attention ! Au dela de 18 anneaux, la procédure de résolution du casse tête prendra plus d'une minute à s'afficher.\nSaisissez le nombre d'anneaux que contient la tour : ");
        nombreDAnneau = Clavier.lireInt(); //Initialisation de la variable contenant le nombre d'anneaux que contient la tour
        // Declaration de 3 tableaux ; un tableau d'anneaux pour chaque piquet.
        anneauxPiquetA = new int[nombreDAnneau];
        anneauxPiquetB = new int[nombreDAnneau]; 
        anneauxPiquetC = new int[nombreDAnneau];
        // Initialisation du tableau anneauxPiquetA avec tout les anneaux
        for(int i=0;i<nombreDAnneau;i++){
            anneauxPiquetA[i]=1;
        }
        //Declaration d'un booleen "fini" qui va servir à continuer la résolution du casse tête tant qu'il ne sera pas a "true"
        boolean fini=false;
        //Initialisation du tour (numero de passage dans la boucle)
        tour = 0;
        //Initialisation d'un tableau contenant l'emplacement d'ou vient l'anneau
        dernierMouvementDeLAnneau= new int[nombreDAnneau];
        for (int i=0;i<nombreDAnneau;i++){
            dernierMouvementDeLAnneau[i]=0;
        }
        //Tant que c'est pas fini
        while (!fini){
            tour++;
            //Si la tour est entierement sur B ou sur C, c'est qu'on a terminé.
            int SommeTestB=0;
            int SommeTestC=0;
            for (int i=0;i<nombreDAnneau;i++){
                if (anneauxPiquetB[i]== 1) SommeTestB++; 
                if (anneauxPiquetC[i]== 1) SommeTestC++;
            }
            if ((SommeTestB == nombreDAnneau)||(SommeTestC == nombreDAnneau)){
                fini = true;
            } else {
                //Sinon, tant qu'on n'a pas défini l'anneau qui doit bouger, on le cherche.
                //L'anneau doit bouger si tour = 2^(n°anneau-1) ou si tour = derniertourbougé + 2^(n°anneau)
                numeroAnneauActuel=0;
                while ((tour != (dernierMouvementDeLAnneau[numeroAnneauActuel] + Math.pow(2, numeroAnneauActuel+1)))&&(tour != Math.pow(2, numeroAnneauActuel))){
                    numeroAnneauActuel++;
                }
                //On a trouvé l'anneau à bouger, maintenant on le bouge
                //Affiche le déplacement que l'on vient d'effectuer
                System.out.print("Tour "+tour+" : On d�place l'anneau "+(numeroAnneauActuel+1)+" ");
                //Si un anneau n'a jamais bougé, il vient de A. Si il est impaire, il va dans B, sinon il va dans C.
                //Afin de mémoriser d'où on vient : On met des 0 à la place des 2 et des 2 à la place des 1.
                //Le 2 signifie alors "On en vient" ; le 1 signifie "On y est" et le 0 signifie "On ira après".
                if (dernierMouvementDeLAnneau[numeroAnneauActuel]==0){
                    anneauxPiquetA[numeroAnneauActuel]=2;
                    if ((numeroAnneauActuel+1)%2==1){
                        anneauxPiquetB[numeroAnneauActuel]=1;
                        System.out.println("de A vers B");
                    } else {
                        anneauxPiquetC[numeroAnneauActuel]=1;
                        System.out.println("de A vers C");
                    }
                } else {
                    //Sinon, on marque d'ou il vient et on le met là d'ou il ne vient pas. 
                    if(anneauxPiquetA[numeroAnneauActuel]==0){
                        anneauxPiquetA[numeroAnneauActuel]=1;
                        if(anneauxPiquetB[numeroAnneauActuel]==1){
                            anneauxPiquetB[numeroAnneauActuel]=2; 
                            anneauxPiquetC[numeroAnneauActuel]=0;
                            System.out.println("de B vers A");
                        } else {
                            anneauxPiquetB[numeroAnneauActuel]=0;
                            anneauxPiquetC[numeroAnneauActuel]=2;
                            System.out.println("de C vers A");
                        }
                    } else if(anneauxPiquetB[numeroAnneauActuel]==0){
                        anneauxPiquetB[numeroAnneauActuel]=1;
                        if(anneauxPiquetC[numeroAnneauActuel]==1){
                            anneauxPiquetC[numeroAnneauActuel]=2;
                            anneauxPiquetA[numeroAnneauActuel]=0;
                            System.out.println("de C vers B");
                        } else {
                            anneauxPiquetC[numeroAnneauActuel]=0;
                            anneauxPiquetA[numeroAnneauActuel]=2;
                            System.out.println("de A vers B");
                        }
                    } else {
                        anneauxPiquetC[numeroAnneauActuel]=1;
                        if(anneauxPiquetA[numeroAnneauActuel]==1){
                            anneauxPiquetA[numeroAnneauActuel]=2;
                            anneauxPiquetB[numeroAnneauActuel]=0;
                            System.out.println("de A vers C");
                        } else {
                            anneauxPiquetA[numeroAnneauActuel]=0;
                            anneauxPiquetB[numeroAnneauActuel]=2;
                            System.out.println("de B vers C");
                        }
                    }
                }
                //On mémorise le dernier tour ou on a bougé l'anneau
                dernierMouvementDeLAnneau[numeroAnneauActuel]=tour;
            }
        }
    } 
}
