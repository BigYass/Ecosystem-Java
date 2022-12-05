package Entity;

import Ecosys.Ressource;

public abstract class Entity extends Object{
  /**
   * Position de l'entité
   */
  protected int x, y;

  /**
   * Initialise l'entité en position (x, y)
   * @param x Numéro de la ligne
   * @param y Numéro de la colonne
   */
  public Entity(int x, int y){
    this.x = x;
    this.y = y;
  }

  /**
   * Initialise l'entité en position (0, 0)
   */
  public Entity(){
    this.x = 0;
    this.y = 0;
  }
  
  /**
   * @param x Position de la cible en x
   * @param y Position de la cible en y
   * @return Retourne la distance entre l'entité et la cible de coordonée x et y
   */
  public double distance(int x, int y){ 
    return Math.sqrt(Math.pow(this.x - x, 2.) + Math.pow(this.y - y, 2.)); 
  }

  /**
   * Calcule la distance 
   * @param entity L'autre entité
   * @return La distance
   */
  public double distance(Entity entity){
    return distance(entity.x, entity.y);
  }

  /**
   * Calcule la distance entre l'entité et la ressource donée en paramètre
   * @param ressource Le ressource avec laquel on calcule la distance
   * @return La disance 
   */
  public double distance(Ressource ressource){
    return distance(ressource.getX(), ressource.getY());
  }
  
  /**
   * @param xnew Nouvelle position x pour l'entité
   * @param ynew Nouvelle position y pour l'entité
   * Déplace l'entité vers la position (xnew, ynew) si la case est vide, sinon reste fixe
   */
  public void seDeplacer(int xnew, int ynew) { 
    /* TODO */ 
  }

  public int getX() {
    return x;
  }
  
  public int getY() {
    return y;
  }
  
}