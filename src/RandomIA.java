public abstract class RandomIA implements IA {
  /**
   * Probabilité de changer de position à chaque appel de nextMove
   */
  protected double probToChangeDirection = .1;

  /**
   * Dernière direction enregistrer, change si: <p><code>Math.random() < probToChangeDirection</code> 
   * @see Action
   */
  protected Movement nextDirection;

  /**
   * Constructeur de <code>RandomIA</code>
   * @param randomFactor La probabilité que <code>nextDirection</code> change. Par défault: 0.1
   * @param firstDirection Initialise la direction à <code>firstDirection</code>. Par défault: Gauche
   */
  public RandomIA(double randomFactor, Movement firstDirection){
    this.probToChangeDirection = randomFactor;
    this.nextDirection = firstDirection;
  }

  /**
   * Constructeur de <code>RandomIA</code>
   * @param firstDirection Initialise la direction à <code>firstDirection</code>. Par défault: Gauche
   */
  public RandomIA(Movement firstDirection){
    this.nextDirection = firstDirection;
  }

  /**
   * Constructeur de <code>RandomIA</code>
   * @param randomFactor La probabilité que <code>nextDirection</code> change. Par défault: 0.1
   */
  public RandomIA(double randomFactor){
    this.probToChangeDirection = randomFactor;
    this.nextDirection = Movement.GAUCHE;
  }

  /**
   * Constructeur de <code>RandomIA</code>
   */
  public RandomIA(){
    this.nextDirection = Movement.GAUCHE;
  }
}
