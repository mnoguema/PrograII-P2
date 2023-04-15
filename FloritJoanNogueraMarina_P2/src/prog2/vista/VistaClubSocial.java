/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.vista;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import prog2.model.ClubSocial;

/**
 *
 * @author Marina
 */
public class VistaClubSocial {

    private ClubSocial club;
    private Scanner sc = new Scanner(System.in);

    public VistaClubSocial() throws ExcepcioClub {
        club = new ClubSocial();
    }

    public void gestioClubSocial() throws ExcepcioClub {
        Scanner sc = new Scanner(System.in);
        gestioMenu(sc);
    }

    private String getFilePath(Scanner sc) throws ExcepcioClub {
        System.out.println("Recorda que no es pot incloure cap d'aquests caràcters:");
        System.out.println("\\, /, *, ?, \", <, >, |");
        String result = sc.nextLine();

        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            char l[] = {'\\', '/', '*', '?', '\"', '<', '>', '|'};

            for (char ci : l) {
                if (c == ci) {
                    throw new ExcepcioClub("Has inclos algun valor incorrecte en el nom.");
                }
            }

        }

        return result;
    }

    private static enum OpcionsMenu {
        M_Opcio_DonarAltaSoci,
        M_Opcio_MostrarSocis,
        M_Opcio_MostrarSocisVip,
        M_Opcio_MostrarSocisEstandard,
        M_Opcio_MostrarSocisJunior,
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

    private static enum OpcionsSoci {
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

    public void gestioMenu(Scanner sc) throws ExcepcioClub {
        Menu<OpcionsMenu> menuClub = new Menu<>("Menu Club Social ", OpcionsMenu.values());
        menuClub.setDescripcions(descMenu);
        OpcionsMenu opcioMenu;

        do {
            menuClub.mostrarMenu();
            opcioMenu = menuClub.getOpcio(sc);

            switch (opcioMenu) {
                case M_Opcio_DonarAltaSoci:
                    gestioSocis(sc);
                    break;
                case M_Opcio_MostrarSocis:
                    System.out.println(club.mostrarSocisMenu("Tots"));
                    break;
                case M_Opcio_MostrarSocisVip:
                    System.out.println(club.mostrarSocisMenu("VIP"));
                    break;
                case M_Opcio_MostrarSocisEstandard:
                    System.out.println(club.mostrarSocisMenu("Estandard"));
                    break;
                case M_Opcio_MostrarSocisJunior:
                    System.out.println(club.mostrarSocisMenu("Junior"));
                    break;
                case M_Opcio_EliminarSoci:
                    System.out.println("Dni del soci que es vol eliminar?\n");
                    System.out.println(club.mostrarSocisMenu("Tots"));
                    String dni = sc.nextLine();
                    club.eliminarSociMenu(dni);
                    break;

                case M_Opcio_VerificarSocis:
                    try {
                    club.verificarSocisMenu();
                } catch (ExcepcioClub ex) {
                    System.out.println(ex.getMessage());
                }
                break;

                case M_Opcio_MostrarActivitats:
                    System.out.println(club.mostrarActivitats());
                    break;

                case M_Opcio_MostrarActivitatsSoci:
                    System.out.println("Dni del soci del qual es vol mostrar la llista d'activitats?\n");
                    System.out.println(club.mostrarSocisMenu("Tots"));
                    dni = sc.nextLine();
                    try {
                        System.out.println(club.mostrarActivitatsSoci(dni));
                    } catch (ExcepcioClub ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case M_Opcio_AfegirActivitat:
                    System.out.println("Dni del soci al qual se li vol afegir una activitat?\n");
                    System.out.println(club.mostrarSocisMenu("Tots"));
                    dni = sc.nextLine();
                    System.out.println("Numero de l'activitat que se li vol afegir?\n");
                    int activitat = sc.nextInt();
                    try {
                        club.afegirActivitatMenu(dni, activitat - 1);
                    } catch (ExcepcioClub ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case M_Opcio_Factura:
                    System.out.println("Dni del soci del qual es vol consultar la factura?\n");
                    System.out.println(club.mostrarSocisMenu("Tots"));
                    dni = sc.nextLine();
                    try {
                        System.out.println("El preu de la factura del soci es " + club.calcularFacturaMenu(dni) + "\n");
                    } catch (ExcepcioClub ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case M_Opcio_ModificarNomSoci:
                    System.out.println("Dni del soci al qual se li vol canviar el nom\n");
                    System.out.println(club.mostrarSocisMenu("Tots"));
                    dni = sc.nextLine();
                    System.out.println("Nou nom?\n");
                    String nom = sc.nextLine();
                    try {
                        club.canviarNomSociMenu(dni, nom);
                    } catch (ExcepcioClub ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case M_Opcio_ModificarTipusAsseguranca:
                    System.out.println("Dni del soci al qual se li vol canviar l'assegurança\n");
                    System.out.println(club.mostrarSocisMenu("Tots"));
                    dni = sc.nextLine();
                    System.out.println("Nou tipus d'assegurança\n");
                    nom = sc.nextLine();
                    try {
                        club.canviarAsseguranca(dni, nom);
                    } catch (ExcepcioClub ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case M_Opcio_GuardarDades:
                    System.out.println("Amb quin nom ho vols guardar?");
                    String nomFitxer = getFilePath(sc);
                    try {
                        System.out.println(nomFitxer);
                        club.guarda(nomFitxer);
                    } catch (ExcepcioClub | IOException ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;

                case M_Opcio_RecuperarDades:
                    String srcFile;
                    try {
                        System.out.println("Nom del arxiu que vols recuperar.");
                        srcFile = getFilePath(sc);
                    } catch (ExcepcioClub e) {
                        System.out.println("No s'ha pogut guardar pel nom.");
                        System.out.println(e.toString());
                        break;
                    }
                    if (srcFile != null) {
                        try {
                            club = ClubSocial.recupera(srcFile);
                        } catch (ExcepcioClub ex) {
                            System.out.println("Error al recuperar les dades.");
                        } catch (FileNotFoundException ex) {
                            System.out.println("Fitxer no trobat");
                        } catch (IOException ex) {
                            System.out.println("Error de IO");
                        }
                    }
                    break;
            }
        } while (opcioMenu != OpcionsMenu.M_Opcio_Sortir);
    }

    public void gestioSocis(Scanner sc) {
        Menu<OpcionsSoci> menuClub = new Menu<>("Menu Club Social ", OpcionsSoci.values());
        menuClub.setDescripcions(descSoci);
        OpcionsSoci opcioMenu;
        String nom, dni, tipus;
        float descompte, preu;
        int edat;
        do {
            menuClub.mostrarMenu();
            opcioMenu = menuClub.getOpcio(sc);
            switch (opcioMenu) {
                case M_Opcio_SociVip:
                    System.out.println("Digam el nom del Soci.");
                    nom = sc.nextLine();
                    System.out.println("Digam el seu DNI.");
                    dni = sc.nextLine();
                    System.out.println("Quin descompte se li aplica?");
                    descompte = sc.nextFloat();
                    try {
                        club.addSoci(1, nom, dni, descompte, "", 0, 0);
                        System.out.println("Soci VIP amb DNI " + dni + " afegit.");
                    } catch (ExcepcioClub e) {
                        System.out.println("No s'ha pogut afegir el soci degut al següent error:");
                        System.out.println(e.toString());
                    }
                    break;
                case M_Opcio_SociEstandard:
                    System.out.println("Digam el nom del Soci.");
                    nom = sc.nextLine();
                    System.out.println("Digam el seu DNI.");
                    dni = sc.nextLine();
                    System.out.println("Quin tipus d'asseguranca te?");
                    tipus = sc.nextLine();
                    System.out.println("Preu de l'asseguranca.");
                    preu = sc.nextFloat();
                    try {
                        club.addSoci(2, nom, dni, 0, tipus, preu, 0);
                        System.out.println("Soci Estandard amb DNI " + dni + " afegit.");
                    } catch (ExcepcioClub e) {
                        System.out.println("No s'ha pogut afegir el soci degut al següent error:");
                        System.out.println(e.toString());
                    }
                    break;
                case M_Opcio_SociJunior:
                    System.out.println("Digam el nom del Soci.");
                    nom = sc.nextLine();
                    System.out.println("Digam el seu DNI.");
                    dni = sc.nextLine();
                    System.out.println("Quin tipus d'asseguranca te?");
                    tipus = sc.nextLine();
                    System.out.println("Preu de l'asseguranca.");
                    preu = sc.nextFloat();
                    System.out.println("Quina edat te?");
                    edat = sc.nextInt();
                    try {
                        club.addSoci(3, nom, dni, 0, tipus, preu, edat);
                        System.out.println("Soci Junior amb DNI " + dni + " afegit.");
                    } catch (ExcepcioClub e) {
                        System.out.println("No s'ha pogut afegir el soci degut al següent error:");
                        System.out.println(e.toString());
                    }
                    break;
            }
        } while (opcioMenu != OpcionsSoci.M_Opcio_MenuAnterior);
    }
}
