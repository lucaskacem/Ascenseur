package test_logiciel_ascenseur;

import logiciel_ascenseur.gestion_elem_mecaniques.*;
import logiciel_ascenseur.gestion_elem_composites.*;

public class SimulateurDriver {

    public static void main(String[] args) {
	// Initialisation: Ascenseur a 4 etages, dont le RDC
        // Cabine porte fermee, arretee a l'etage 1
        
        // Creation des boutons
        // Pour chaque bouton: creerBouton(int numBouton, int numEtage)
        Bouton leBouton0Up = new Bouton(0);
        Bouton leBouton0Down = new Bouton(0);
        Bouton leBouton1Up = new Bouton(1);
        Bouton leBouton1Down = new Bouton(1);
        Bouton leBouton2Up = new Bouton(2);
        Bouton leBouton2Down = new Bouton(2);
        Bouton leBouton3Down = new Bouton(3);
        Bouton leBouton3Up=new Bouton(3);
        
        // Creation de l'entrainement: creerEntrainement(int numEntrainement, int numCabine)
        Entrainement lEntrainement0 = new Entrainement(0);
        // Creation des portes
        // Pour chaque porte: creerPorte(int numPorte, int numEtage, int numCabine)
        Porte laPorte0 = new Porte(0);
        Porte laPorte1 = new Porte(1);
        Porte laPorte2 = new Porte(2);
        Porte laPorte3 = new Porte(3);
        
        Porte laPorte4 = new Porte(4);
        // Creation des etages
        // Pour chaque etage: creerEtage(int numEtage, int numBouton, int numPorte)
        Etage lEtage0 = new Etage(0, leBouton0Up, leBouton0Down, laPorte0);
        Etage lEtage1 = new Etage(1, leBouton1Up,leBouton1Down, laPorte1);
        Etage lEtage2 = new Etage(2, leBouton2Up, leBouton2Down,laPorte2);
        Etage lEtage3 = new Etage(3, leBouton3Up,leBouton3Down, laPorte3);
        // Creation de la cabine: creerCabine(int numCabine, int numEntrainement, int numPorte, int numEtageCourant)
        Cabine laCabine0 = new Cabine(0,lEntrainement0,laPorte4,lEtage1);
        
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------SCENARIO 1----------------------------------------------------------------------");
        //Affichage état cabine - vérification pré-conditions
        System.out.println("etat de la cabine: " + laCabine0.getEtatCabine().toString());
        System.out.println("etage courant de la cabine: " + laCabine0.getNumEtageCourant());
        System.out.println("");
        
        System.out.println("appel par le driver de la méthode notificationPression(bouton2) ");
        leBouton2Down.notificationPression();
        System.out.println("");
        
        //Execution du scenario par simulation des drivers
        System.out.println("appel par le driver de la méthode notificationPression(bouton3) ");
        leBouton3Down.notificationPression();
        System.out.println("");

        System.out.println("appel par le driver de la méthode notificationPression(bouton0) ");
        leBouton0Up.notificationPression();
        System.out.println("");
        
        System.out.println("appel par le driver de la méthode notificationNouvelEtage(entrainement0,etage2) par le driver");
        lEntrainement0.notificationNouvelEtage(3);
        System.out.println("etat de la cabine: " + laCabine0.getEtatCabine().toString());
        System.out.println("etage courant de la cabine: " + laCabine0.getNumEtageCourant());
        System.out.println("");

        System.out.println("appel par le driver de la méthode notificationNouvelEtage(entrainement0,etage3) par le driver");
        lEntrainement0.notificationNouvelEtage(2);
        System.out.println("etat de la cabine: " + laCabine0.getEtatCabine().toString());
        System.out.println("etage courant de la cabine: " + laCabine0.getNumEtageCourant());
        System.out.println("");
        
        System.out.println("appel par le driver de la méthode notificationNouvelEtage(entrainement0,etage0) par le driver");
        lEntrainement0.notificationNouvelEtage(0);
        System.out.println("etat de la cabine: " + laCabine0.getEtatCabine().toString());
        System.out.println("etage courant de la cabine: " + laCabine0.getNumEtageCourant());
        System.out.println("");
        
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------SCENARIO 2----------------------------------------------------------------------");
        //Affichage état cabine - vérification pré-conditions
        System.out.println("etat de la cabine: " + laCabine0.getEtatCabine().toString());
        System.out.println("etage courant de la cabine: " + laCabine0.getNumEtageCourant());
        System.out.println("");
        
        System.out.println("appel par le driver de la méthode notificationPression(bouton2) ");
        leBouton2Down.notificationPression();
        System.out.println("");
        
        //Execution du scenario par simulation des drivers
        System.out.println("appel par le driver de la méthode notificationPression(bouton3) ");
        leBouton3Down.notificationPression();
        System.out.println("");

        System.out.println("appel par le driver de la méthode notificationPression(bouton0) ");
        leBouton0Up.notificationPression();
        System.out.println("");
        
        System.out.println("appel par le driver de la méthode notificationNouvelEtage(entrainement0,etage2) par le driver");
        lEntrainement0.notificationNouvelEtage(2);
        System.out.println("etat de la cabine: " + laCabine0.getEtatCabine().toString());
        System.out.println("etage courant de la cabine: " + laCabine0.getNumEtageCourant());
        System.out.println("");

        System.out.println("appel par le driver de la méthode notificationNouvelEtage(entrainement0,etage3) par le driver");
        lEntrainement0.notificationNouvelEtage(3);
        System.out.println("etat de la cabine: " + laCabine0.getEtatCabine().toString());
        System.out.println("etage courant de la cabine: " + laCabine0.getNumEtageCourant());
        System.out.println("");
        
        System.out.println("appel par le driver de la méthode notificationNouvelEtage(entrainement0,etage0) par le driver");
        lEntrainement0.notificationNouvelEtage(0);
        System.out.println("etat de la cabine: " + laCabine0.getEtatCabine().toString());
        System.out.println("etage courant de la cabine: " + laCabine0.getNumEtageCourant());
        System.out.println("");
    }
}
