package logiciel_ascenseur.gestion_elem_composites;

import logiciel_ascenseur.gestion_elem_mecaniques.Porte;
import logiciel_ascenseur.gestion_elem_mecaniques.EEtatDep;
import logiciel_ascenseur.gestion_elem_mecaniques.EEtatOuv;
import logiciel_ascenseur.gestion_elem_mecaniques.Entrainement;
import logiciel_ascenseur.gestion_services.GestionServices;

public class Cabine {

    private int numero;
    private Etage lEtageCourant;
    private Entrainement lEntrainement;
    private Porte laPorteCabine;
    private String directionCabine;

    private final static int NB_CABINES = 1;
    private static Cabine[] lesCabines = new Cabine[NB_CABINES];

    //Initialisation
    public Cabine(int numCabine, Entrainement lEntrainement, Porte laPorteCabine, Etage lEtageCourant) {
        lesCabines[numCabine] = this;
        this.numero = numCabine;
        this.lEntrainement = lEntrainement;
        this.laPorteCabine = laPorteCabine;
        this.lEtageCourant = lEtageCourant;
        this.lEntrainement.enregistrerCabine(this);
        this.laPorteCabine.enregistrerCabine(this);   
    }

    public void notificationNouvelEtage(int numEtage) {
        Etage leNouvelEtage = Etage.rechercherEtageParNumero(numEtage);
        this.lEtageCourant = leNouvelEtage;
        GestionServices.notificationArriveeCabine(this, leNouvelEtage);
    }

    public void requeteDesservirEtage() {
        this.lEntrainement.requeteArreter();
        this.laPorteCabine.requeteOuvrir();
        this.lEtageCourant.requeteDesservir();
    }

    public void requeteDeplacerVers(Etage lEtageDepl) {
        int numEtageCourant = lEtageCourant.getNumEtage();
        int numEtageDepl = lEtageDepl.getNumEtage();
        if (numEtageCourant < numEtageDepl) {
            this.lEntrainement.requeteMonter();
        } else if (numEtageCourant > numEtageDepl) {
            this.lEntrainement.requeteDescendre();
        } else {
            this.laPorteCabine.requeteOuvrir();
        }
    }
    
     public static Cabine RequeteObtenirCabineDisponible() {
        if (lesCabines[0].getEtatCabine() == EEtatCabine.ARRETE_FERME) {
            return lesCabines[0];
        } else {
            return null;
        }
    }

    public int getNumEtageCourant() {
        return this.lEtageCourant.getNumEtage();
    }

    public EEtatCabine getEtatCabine() {
        EEtatCabine etatCabine;
        EEtatOuv etatOuv = this.laPorteCabine.getEtatOuv();
        EEtatDep etatDepl = this.lEntrainement.getEtatDeplacement();
        if (etatDepl == EEtatDep.ENDESCENTE) {
            etatCabine = EEtatCabine.ENDESCENTE_FERME;
            directionCabine="DOWN";
        } else if (etatDepl == EEtatDep.ENMONTEE) {
            etatCabine = EEtatCabine.ENMONTEE_FERME;
            directionCabine="UP";
        } else if (etatDepl == EEtatDep.ARRETE) {
            if (etatOuv == EEtatOuv.OUVERT) {
                etatCabine = EEtatCabine.ARRETE_OUVERT;
            } else {
                etatCabine = EEtatCabine.ARRETE_FERME;
            }
        } else 
        {
            etatCabine = EEtatCabine.ARRETE_FERME;
        }
        return etatCabine;
    }
    
    public String getDirection(){
    	return directionCabine;
    }

}
