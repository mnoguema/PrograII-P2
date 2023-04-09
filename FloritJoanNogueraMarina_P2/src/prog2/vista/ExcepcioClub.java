/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.vista;

/**
 *
 * @author Marina
 */
public class ExcepcioClub extends Exception{
    /**
     * Constructor sense paràmetres.
     */
    public ExcepcioClub() {
        super();
    }

    /**
     * Constructor amb paràmetre.
     *
     * @param s Missatge.
     */
    public ExcepcioClub(String s) {
        super(s);
    }

    /**
     * Imprimeix el missatge d'error.
     *
     * @return String amb el missatge d'error.
     */
    public String toString() {
        return super.getMessage();
    }
    
}
