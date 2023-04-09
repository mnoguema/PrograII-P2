package prog2.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import prog2.vista.ExcepcioClub;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marina
 */
public class SociVip extends Soci{
    private float descompte;

    public SociVip(String nom, String dni, float descompte){
        super(nom, dni, "VIP",  50);
        this.descompte = descompte; 
    }
    
    public void verifica() throws ExcepcioClub{
        if(descompte>50){
            throw new ExcepcioClub("El descompte del preu d'activitats no és correcte\n");
        }  
    }
    
    @Override
    public float calcularFactura(){
        float preu = 0;
        try {
            preu = quota + llista.calculaPreuActivitats()*(1- descompte/100);
        } catch (ExcepcioClub ex) {
            ex.toString();
        }
        return preu;
    }

    @Override
    public String tipusSoci() {
        return "VIP";
    }
}
