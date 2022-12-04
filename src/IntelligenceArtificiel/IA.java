package IntelligenceArtificiel;

import java.util.ArrayList;

import Ecosys.Ressource;
import Entity.Entity;

public interface IA {
  
  
  int nextMove(ArrayList<Ressource> ressrouces, ArrayList<Entity> entities);
}
