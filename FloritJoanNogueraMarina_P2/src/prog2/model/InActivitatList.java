/*
 * Universitat de Barcelona
 * Programació 2
 */
package prog2.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import prog2.vista.ExcepcioClub;

/**
 * Interfície InActivitatList
 *
 * @author lauraigual
 */
public interface InActivitatList {

    /**
     * Donar el número d'elements que hi ha actualment emmagatzemants a la
     * llista.
     *
     * @return int amb el número d'elements de la llista.
     */
    public int getSize();

    /**
     * Afegir una nova activitat
     *
     * @param activitat objecte per afegir a la llista.
     * @throws prog2.vista.ExcepcioClub
     */
    public void addActivitat(Activitat activitat) throws ExcepcioClub;

    /**
     * Eliminar un objecte de la llista
     *
     * @param activitat objecte per eliminar.
     * @throws prog2.vista.ExcepcioClub
     */
    public void removeActivitat(Activitat activitat) throws ExcepcioClub;

    /**
     * Obtenir l'activitat guardada a una certa posició donada
     *
     * @param position posició a la llista d'activitats.
     * @return objecte activitat a la posició donada o null si no existeix.
     * @throws prog2.vista.ExcepcioClub
     */
    public Activitat getAt(int position) throws ExcepcioClub;

    /**
     * Eliminar tots els elements de la llista
     *
     * @throws prog2.vista.ExcepcioClub
     */
    public void clear() throws ExcepcioClub;

    /**
     * Comprovar si la llista està buida o no.
     *
     * @return True si la llista està buida (no hi ha cap elements) o false
     * sinó.
     * @throws prog2.vista.ExcepcioClub
     */
    public boolean isEmpty() throws ExcepcioClub;

    /**
     * Calcular el preu de totes les activitats de la llist.
     *
     * @return float amb el valor del preu.
     * @throws prog2.vista.ExcepcioClub
     */
    public float calculaPreuActivitats() throws ExcepcioClub;

    /**
     * Carregar la llista d'activitats.Llegeix linies d'un fitxer de text pla,
     * on cada linia representa una activitat amb un nom realitzada un dia, en
     * un interval horari i amb un preu determinat.
     *
     * @param filepath Ruta del fitxer des d'on carregar les activitats
     * @return LlistaActivitats que crea amb la informació del txt.
     * @throws prog2.vista.ExcepcioClub
     */
    public LlistaActivitats carregaLlistaActivitats(String filepath) throws ExcepcioClub;
}
