package Entity;

import java.util.ArrayList;

import Ecosys.Ressource;

public class Herbivore extends LivingEntity{

  @Override
  public void doStuff(ArrayList<Ressource> ressources, ArrayList<LivingEntity> entities) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void eat(Ressource ressource, int quantite) {
    //Les herbivores peuvent manger les ressources pour le moment chaque ressource rapport 1 d'énergie
    ressource.setQuantite(ressource.getQuantite() - quantite);
    energie += quantite;
  }

  @Override
  public void eat(LivingEntity animal) {
    //Les herbivore ne peuvent pas manger d'animaux si il essayent ils perdent de l'énergie
    energie -= 4;
  }
  
}
