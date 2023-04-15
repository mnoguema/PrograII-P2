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
public class Activitat implements InActivitat, Serializable {

    private String nom, dia, franja_horaria;
    private float preu;

    public Activitat(String nom, String dia, String franja_horaria, float preu) {
        this.nom = nom;
        this.dia = dia;
        this.franja_horaria = franja_horaria;
        this.preu = preu;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String _nom) {
        this.nom = _nom;
    }

    @Override
    public String getDiaSetmana() {
        return dia;
    }

    @Override
    public void setDiaSetmana(String diaSetmana) {
        this.dia = diaSetmana;
    }

    @Override
    public String getIntervalHorari() {
        return franja_horaria;
    }

    @Override
    public void setIntervalHorari(String intervalHorari) {
        this.franja_horaria = intervalHorari;
    }

    @Override
    public float getPreu() {
        return preu;
    }

    @Override
    public void setPreu(float _preu) {
        this.preu = _preu;
    }

    @Override
    public String toString() {
        return "Activitat: " + getNom() + ", " + getDiaSetmana() + ", "
                + getIntervalHorari() + ", " + getPreu() + "€.\n ";
    }
}
