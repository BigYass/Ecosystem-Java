package IntelligenceArtificiel;

import java.util.ArrayList;

import Ecosys.Ressource;
import Entity.Entity;
import Tools.Action;
import Tools.Action.Movement;

public class CarnivoreRandomIA implements IA{
  /**
   * Probabilité de changer de position à chaque appel de nextMove
   */
  private double probToChangeDirection = .1;

  /**
   * Dernière direction enregistrer, change si: <p><code>Math.random() < probToChangeDirection</code> 
   * @see Tools.Action
   */
  private Movement nextDirection;

  /**
   * Constructeur de <code>CarnivoreRandomIA</code>
   * @param randomFactor La probabilité que <code>nextDirection</code> change. Par défault: 0.1
   * @param firstDirection Initialise la direction à <code>firstDirection</code>. Par défault: Gauche
   */
  public CarnivoreRandomIA(double randomFactor, Movement firstDirection){
    this.probToChangeDirection = randomFactor;
    this.nextDirection = firstDirection;
  }

  /**
   * Constructeur de <code>CarnivoreRandomIA</code>
   * @param firstDirection Initialise la direction à <code>firstDirection</code>. Par défault: Gauche
   */
  public CarnivoreRandomIA(Movement firstDirection){
    this.nextDirection = firstDirection;
  }

  /**
   * Constructeur de <code>CarnivoreRandomIA</code>
   * @param randomFactor La probabilité que <code>nextDirection</code> change. Par défault: 0.1
   */
  public CarnivoreRandomIA(double randomFactor){
    this.probToChangeDirection = randomFactor;
    this.nextDirection = Movement.GAUCHE;
  }

  /**
   * Constructeur de <code>CarnivoreRandomIA</code>
   */
  public CarnivoreRandomIA(){
    this.nextDirection = Movement.GAUCHE;
  }
  
  @Override
  public Movement nextMove(ArrayList<Ressource> ressources, ArrayList<Entity> entities) {
    if(Math.random() < probToChangeDirection)
      nextDirection = Movement.randomDirection();
    return nextDirection;
  }

  @Override
  public Movement nextMove() {
    return nextMove(null, null);
  }


  @Override
  public Action nextAction(ArrayList<Ressource> ressources, ArrayList<Entity> entities) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
