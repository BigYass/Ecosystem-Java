package IntelligenceArtificiel;

import java.util.ArrayList;

import Ecosys.Ressource;
import Entity.Entity;
import Tools.Action;
import Tools.Action.Movement;;

public interface IA {

  /**
   * Renvoie le prochain mouvement choisis (nombre compris entre 0 et 3 représantants les 4 directions)
   * @param ressrouces Les ressources du terrain que l'entité peut "voir"
   * @param entities Les autres entités de la simulation que l'entité peut "voir"
   * @return Retourne un <code>Tools.Movement représentant la direction que l'entité souhaites aller:
   * @see Tools.Movement
   */
  Movement nextMove(ArrayList<Ressource> ressources, ArrayList<Entity> entities);

  /**
   * Renvoie le prochain mouvement choisis 
   * @return Retourne la direction que l'entité souhaites aller:
   * @see Tools.Movement
   */
  Movement nextMove();

  public Action nextAction(ArrayList<Ressource> ressources, ArrayList<Entity> entities);
}
