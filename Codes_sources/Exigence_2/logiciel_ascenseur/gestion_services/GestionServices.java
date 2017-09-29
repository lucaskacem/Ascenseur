package logiciel_ascenseur.gestion_services;

import logiciel_ascenseur.gestion_elem_composites.Cabine;
import logiciel_ascenseur.gestion_elem_composites.Etage; 

public abstract class GestionServices {
    static class Service { 
        public Cabine laCabineServant;
        public Etage lEtageServi;
        public ETypeService type;
        public String direction;
       
    }

    private final static int NB_MAX_SERVICES = Etage.getNbEtage();
    private static Service[] lesServices = new Service[NB_MAX_SERVICES];
    public static Service dernierService=new Service();
    
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
    	
    		for(int i=0;i<lesServices.length;i++){
    			if(lesServices[i]!=null){
    				if(lesServices[i].direction== laCabine.getDirection() || lesServices[i].direction == laCabine.getDirection()){
    					//if(lesServices[i].lEtageServi == lEtage && lesServices[i].laCabineServant==laCabine){
    					laCabine.requeteDesservirEtage();
    					detruireService();
    					//}
    				}
    			}
    		}
    
    }

    private static void memoriserAppel(Cabine laCabine,Etage lEtage, ETypeService leType, String uneDirection) {
    	
    	int etage=lEtage.getNumEtage();
    	lesServices[etage]=new Service();
    	lesServices[etage].laCabineServant = laCabine;
        lesServices[etage].lEtageServi = lEtage;
        lesServices[etage].type = leType;
        lesServices[etage].direction=uneDirection;
   
    	
    }

    private static void detruireService() {
        lesServices[0] = null; 
    }
    

}
