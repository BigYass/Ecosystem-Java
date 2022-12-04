package Ecosys;

import Entity.Entity;

public class Simulation extends Object{
  /**
   * Nombre d'entité max que peut contenir la simulation
   */
  private static final int NOMBRE_MAX_ENTITE = 100;

  /**
   * Nombre de ressource max que la simulation peut contenir
   */
  private static final int NOMBRE_MAX_RESSOURCE = 100;

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
  private Entity[] entities = new Entity[NOMBRE_MAX_ENTITE];

  /**
   * Ensemble des ressources contenu dans la simulation
   */
  private Ressource[] ressources = new Ressource[NOMBRE_MAX_RESSOURCE];

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
  
  /**
   * Exécute la simulation pendant maxRound tours
   * @param maxRound Le nombre maximum de tours
   */
  public void execute(int maxRound) {
    for (int i = 0; i < maxRound; i++)
      update();
  }
}
