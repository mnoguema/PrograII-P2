/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;
import prog2.vista.ExcepcioClub;

/**
 *
 * @author Marina
 */
public abstract class Soci implements Serializable, InSoci {

    protected String nom, dni;
    protected float quota;
    protected LlistaActivitats llista;

    public Soci(String nom, String dni, float quota) {
        this.nom = nom;
        this.dni = dni;
        this.quota = quota;
        this.llista = new LlistaActivitats();
    }

    // Setters i getters:
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setDNI(String dni) {
        this.dni = dni;
    }

    @Override
    public String getDNI() {
        return dni;
    }

    @Override
    public void setQuotaBase(float quotaBase) {
        this.quota = quotaBase;
    }

    @Override
    public float getQuotaBase() {
        return quota;
    }

    @Override
    public LlistaActivitats getActivitatsRealitzades() {
        return llista;
    }

    /**
     * Afegir una activitat realitzada pel soci a la llista d'activitats
     * realitzades.
     *
     * @param activitat que s'afegirà a la llista d'activitats realitzades pel
     * soci.
     */
    @Override
    public void afegirActivitatRealitzada(Activitat activitat) {
        try {
            llista.addActivitat(activitat);
        } catch (ExcepcioClub ex) {
            ex.toString();
        }
    }

    /**
     * Calcular el preu de les activitats realitzades pel soci
     *
     * @return float amb el preu de totes les activitats realitzades per aquest
     * soci.
     */
    @Override
    public float calculaPreuActivitats() {
        float preu = 0;
        try {
            preu = llista.calculaPreuActivitats();
        } catch (ExcepcioClub ex) {
            ex.toString();
        }
        return preu;
    }

    /**
     * Calcular l'import de la factura mensual del soci
     *
     * @return float amb el valor de la factura del soci.
     */
    @Override
    abstract public float calcularFactura();

    /**
     * Verificar si les dades del soci són correctes o no
     *
     * @throws prog2.vista.ExcepcioClub
     * @throws ExcepcioClub. Si hi ha algún error en les dades es llança una
     * excepció
     */
    @Override
    abstract public void verifica() throws ExcepcioClub;

    @Override
    public String toString() {
        return "Nom=" + getNom() + ", DNI=" + getDNI() + ". " + tipusSoci() + "\n";
    }

    abstract public String tipusSoci();

    public boolean equals(Soci soci) {
        return this.getDNI().equals(soci.getDNI());
    }
}
