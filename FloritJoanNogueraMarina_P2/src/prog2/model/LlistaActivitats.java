package prog2.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import prog2.vista.ExcepcioClub;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Marina
 */
public class LlistaActivitats implements InActivitatList, Serializable {

    private ArrayList<Activitat> llista = new ArrayList<>();

    /**
     * Donar el número d'elements que hi ha actualment emmagatzemants a la
     * llista.
     *
     * @return int amb el número d'elements de la llista.
     */
    @Override
    public int getSize() {
        return llista.size();
    }

    /**
     * Afegir una nova activitat
     *
     * @param activitat objecte per afegir a la llista.
     * @throws prog2.vista.ExcepcioClub
     */
    @Override
    public void addActivitat(Activitat activitat) throws ExcepcioClub {
        llista.add(activitat);
    }

    /**
     * Eliminar un objecte de la llista
     *
     * @param activitat objecte per eliminar.
     * @throws prog2.vista.ExcepcioClub
     */
    @Override
    public void removeActivitat(Activitat activitat) throws ExcepcioClub {
        llista.remove(activitat);
    }

    /**
     * Obtenir l'activitat guardada a una certa posició donada
     *
     * @param position posició a la llista d'activitats.
     * @return objecte activitat a la posició donada o null si no existeix.
     * @throws prog2.vista.ExcepcioClub
     */
    @Override
    public Activitat getAt(int position) throws ExcepcioClub {
        Activitat activitat;
        if (getSize() < position) {
            throw new ExcepcioClub("Aquesta posicio esta fora de la llista");
        } else {
            activitat = llista.get(position);
        }
        return activitat;
    }

    /**
     * Eliminar tots els elements de la llista
     *
     * @throws prog2.vista.ExcepcioClub
     */
    @Override
    public void clear() throws ExcepcioClub {
        llista.clear();
    }

    /**
     * Comprovar si la llista està buida o no.
     *
     * @return True si la llista està buida (no hi ha cap elements) o false
     * sinó.
     * @throws prog2.vista.ExcepcioClub
     */
    @Override
    public boolean isEmpty() throws ExcepcioClub {
        return getSize() == 0;
    }

    /**
     * Calcular el preu de totes les activitats de la llist.
     *
     * @return float amb el valor del preu.
     * @throws prog2.vista.ExcepcioClub
     */
    @Override
    public float calculaPreuActivitats() throws ExcepcioClub {
        Iterator<Activitat> it = llista.iterator();
        float preu = 0;

        while (it.hasNext()) {
            preu += it.next().getPreu();
        }
        return preu;
    }

    /**
     *
     * @return resum de la llista d'activitats
     */
    @Override
    public String toString() {
        String frase;
        Iterator<Activitat> it = llista.iterator();

        frase = "Llista d'activitats: \n ==========\n ";
        int i = 1;
        while (it.hasNext()) {
            frase += "[" + i + "] " + it.next().toString();
            i++;
        }
        return frase;
    }

    /**
     * Carregar la llista d'activitats.Llegeix linies d'un fitxer de text pla,
     * on cada linia representa una activitat amb un nom realitzada un dia, en
     * un interval horari i amb un preu determinat.
     *
     * @param filepath Ruta del fitxer des d'on carregar les activitats
     * @return LlistaActivitats que crea amb la informació del txt.
     * @throws prog2.vista.ExcepcioClub
     */
    @Override
    public LlistaActivitats carregaLlistaActivitats(String filepath) throws ExcepcioClub {
        LlistaActivitats llistaActivitats = new LlistaActivitats();

        String line;
        try ( BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            while ((line = br.readLine()) != null) {
                // Llegeix la línia del fitxer
                String[] data = line.split(",");

                // Cada activitat té 3 atributs que llegim: nom, dia de la setmana, hora
                float preu = Float.parseFloat(data[3]);
                Activitat activitat = new Activitat(data[0], data[1], data[2], preu);
                llistaActivitats.addActivitat(activitat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return llistaActivitats;
    }
}
