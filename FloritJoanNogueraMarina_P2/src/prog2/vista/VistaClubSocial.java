/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.vista;

import java.util.Scanner;
import prog2.model.ClubSocial;

/**
 *
 * @author Marina
 */
public class VistaClubSocial {
    private ClubSocial club;
    private Scanner sc = new Scanner(System.in);
    
    
    public void gestioClubSocial(){
        Scanner sc = new Scanner(System.in);
        gestioMenu(sc);
    }
    
    private static enum OpcionsMenu{
        M_Opcio_DonarAltaSoci,
        M_Opcio_MostrarSocis,
        M_Opcio_EliminarSoci,
        M_Opcio_VerificarSocis,
        M_Opcio_MostrarActivitats,
        M_Opcio_MostrarActivitatsSoci,
        M_Opcio_AfegirActivitat,
        M_Opcio_Factura,
        M_Opcio_ModificarNomSoci,
        M_Opcio_ModificarTipusAsseguranca,
        M_Opcio_GuardarDades,
        M_Opcio_RecuperarDades,
        M_Opcio_Sortir
    };
    
    private static enum OpcionsSoci{
        M_Opcio_SociVip,
        M_Opcio_SociEstandard,
        M_Opcio_SociJunior,
        M_Opcio_MenuAnterior
    };
    
    private static final String[] descMenu = {
        "Donar d’alta un nou soci",
        "Mostrar llista de socis",
        "Mostrar llista de socis vip",
        "Mostrar llista de socis estandard",
        "Mostrar llista de socis junior",
        "Eliminar soci",
        "Verificar socis",
        "Mostrar llista d’activitats",
        "Mostrar llista d’activitats realitzades per un soci",
        "Afegir activitat realitzada per un soci",
        "Mostrar total factura",
        "Modificar nom soci",
        "Modificar tipus assegurança soci estàndard",
        "Guardar dades",
        "Recuperar dades"
    };
    
    private static final String[] descSoci = {
        "Afegir soci VIP",
        "Afegir soci Estandard",
        "Afegir soci Junior",
        "Menu anterior"
    };
    
    
    public void gestioMenu(Scanner sc){
        Menu<OpcionsMenu> menuClub = new Menu<>("Menu Club Social ",OpcionsMenu.values()); 
        menuClub.setDescripcions(descMenu);
        OpcionsMenu opcioMenu;
        
        do{
            menuClub.mostrarMenu();
            opcioMenu = menuClub.getOpcio(sc);
            
            switch(opcioMenu){
                case M_Opcio_DonarAltaSoci:
                    gestioSoci(sc);
                    break;
                case M_Opcio_MostrarSocis:
                    System.out.println()
            }
        }
   }
}
