/*
 * Universitat de Barcelona
 * Programació 2
 */

package prog2.model;

import prog2.model.Activitat;
import prog2.vista.ExcepcioClub;

/**
 * Interfície InSoci
 * @author lauraigual
 */
public interface InSoci {
    
    // Setters i getters:
    public void setNom(String nom);
    public String getNom();
    public void setDNI(String dni);
    public String getDNI();  
    public void setQuotaBase(float quotaBase);
    public float getQuotaBase();
    public LlistaActivitats getActivitatsRealitzades();
    
    
    /**
     * Afegir una activitat realitzada pel soci a la llista d'activitats realitzades.
     * @param activitat que s'afegirà a la llista d'activitats realitzades pel soci.
     */
    public void afegirActivitatRealitzada(Activitat activitat);
   
    
    /**
     * Calcular el preu de les activitats realitzades pel soci
     * @return float amb el preu de totes les activitats realitzades per aquest soci.
     */
    public float calculaPreuActivitats();
    
      
    /**
     * Calcular l'import de la factura mensual del soci 
     * @return float amb el valor de la factura del soci.
     */
    public float calcularFactura();

         
    /**
     * Verificar si les dades del soci són correctes o no
     * @throws ExcepcioClub. Si hi ha algún error en les dades es llança una excepció 
     */ 
    public void verifica() throws ExcepcioClub;

}
