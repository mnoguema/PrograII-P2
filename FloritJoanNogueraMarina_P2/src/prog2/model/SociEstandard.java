/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import prog2.vista.ExcepcioClub;

/**
 *
 * @author Marina
 */
public class SociEstandard extends Soci {

    protected Asseguranca asseguranca;

    public SociEstandard(String nom, String dni, String tipus, float preu) {
        super(nom, dni, 25);
        asseguranca = new Asseguranca(tipus, preu);
    }

    public Asseguranca getAsseguranca() {
        return asseguranca;
    }

    public void setAsseguranca(String tipus) {
        asseguranca.setTipus(tipus);
    }

    @Override
    public void verifica() throws ExcepcioClub {
        if (!asseguranca.getTipus().toUpperCase().equals("BASICA") && !asseguranca.getTipus().toUpperCase().equals("COMPLETA")) {
            throw new ExcepcioClub("El tipus d'assegurança pel soci amb DNI " + this.dni + " no es correcte\n");
        }
    }

    @Override
    public float calcularFactura() {
        float preu = 0;
        try {
            preu = quota + llista.calculaPreuActivitats() + asseguranca.getPreu();
        } catch (ExcepcioClub ex) {
            ex.toString();
        }
        return preu;
    }

    @Override
    public String tipusSoci() {
        return "Estandard";
    }

    @Override
    public String toString() {
        return "Nom=" + getNom() + ", DNI=" + getDNI() + ". Assegurança del soci " + tipusSoci() + ": Tipus=" + asseguranca.getTipus()
                + ", Preu Assegurança=" + asseguranca.getPreu() + "\n";
    }

}
