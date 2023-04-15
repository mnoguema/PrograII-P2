/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.*;
import prog2.vista.ExcepcioClub;

/**
 *
 * @author Marina
 */
public class ClubSocial implements Serializable {

    private static final float quotaEstandard = 25;
    private static final float quotaVIP = 50;
    private static final float descompteVIP = 20;
    private LlistaActivitats llistaActivitats;
    private LlistaSocis llistaSocis;

    public ClubSocial(int capacitat) throws ExcepcioClub {
        llistaActivitats = new LlistaActivitats();
        llistaSocis = new LlistaSocis(capacitat);
        llistaActivitats = llistaActivitats.carregaLlistaActivitats("llistaActivitats.txt");
    }

    public ClubSocial() throws ExcepcioClub {
        llistaActivitats = new LlistaActivitats();
        llistaSocis = new LlistaSocis(100);
        llistaActivitats = llistaActivitats.carregaLlistaActivitats("llistaActivitats.txt");
    }

    public String mostrarSocisMenu(String tipus) throws ExcepcioClub {
        LlistaSocis subllista = llistaSocis.getSubllistaSocisByType(tipus);
        if (!subllista.isEmpty()) {
            return subllista.toString();
        } else {
            return "No hi ha socis " + tipus;
        }
    }

    public void eliminarSociMenu(String dni) throws ExcepcioClub {
        llistaSocis.removeSoci(llistaSocis.getSoci(dni));
    }

    public void verificarSocisMenu() throws ExcepcioClub {
        llistaSocis.verificarSocis();
    }

    public String mostrarActivitats() {
        return llistaActivitats.toString();
    }

    public String mostrarActivitatsSoci(String dni) throws ExcepcioClub {
        return llistaSocis.getSoci(dni).getActivitatsRealitzades().toString();
    }

    public void afegirActivitatMenu(String dni, int activitat) throws ExcepcioClub {
        llistaSocis.getSoci(dni).afegirActivitatRealitzada(llistaActivitats.getAt(activitat));
    }

    public float calcularFacturaMenu(String dni) throws ExcepcioClub {
        return llistaSocis.getSoci(dni).calcularFactura();
    }

    public void canviarNomSociMenu(String dni, String nom) throws ExcepcioClub {
        llistaSocis.getSoci(dni).setNom(nom);
    }

    public void canviarAsseguranca(String dni, String tipus) throws ExcepcioClub {
        Soci s = llistaSocis.getSoci(dni);
        if (s.tipusSoci().equals("Estandard")) {
            llistaSocis.canviAsseguranca(s, tipus);
        }
    }

    public void guarda(String fileName) throws ExcepcioClub, FileNotFoundException, IOException {
        File fitxer = new File(fileName);
        try {
            FileOutputStream fout = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            oos.close();
            fout.close();
        } catch (FileNotFoundException ex) {
            throw new ExcepcioClub("Fitxer no trobat");
        } catch (IOException ex) {
            throw new ExcepcioClub("IO error");
        }
    }

    public static ClubSocial recupera(String fileName) throws ExcepcioClub, FileNotFoundException, IOException {
        if (fileName == null) {
            throw new ExcepcioClub("Cami al fitxer no valid");
        }
        File fitxer = new File(fileName);
        ClubSocial club = null;
        FileInputStream fin = null;

        try {
            fin = new FileInputStream(fitxer);
            ObjectInputStream ois = new ObjectInputStream(fin);
            club = (ClubSocial) ois.readObject();
        } catch (ClassNotFoundException ex) {
            throw new ExcepcioClub("Error, no trobat");
        } catch (FileNotFoundException ex) {
            throw new ExcepcioClub("Error de fitxer");
        } catch (IOException ex) {
            throw new ExcepcioClub("Error de IO");
        } finally {
            if (fin == null) {
                throw new ExcepcioClub("Fin = null");
            } else {
                fin.close();
            }
        }
        return club;
    }

    public void addSoci(int tipusSoci, String nom, String dni, float descompte, String tipus, float preu, int edat) throws ExcepcioClub {
        llistaSocis.crearSoci(tipusSoci, nom, dni, descompte, tipus, preu, edat);
    }
}
