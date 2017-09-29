package logiciel_ascenseur.gestion_elem_mecaniques;

import logiciel_ascenseur.gestion_elem_composites.Etage;
import logiciel_ascenseur.gestion_elem_composites.Cabine;

public class Bouton {

    private int numero;
    private Etage lEtage;
    private EEtatBouton etatBouton;
    private EDirection d;

    private final static int NB_BOUTONS = 4;
    private static Bouton[] lesBoutons = new Bouton[NB_BOUTONS];

    //Initialisation
    public Bouton(int numBouton) {
        lesBoutons[numBouton] = this;
        this.numero = numBouton;
        this.lEtage = null;
    }
    
    public Bouton(int numBouton,EDirection direction) {
        lesBoutons[numBouton] = this;
        this.numero = numBouton;
        this.lEtage = null;
        this.d=direction;
    }
    
    public void enregistrerEtage(Etage lEtage){
        this.lEtage = lEtage;
    }

    public void notificationPression() {
        //...
        this.lEtage.notificationPression(this);
        //...
    }
    
    public EDirection getDirection(){
    	return d;
    }
}
