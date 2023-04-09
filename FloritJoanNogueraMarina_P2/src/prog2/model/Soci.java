/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import prog2.vista.ExcepcioClub;

/**
 *
 * @author Marina
 */
public abstract class Soci {
    protected String nom, dni, tipus;
    protected float quota;
    protected LlistaActivitats llista;
    
    public Soci(String nom, String dni, String tipus, float quota){
        this.nom = nom;
        this.dni = dni;
        this.tipus = tipus;
        this.quota = quota;
        this.llista = new LlistaActivitats();
    }
    
    // Setters i getters:
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return nom;
    }
    public void setDNI(String dni){
        this.dni = dni;
    }
    public String getDNI(){
        return dni;
    }  
    public void setQuotaBase(float quotaBase){
        this.quota = quotaBase;
    }
    public float getQuotaBase(){
        return quota;
    }
    public LlistaActivitats getActivitatsRealitzades(){
        return llista;
    }
    
    
    /**
     * Afegir una activitat realitzada pel soci a la llista d'activitats realitzades.
     * @param activitat que s'afegirà a la llista d'activitats realitzades pel soci.
     */
    public void afegirActivitatRealitzada(Activitat activitat){
        try {
            llista.addActivitat(activitat);
        } catch (ExcepcioClub ex) {
            ex.toString();
        }
    }
   
    
    /**
     * Calcular el preu de les activitats realitzades pel soci
     * @return float amb el preu de totes les activitats realitzades per aquest soci.
     */
    public float calculaPreuActivitats(){
        float preu=0;
        try {
            preu = llista.calculaPreuActivitats();
        } catch (ExcepcioClub ex) {
            ex.toString();
        }
        return preu;
    }
    
      
    /**
     * Calcular l'import de la factura mensual del soci 
     * @return float amb el valor de la factura del soci.
     */
    abstract public float calcularFactura();

         
    /**
     * Verificar si les dades del soci són correctes o no
     * @throws ExcepcioClub. Si hi ha algún error en les dades es llança una excepció 
     */ 
    abstract public void verifica() throws ExcepcioClub;

    public String toString(){
        return "Nom="+getNom()+", DNI="+getDNI()+". "+tipusSoci()+"\n";
    }
    
    abstract public String tipusSoci();
    
    public boolean equals(Soci soci){
        boolean same = (this.getDNI().equals(soci.getDNI())) ? true : false ;
        return same;
    }
}
