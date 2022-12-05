package Entity;

import java.util.ArrayList;

import Ecosys.Ressource;

public class Carnivore extends LivingEntity{

  @Override
  public void doStuff(ArrayList<Ressource> ressources, ArrayList<LivingEntity> entities) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void eat(Ressource ressource, int quantite) {
    //Les carnivores ne peuvent pas manger de ressources, ils perdent de l'énergie si ils essayent
    energie -= 4;
  }

  @Override
  public void eat(LivingEntity animal) {
    energie += animal.energie;
    energie = energie > MAX_ENERGIE ? MAX_ENERGIE : energie;
    animal.die();
  }

  
}
