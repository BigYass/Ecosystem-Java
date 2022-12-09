

public enum Action {
  MOVE, EAT_ANIMAL, EAT_RESSOURCE, REPRODUCE;

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

  
}
