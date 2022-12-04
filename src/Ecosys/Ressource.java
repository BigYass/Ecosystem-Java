package Ecosys;

public class Ressource extends Object{
  /**
   * Identifiant (unique) d'une ressource
   */
  public final int indent = 0;

  /**
   * Donne le type de la ressource selon la simulation, par ex. : "Pollen", "Miel", etc.
   */
  public String type;

  /**
   * Constructeur de ressource.
   * @param type Donne le type de la ressource à créer
   * @param quantite Donne la quantité de cette ressource
   */
  public Ressource(String type, int quantite) {}

  /**
   * Accesseur de X
   * @return Numéro de ligne
   */
  public int getX() { return 0; }

  /**
   * Accesseur de Y
   * @return Numéro de colonne
   */
  public int getY() { return 0; }

  /**
   * Accesseur (getter) de la quantité.
   * @return La quantité
   */
  public int getQuantite() { return 0; }

  /**
   * Accesseur (setter) de la quantité
   * @param quantite Valeur à donner
   */
  public void setQuantite(int quantite) {}

  /**
   * Pour associer une ressource à une case (position sur le terrain).
   * @param x Numéro de ligne où se trouve la ressource
   * @param y Numéro de colonne où se trouve la ressource
   */
  public void setPosition(int x, int y) {}

  /**
   * Retire la ressource du terrain en remettant ses coordonnées à (-1,-1).
   */
  public void initialisePosition() {}

  /**
   * Informations sur la ressource.
   * @return L'identifiant, le nom de la ressource et sa position sur le terrain
   */
  public String toString() { return ""; }
}
