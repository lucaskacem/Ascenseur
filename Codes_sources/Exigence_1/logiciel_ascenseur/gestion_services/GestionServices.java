package logiciel_ascenseur.gestion_services;

import logiciel_ascenseur.gestion_elem_composites.Cabine;
import logiciel_ascenseur.gestion_elem_composites.Etage; 

public abstract class GestionServices {
    static class Service { 
        public Cabine laCabineServant;
        public Etage lEtageServi;
        public ETypeService type;
        public String direction;
        
        //public Direction direction;
    }

    private final static int NB_MAX_SERVICES = Etage.getNbEtage();
    private static Service[] lesServices = new Service[NB_MAX_SERVICES];
    public static Service dernierService=new Service();
    public static boolean monte=true;
    
    public static void notificationAppel(Etage lEtage, String direction) {
        //...
        Cabine laCabine = Cabine.RequeteObtenirCabineDisponible();
        if (laCabine != null) {
            memoriserAppel(laCabine,lEtage, ETypeService.APPEL, direction);
            laCabine.requeteDeplacerVers(lEtage);
        }
        //...
    }
    
    public static void notificationArriveeCabine(Cabine laCabine,Etage lEtage) {
        /* Verifier s'il existe un service pour cet Ã©tage. 
         Dans cette version, il n'y a qu'un seul service au maximum.
         On ne verifie donc que la premiere entree de la liste */
    	
    	int serviceActifLePlusHaut=0;
    	int serviceActifLePlusBas=0;
    	
    	//DEFINITION DE LA DIRECTION 
    	for(int i=lesServices.length;i<0;i--){
    		if(lesServices[i]!=null){
    			serviceActifLePlusHaut=i;
    			break;
    		}
    	}
    	
    	for(int i=0;i<lesServices.length;i++){
    		if(lesServices[i]!=null){
    			serviceActifLePlusBas=i;
    			break;
    		}
    	}
    	
    	if(lEtage.getNumEtage()==serviceActifLePlusHaut){
    		monte=false;
    	}else{
    		if(lEtage.getNumEtage()==serviceActifLePlusBas){
    			monte=true;
    		}
    	}
    	
    	if(monte==true){
    		for(int i=lEtage.getNumEtage();i<lesServices.length;i++){
    				//je pars depuis l'étage où se situe ma cabine et execute tous les services au dessus
    			if(lesServices[i]!=null){
    				if (lesServices[i].lEtageServi == lEtage && lesServices[i].laCabineServant==laCabine){
    				 laCabine.requeteDesservirEtage();
    		         detruireService();
    				}
    			}
    		}
    	}else{
    		for(int i=lEtage.getNumEtage();i<0;i--){
    			if(lesServices[i]!=null){
				//je pars depuis l'étage où se situe ma cabine et execute tous les services au dessus
					if (lesServices[i].lEtageServi == lEtage && lesServices[i].laCabineServant==laCabine){
						 laCabine.requeteDesservirEtage();
				         detruireService();
					}
    			}
    		}
    	}
    }

    private static void memoriserAppel(Cabine laCabine,Etage lEtage, ETypeService leType, String direction) {
    	
    	int etage=lEtage.getNumEtage();
    	
    	lesServices[etage]=new Service();
    	lesServices[etage].laCabineServant = laCabine;
        lesServices[etage].lEtageServi = lEtage;
        lesServices[etage].type = leType;
        lesServices[etage].direction=direction;
    	
    	/*if (lesServices[0] == null) {
            lesServices[0] = new Service();
            lesServices[0].laCabineServant = laCabine;
            lesServices[0].lEtageServi = lEtage;
            lesServices[0].type = leType;
            dernierService=lesServices[0];
    	} else {
    		  Service s=new Service();
              s.laCabineServant = laCabine;
              s.lEtageServi = lEtage;
              s.type = leType;
              if(dernierService.lEtageServi.getNumEtage()<s.lEtageServi.getNumEtage() 
            		  &&  monte==true || dernierService.lEtageServi.getNumEtage()>s.lEtageServi.getNumEtage() && monte==false){
            	 for(int i=0;i<lesServices.length;i++){
            	  if(lesServices[i]==null){
	            	  lesServices[i] = new Service();
	                  lesServices[i].laCabineServant = laCabine;
	                  lesServices[i].lEtageServi = lEtage;
	                  lesServices[i].type = leType;
            	  }
            	 }
              }else{
            	  
              }
    	}*/
    	
    }

    private static void detruireService() {
        lesServices[0] = null; 
       /* for (int i=1;i<lesServices.length;i++) {
            if(lesServices[i]!=null) {
                lesServices[i] = lesServices[i - 1];
            }
            dernierService=lesServices[0];
        }*/
    }
    

}
