package logiciel_ascenseur.gestion_elem_composites;

import logiciel_ascenseur.gestion_elem_mecaniques.Porte;
import logiciel_ascenseur.gestion_elem_mecaniques.Bouton;
import logiciel_ascenseur.gestion_services.GestionServices;

public class Etage {

    private int numero;
    private Porte laPorteEtage;
    private Bouton leBoutonAppelUp;
    private Bouton leBoutonAppelDown;
    private boolean estEnService;

    private final static int NB_ETAGES = 4;
    private static Etage[] lesEtages = new Etage[NB_ETAGES];

    //Initialisation
    public Etage(int numEtage, Bouton leBoutonAppelUp, Bouton leBoutonAppelDown,  Porte laPorteEtage) {
        lesEtages[numEtage] = this;
        this.numero = numEtage;
        this.estEnService = true;
        this.leBoutonAppelUp = leBoutonAppelUp;
        this.laPorteEtage = laPorteEtage;
        this.leBoutonAppelDown = leBoutonAppelDown;
        this.leBoutonAppelDown.enregistrerEtage(this);
        this.leBoutonAppelUp.enregistrerEtage(this);
        this.laPorteEtage.enregistrerEtage(this);
    }
    
    public Etage(int numEtage, Bouton leBoutonAppelDown,  Porte laPorteEtage) {
        lesEtages[numEtage] = this;
        this.numero = numEtage;
        this.estEnService = true;
        this.laPorteEtage = laPorteEtage;
        this.leBoutonAppelDown = leBoutonAppelDown;
        this.leBoutonAppelDown.enregistrerEtage(this);
        this.laPorteEtage.enregistrerEtage(this);
    }

    public void notificationPression(Bouton leBoutonPresse) {
    	if(leBoutonPresse==this.leBoutonAppelUp && this.estEnService){
    		 GestionServices.notificationAppel(this, "UP");
    	}
    	if(leBoutonPresse==this.leBoutonAppelDown && this.estEnService){ {
            GestionServices.notificationAppel(this, "DOWN");
        }
        //...
    	}
    }
    public void requeteDesservir() {
        //...
        this.laPorteEtage.requeteOuvrir();
        //...
    }
    
    public int getNumEtage(){
        return this.numero;
    }
    
    
     public static int getNbEtage(){
    	 return NB_ETAGES;
     }
    public static Etage rechercherEtageParNumero(int numEtage){
        return lesEtages[numEtage];
    }
}
