package Ecosys;

import java.util.ArrayList;
import java.util.Arrays;

import Entity.Entity;
import Entity.LivingEntity;

public class Simulation extends Object{
  /**
   * Les ressources naturels tels que l'herbe se régen tout les {@code PERIODE_REGEN_RESS} tours
   */
  private static final int PERIODE_REGEN_RESS = 5;
  /**
   * Nombre d'entité présent dans la simulation
   */
  private final int nbEntite;

  /**
   * Nombre de ressources présent dans la simulation
   */
  private final int nbRessource;
  
  /**
   * Terrain de la simulation contenant toutes les ressources  
   */
  private Terrain terrain;

  /**
   * Tableau des entités de la simulation
   */
  private ArrayList<LivingEntity> entities = new ArrayList<LivingEntity>();

  /**
   * Ensemble des ressources contenu dans la simulation
   */
  private ArrayList<Ressource> ressources = new ArrayList<Ressource>();

  /**
   * Constructeur de la simulation.
   * La simulation contrôle tout les êvenements tels que les entités, les ressources... etc
   * @param m Nombre de ressources à générer. Si la valeurs dépasse NOMBRE_MAX_RESSOURCE, cette valeurs est remplacée
   * @param n Nombre d'entités à générer. Si la valeurs dépasse NOMBRE_MAX_ENTITE, cette valeurs est remplacée
   */
  public Simulation(int m, int n){

    //Initialisation des variables
    nbRessource = m;
    nbEntite = n;

    //Initialisation du terrain
    for(int i = 0; i < terrain.nbLignes; i++)
      for(int j = 0; j < terrain.nbCollonnes; j++)
        terrain.setCase(i, j, new Ressource("terre", 1));

    //Initialisation des ressources
    for(int i = 0; i < m; i++){
      int x = (int)(Math.random() * terrain.nbLignes);
      int y = (int)(Math.random() * terrain.nbCollonnes);

      ressources.add(new Ressource("Herbes", 50));
      ressources.get(i).setPosition(x, y);
    }

    //Initialisation des entités (à faire plus tards)
  }
  
  /**
   * Exécute la simulation pendant maxRound tours
   * @param maxRound Le nombre maximum de tours
   */
  public void execute(int maxRound) {
    for (int i = 0; i < maxRound; i++)
    {
      for (LivingEntity entity : entities)
      {
        if (entity.getEnergie() < 0)
        {
          entities.remove(entity);
        }
        else
        {
          entity.doStuff(ressources, entities);
        }
      }

      if(i % PERIODE_REGEN_RESS == 0){
        for (Ressource ressource : ressources){
          ressource.setQuantite(ressource.getQuantite() + 1);
        }
      }
    }
      
  }
}
