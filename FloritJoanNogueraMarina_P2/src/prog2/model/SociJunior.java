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
public class SociJunior extends SociEstandard {
    private int edat;
    public SociJunior(String nom, String dni, int edat){
        super(nom, dni);
        this.edat = edat;
    }
    
    @Override
    public void verifica() throws ExcepcioClub{
        if(edat>18){
            throw new ExcepcioClub("L'edat del soci junior no es correcta.\n");
        }  
    }
    
    
    @Override
    public float calcularFactura() {
        return quota + asseguranca.getPreu();
    }

}
