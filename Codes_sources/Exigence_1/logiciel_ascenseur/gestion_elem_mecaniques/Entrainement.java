package logiciel_ascenseur.gestion_elem_mecaniques;

import logiciel_ascenseur.gestion_elem_composites.Cabine;

public class Entrainement {

    private int numero;
    private Cabine laCabine;
    private EEtatDep etatDeplacement;


    private final static int NB_ENTRAINEMENTS = 1;
    private static Entrainement[] lesEntrainements = new Entrainement[NB_ENTRAINEMENTS];

    //Initialisation
    public Entrainement(int numEntrainement) {
        lesEntrainements[numEntrainement] = this;
        this.numero = numEntrainement;
        this.laCabine = null;
        this.etatDeplacement = EEtatDep.ARRETE;
    }
    
    public void enregistrerCabine(Cabine laCabine){
        this.laCabine = laCabine;
    }

    public void notificationNouvelEtage(int numEtage) {
        this.laCabine.notificationNouvelEtage(numEtage);
    }

    public void requeteArreter() {
        //Appeler le driver de l'entrainement ...
        System.out.println("appel de la méthode requeteArreter du driver pour l'entrainement numero: " + this.numero);
        this.etatDeplacement = EEtatDep.ARRETE;
    }

    public void requeteDescendre() {
        //Appeler le driver de l'entrainement ...
        System.out.println("appel de la méthode requeteDescendre du driver pour l'entrainement numero: " + this.numero);
        this.etatDeplacement = EEtatDep.ENDESCENTE;
     
    }

    public void requeteMonter() {
        System.out.println("appel de la mÃ©thode requeteMonter du driver pour l'entrainement numero: " + this.numero);
        this.etatDeplacement = EEtatDep.ENMONTEE;
     
    }

    public EEtatDep getEtatDeplacement() {
        return this.etatDeplacement;
    }
  
}
