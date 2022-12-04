package Ecosys;

import Entity.Entity;

public class Simulation {
  /**
   * Nombre d'entité max que peut contenir la simulation
   */
  private static final int NOMBRE_MAX_ENTITE = 100;

  /**
   * Nombre de ressource max que la simulation peut contenir
   */
  private static final int NOMBRE_MAX_RESSOURCE = 100;
  

  private Terrain terrain;
  private Entity[] entities = new Entity[NOMBRE_MAX_ENTITE];
  private Ressource[] ressources = new Ressource[NOMBRE_MAX_RESSOURCE];

  public Simulation(int m, int n){

    //Initialisation du terrain

    //Initialisation des ressources
    for(int i = 0; i < Math.min(m, NOMBRE_MAX_RESSOURCE); i++){
      int x = (int)(Math.random() * terrain.nbLignes);
      int y = (int)(Math.random() * terrain.nbCollonnes);
      

      ressources[i] = new Ressource(null, 50);
      ressources[i].setPosition(n, i);
      terrain.setCase(n, i, null);
      
    }

    //Initialisation des entités (à faire plus tards)
  }

  public void update(){ /* TODO */ }
  
  public void execute(int maxRound) {
    for (int i = 0; i < maxRound; i++)
      update();
  }
}
