package IntelligenceArtificiel;

import Ecosys.Ressource;
import Entity.Herbivore;
import Entity.LivingEntity;
import Tools.Action;
import Tools.Action.Movement;


public class HerbivoreRandomIA extends RandomIA{

  //Déplacer body dans une classe supérieur
  private final Herbivore body;

  public HerbivoreRandomIA(double randomFactor, Movement firstDirection, Herbivore body) {
    super(randomFactor, firstDirection);
    this.body = body;
  }

  public HerbivoreRandomIA(Herbivore body) {
    super();
    this.body = body;
  }

  @Override
  public Action nextAction(Ressource[] ressources, LivingEntity[] entities) {
    Action nextAction = Action.MOVE;

    for(Ressource ressource : ressources){
      if(body.getX() == ressource.getX() && body.getY() == ressource.getY()){ // Si la ressource et l'entité sont sur la meme case
        nextAction = Action.EAT_RESSOURCE;
        nextAction.setTarget(ressource);

        return nextAction;
      }
    }
    
    return nextAction;
  }

  @Override
  public Movement nextMove(Ressource[] ressources, LivingEntity[] entities) {
    if(Math.random() < probToChangeDirection)
      nextDirection = Movement.randomDirection();
    return nextDirection;
  }

  
}
