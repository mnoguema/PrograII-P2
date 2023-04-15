/*
 * Universitat de Barcelona
 * Programació 2
 * Curs 2022-2023
 */
package prog2.vista;

import java.util.logging.Level;
import java.util.logging.Logger;

public class IniciadorClubSocial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            VistaClubSocial vistaClub = new VistaClubSocial();
            vistaClub.gestioClubSocial();          
         }catch(ExcepcioClub ex){
            Logger.getLogger(IniciadorClubSocial.class.getName()).log(Level.SEVERE, null, ex);

        }
        
    }
    
}
