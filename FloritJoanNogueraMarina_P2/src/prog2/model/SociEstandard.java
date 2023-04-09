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
public abstract class SociEstandard extends Soci {
    protected Asseguranca asseguranca;

    public SociEstandard(String nom, String dni){
        super(nom, dni, "Estandard", 25);
    }
    
    @Override
    public void verifica() throws ExcepcioClub{
        if(!asseguranca.getTipus().equals("Basica") && !asseguranca.getTipus().equals("Completa")){
            throw new ExcepcioClub("El tipus d'assegurança no es correcte\n");
        }  
    }

    @Override
    public float calcularFactura() {
        float preu = 0;
        try {
            preu = quota + llista.calculaPreuActivitats()+asseguranca.getPreu();
        } catch (ExcepcioClub ex) {
            ex.toString();
        }
        return preu; 
    }

    @Override
    public String tipusSoci() {
        return "Estandard";
    }
}
