package Tools;

public enum Action {
  MOVE, EAT_ANIMAL, EAT_RESSOURCE, WAIT;

  /**
   * Si l'action est {@code EAT_ANIMAL} ou {@code EAT_RESSOURCE} l'élémént visé est {@code entity}
   */
  private Object target;
  
  /**
   * Retourne la cible de l'action
   * @return La cible de l'action
   */
  public Object getTarget() {
    return target;
  }

  /**
   * Change la cible de l'action
   * @param target La nouvel cible de l'action
   */
  public void setTarget(Object target) {
    this.target = target;
  }


  /**
   * Enum pour les mouvements 
   */
  public enum Movement{
    GAUCHE, HAUT, DROITE, BAS, CENTRE;

  /**
   * Renvoie un mouvement aléatoire
   * @return Renvoie un mouvement aléatoire parmis ceux présent dans mouvement
   */
  public static Movement randomDirection(){
    Movement[] movements = values();
    int l = movements.length;
    return movements[(int) (Math.random() * l)];
  }

  }

  
}
