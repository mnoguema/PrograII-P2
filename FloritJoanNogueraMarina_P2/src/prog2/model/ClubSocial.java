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
public class ClubSocial implements Serializable {
    private static final float quotaEstandard = 25;
    private static final float quotaVIP = 50;
    private static final float descompteVIP = 20;
    private LlistaActivitats llistaActivitats;
    private LlistaSocis llistaSocis;
    
    /* mida maxima per defecte */
    public ClubSocial(){
        llistaSocis = new LlistaSocis(100);
    }
    
    public ClubSocial(int capacitat){
        llistaSocis = new LlistaSocis(capacitat);
    }
    
    public String MostrarLlistaSocis(String tipus){
        List<String> tipusSoci = Arrays.asList("VIP", "Estandard", "Junior");
        Soci soci;
        Iterator<Soci> it = llistaSocis.iterator();
        String frase = "";
        
        while(it.hasNext()){
            if(tipusSoci.contains(tipus)){
                frase += llistaSocis.
            }
            soci = it.next();
            
        }
    }
    
    
    public String MostrarActivitats(){
        return llistaActivitats.toString();
    }
    
    

}
