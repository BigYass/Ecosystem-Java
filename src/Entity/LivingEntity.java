package Entity;

import java.util.ArrayList;

import Ecosys.Ressource;
import IntelligenceArtificiel.IA;
import Tools.Action;
import Tools.Action.Movement;

public abstract class LivingEntity extends Entity{
  protected final double maxReachDistance = 1.5;
  /**
   * Energie vitale permettant de faire des actions et de se reproduire
   */
  protected int energie;

  /**
   * Energie vitale maximum de l'entité
   */
  protected final int MAX_ENERGIE = 100; 

  /**
   * Intelligence artificiel permettant de faire le choix de la prochaine action / mouvement
   */
  protected IA cerveau;


  public double getMaxReach(){
    return maxReachDistance;
  }

  public double getEnergie(){
    return energie;
  }
  /**
   * L'entité tente des manger/boire
   * @param ressources Liste des ressources visible pour l'être vivant
   * @param entities Liste des entités visible pour l'être vivant
   * @return Retourne 0
   */
  public void doStuff(ArrayList<Ressource> ressources, ArrayList<LivingEntity> entities){
    Action nextAction = cerveau.nextAction((Ressource[])ressources.toArray(), (LivingEntity[])entities.toArray());
    act(nextAction);

    energie--;
    if(energie < 0) die();
  }

  /**
   * L'entité tente des manger/boire
   */
  public void doStuff(){
    doStuff(null, null);
  }

  /**
   * Mange le nombre <code>quantite</code> de <code>ressource</code>
   * @param ressource La ressource mangé
   * @param quantite Quantité mangé. Par défault: 1
   */
  public abstract void eat(Ressource ressource, int quantite);

  /**
   * Mange un maximum de <code>ressource</code>
   * @param ressource Ressource mangé
   */
  public void eat(Ressource ressource){
    int quantite = Math.min(MAX_ENERGIE - energie, ressource.getQuantite());
    eat(ressource, quantite);
  }

  /**
   * Mange un être vivant
   * @param animal Animal mangé  
   */
  public abstract void eat(LivingEntity animal);

  /**
   * Produit l'action contenu dans l'enum
   * @param action Enum choisissant l'action fait
   */
  public void act(Action action){
    switch (action) {
      case MOVE:
        Movement nextMove = cerveau.nextMove();
        int new_x = x, new_y = y;

        new_x += nextMove == Movement.GAUCHE ? 1 : 0 - (nextMove == Movement.DROITE ? 1 : 0);
        new_y += nextMove == Movement.HAUT ? 1 : 0 - (nextMove == Movement.BAS ? 1 : 0);

        energie -= distance(new_x, new_y)*4;

        seDeplacer(new_x, new_y);
  
        break;
      
      case EAT_RESSOURCE:
        if (action.getTarget() instanceof Ressource){
          Ressource target = (Ressource)action.getTarget();
          eat(target); 
        }
        break;
          
      case EAT_ANIMAL:
        if(action.getTarget() instanceof LivingEntity){
          LivingEntity target = (LivingEntity)action.getTarget();
          eat(target);
        }
        break;

      default:
        break;
    }
  }

  /**
   * Mets l'énergie à -1, pendant l'execution de la simulation, toute les entités
   * avec une énergie inférieur à 0 se vera suppimer
   */
  public void die(){
    energie = -1;
  }
}