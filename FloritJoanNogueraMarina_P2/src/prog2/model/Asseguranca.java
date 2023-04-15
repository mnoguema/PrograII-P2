/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;

/**
 *
 * @author Marina
 */
public class Asseguranca implements Serializable {

    private String tipus;
    private float preu;

    public Asseguranca(float preu) {
        this.preu = preu;
    }

    public Asseguranca(String tipus, float preu) {
        this.tipus = tipus;
        this.preu = preu;
    }

    /**
     * Setter del tipus d'assegurança.
     *
     * @return String amb el nom de l'assegurança.
     */
    public String getTipus() {
        return tipus;
    }

    /**
     * Setter del tipus d'assegurança.
     *
     * @param tipus Tipus d'assegurança que es vol establir.
     */
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    /**
     * Getter del preu de l'assegurança.
     *
     * @return float el preu de l'assegurança.
     */
    public float getPreu() {
        return preu;
    }

    /**
     * Setter del preu de l'assegurança.
     *
     * @param preu Preu de l'assegurança que es vol establir.
     */
    public void setPreu(float preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return " Assegurança del soci estàndard: Tipus=" + getTipus() + ", Preu Assegurança=" + getPreu() + "\n";
    }

}
