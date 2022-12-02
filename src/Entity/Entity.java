package Entity;

public abstract class Entity{
  /**
   * Position de l'entité
   */
  protected int x, y;

  /**
   * @param x Position de la cible en x
   * @param y Position de la cible en y
   * @return La distance entre l'entité et la cible de coordonée x et y
   */

  public double distance(int x, int y){ return Math.sqrt(Math.pow(this.x - x, 2.) + Math.pow(this.y - y, 2.)); }

  /**
   * @param xnew Nouvelle position x pour l'entité
   * @param ynew Nouvelle position y pour l'entité
   * Déplace l'entité vers la position (xnew, ynew) si la case est vide
   */
  public void seDeplacer(int xnew, int ynew) { x = xnew; y = ynew; }
}