

import java.util.ArrayList;

public class Terrain extends Object{
  /**
   * Nombre maxiumum de lignes et de colonnes qu'un terrain peut posséder
   */
  public static final int NBLIGNEMAX = 0, NBCOLONNESMAX = 0;

  /**
   * Nombre de lignes et de colonnes du terrain crée
   */
  public int nbLignes, nbColonnes;

  /**
   * Constructeur de Terrain (tableau Ressource[][])
   * Par défaut: le terrain est de taille maximale.
   */
  public Terrain() {}

  /**
   * Consutructeur de Terrain (tableau Ressource[][])
   * @param nbLignes Nombre de ligne du terrain à créer
   * @param nbCollonnes Nombre de collone du terrain à créer
   */
  public Terrain(int nbLignes, int nbCollonnes) {}

  /**
   * Pour obtenir le contenu d'une case de terrain
   * @param x Indice ligne demandé
   * @param y Indice colonne demandé
   * @return Le contenu de la case (x, y) ou bien null si la case est vide.
   */
  public Ressource getCase(int x, int y) {return null;}

  /**
   * Vidage d'une case du terrain.
   * @param x Indice ligne demandé
   * @param y Indice colonne demandé
   * @return La ressource en (x, y) ou bien null si la case était vide
   */
  public Ressource videCase(int x, int y) {return null;} 

  /**
   * Positionnement d'une ressource dans une case
   * @param x Indice ligne demandé
   * @param y Indice colonne demandé
   * @param ress  Ressource à mettre dans la case (x, y)
   * @return True si la ressource a pu être mise sur le terrain, false sinon
   */
  public boolean setCase(int x, int y, Ressource ress){ return false; }

  /**
   * Pour savoir si une case du terrain est vide
   * @param x Indice ligne demandé
   * @param y Indice colonne demandé
   * @return True s'il n'y a rien en (lig, col) ou si les coordonnées ne sont pas correctes, false sinon (case occupée)
   */
  public boolean caseEstVidee(int x, int y) { return false; }

  /**
   * La liste de toutes les ressources (référence) actuellement sur le terrain
   * @return Liste (ArrayList) de toutes les ressources présentes.
   */
  public ArrayList<Ressource> lesRessources(){ return null; }

  /**
   * Validation des indices fournis: ils sont valides s'ils correspondent bien aux coordonnées d'une case du terrain.
   * @param x Indice ligne
   * @param y Indice colonne
   * @return True si x et y sont corrects pour le terrain
   */
  public boolean sontValides(int x, int y) { return false; }
  
  /**
   * Affichage du terrain sous la forme d'une grille en mode texte
   * @param nbCaracteres Nombre de caractères pour afficher l'ident de la ressource sur le terrain
   */
  public void affiche(int nbCaracteres) {}

  /**
   * Informations sur le terrain. Rem: cela ne donne pas d'information sur le contenu des cases (cf. affiche()).
   * @return Des informations sur le terrain
   */
  public String toString() { return ""; }
}
