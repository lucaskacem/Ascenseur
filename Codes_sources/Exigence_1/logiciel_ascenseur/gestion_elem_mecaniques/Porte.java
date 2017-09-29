package logiciel_ascenseur.gestion_elem_mecaniques;

import logiciel_ascenseur.gestion_elem_composites.Etage;
import logiciel_ascenseur.gestion_elem_composites.Cabine;

public class Porte {

    private int numero;
    private Etage lEtage;
    private Cabine laCabine;
    private EEtatOuv etatOuverture;

    private final static int NB_PORTES = 5;
    private static Porte[] lesPortes = new Porte[NB_PORTES];

    //Initialisation
    public Porte(int numPorte) {
        lesPortes[numPorte] = this;
        this.numero = numPorte;
        this.lEtage = null;
        this.laCabine = null;
        this.etatOuverture = EEtatOuv.FERMEE;
    }
    
    public void enregistrerEtage(Etage lEtage){
        this.lEtage = lEtage;
    }
    
     public void enregistrerCabine(Cabine laCabine){
        this.laCabine = laCabine;
    }

    public void requeteFermer() {
        //Appel du driver
        System.out.println("appel de la méthode requeteFermer du driver pour la porte numero: " + this.numero);
        this.etatOuverture = EEtatOuv.FERMEE;
    }

    public void requeteOuvrir() {
        //Appel du driver
        System.out.println("appel de la méthode requeteOuvrir du driver pour la porte numero: " + this.numero);
        this.etatOuverture = EEtatOuv.OUVERT;
    }

    public EEtatOuv getEtatOuv() {
        return this.etatOuverture;
    }
}
