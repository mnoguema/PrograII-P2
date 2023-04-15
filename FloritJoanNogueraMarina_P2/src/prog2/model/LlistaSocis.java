/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;
import prog2.vista.ExcepcioClub;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author joanf
 */
public class LlistaSocis implements InSociList, Serializable {

    private ArrayList<Soci> llista = new ArrayList<>();
    private int capacitat;

    public LlistaSocis(int capacitat) {
        this.capacitat = capacitat;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    @Override
    public int getSize() {
        return llista.size();
    }

    @Override
    public void addSoci(Soci soci) throws ExcepcioClub {
        if (!isFull()) {
            llista.add(soci);
        } else {
            throw new ExcepcioClub("La llista esta plena");
        }
    }

    @Override
    public boolean contains(Soci soci) throws ExcepcioClub {
        Iterator<Soci> it = llista.iterator();
        while (it.hasNext()) {
            if (it.next().equals(soci)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void removeSoci(Soci soci) throws ExcepcioClub {
        llista.remove(soci);
    }

    @Override
    public Soci getAt(int position) throws ExcepcioClub {
        Soci soci;
        if (getSize() < position) {
            throw new ExcepcioClub("Aquesta posicio esta fora de la llista");
        } else {
            soci = llista.get(position);
        }

        return soci;
    }

    @Override
    public Soci getSoci(String dni) throws ExcepcioClub {
        Iterator<Soci> it = llista.iterator();
        boolean trobat = false;
        Soci soci = null;
        while (it.hasNext() && !trobat) {
            soci = it.next();
            if (soci.getDNI().equals(dni)) {
                trobat = true;
            }
        }
        if (!trobat) {
            throw new ExcepcioClub("Aquest DNI no pertany a cap soci");
        }
        return soci;
    }

    @Override
    public LlistaSocis getSubllistaSocisByType(String type) throws ExcepcioClub {
        LlistaSocis subLlista = new LlistaSocis(llista.size());
        Iterator<Soci> it = llista.iterator();
        Soci soci;
        while (it.hasNext()) {
            soci = it.next();
            if (type.equals("Tots")) {
                subLlista.addSoci(soci);
            } else if (soci.tipusSoci().equals(type)) {
                subLlista.addSoci(soci);
            }
        }

        return subLlista;
    }

    @Override
    public void clear() throws ExcepcioClub {
        llista.clear();
    }

    @Override
    public boolean isEmpty() throws ExcepcioClub {
        return getSize() == 0;
    }

    @Override
    public boolean isFull() throws ExcepcioClub {
        return getSize() == capacitat;
    }

    @Override
    public void verificarSocis() throws ExcepcioClub {
        Iterator<Soci> it = llista.iterator();
        while (it.hasNext()) {
            it.next().verifica();
        }
    }

    @Override
    public String toString() {
        String frase;
        Iterator<Soci> it = llista.iterator();

        frase = "Llista de socis: \n ==========\n ";
        int i = 1;
        while (it.hasNext()) {
            frase += "[" + i + "] " + it.next().toString();
            i++;
        }
        return frase;
    }

    public void canviAsseguranca(Soci soci, String tipus) {
        SociEstandard sociestandard = (SociEstandard) soci;
        sociestandard.setAsseguranca(tipus);
    }

    public void crearSoci(int tipusSoci, String nom, String dni, float descompte, String tipus, float preu, int edat) throws ExcepcioClub {
        Soci soci = null;
        switch (tipusSoci) {
            case 1:
                soci = new SociVip(nom, dni, descompte);
                break;
            case 2:
                soci = new SociEstandard(nom, dni, tipus, preu);
                break;
            case 3:
                soci = new SociJunior(nom, dni, tipus, preu, edat);
                break;
        }
        addSoci(soci);
    }

}
