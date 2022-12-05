package IntelligenceArtificiel;

import java.util.ArrayList;

import Ecosys.Ressource;
import Entity.Carnivore;
import Entity.Entity;
import Entity.LivingEntity;
import Tools.Action;
import Tools.Action.Movement;

/**
 * IA au mouvement aléatoire et mangeant la proie la plus proche
 * <p>Réservé au carnivore
 */
public class CarnivoreRandomIA extends RandomIA{ 
  
  //TODO Régler le problème d'implémentation de nextMove()
  
  private final Carnivore body;

  public CarnivoreRandomIA(double randomFactor, Movement firstDirection, Carnivore body) {
    super(randomFactor, firstDirection);
    this.body = body;
  }

  public CarnivoreRandomIA(Movement firstDirection, Carnivore body) {
    super(firstDirection);
    this.body = body;
  }

  public CarnivoreRandomIA(double randomFactor, Carnivore body) {
    super(randomFactor);
    this.body = body;
  }

  public CarnivoreRandomIA(Carnivore body) {
    super();
    this.body = body;
  }

  @Override
  public Action nextAction(Ressource[] ressources, LivingEntity[] entities) {
    Action nextAction = Action.WAIT;

    //Recherche les entités à porté
    for (Entity entity : entities){
      //Si une entité est à porté, ordonne au corps de mangé la proie
      if (entity.distance(body.getX(), body.getY()) < body.getMaxReach()){
        nextAction = Action.EAT_ANIMAL;
        nextAction.setTarget(entity);

        return nextAction;
      }
    }

    //Sinon se déplace
    nextAction = Action.MOVE;
    return nextAction;
  }
  
}
