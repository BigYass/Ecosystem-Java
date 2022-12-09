import java.util.ArrayList;

public class Simulation extends Object{
  /**
   * Les ressources naturels tels que l'herbe se régene toutes les {@code PERIODE_REGEN_RESS} tours
   */
  private static final int PERIODE_REGEN_RESS = 50;

  /**
   * Quantité d'énergie initiale de toutes les entités
   */
  private static final int INIT_ENERGIE = 5;

  /**
   * Afficher le texte de debug ?
   */
  private static final boolean debug = true;
  
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
   * @param nbRessource Nombre de ressources à générer. Si la valeurs dépasse NOMBRE_MAX_RESSOURCE, cette valeurs est remplacée
   * @param nbPredateur Nombre d'entités à générer. Si la valeurs dépasse NOMBRE_MAX_ENTITE, cette valeurs est remplacée
   */
  public Simulation(int nbRessource, int nbPredateur, int nbProies){
    terrain = new Terrain();

    log(String.format("Terrain de %d lignes et %d collones est cree", terrain.nbLignes, terrain.nbColonnes));

    //Initialisation du terrain
    for(int i = 0; i < terrain.nbLignes; i++)
      for(int j = 0; j < terrain.nbColonnes; j++)
        terrain.setCase(i, j, new Ressource("terre", 1));

    //Initialisation des ressources
    for(int i = 0; i < nbRessource; i++){
      int x = (int)(Math.random() * terrain.nbLignes);
      int y = (int)(Math.random() * terrain.nbColonnes);

      ressources.add(new Ressource("Herbes", 50));
      ressources.get(i).setPosition(x, y);
    }

    //Initialisation des entités
    //La moitié sont des Tigres
    for (int i = 0; i < nbPredateur; i++){
      int x = (int)(Math.random() * terrain.nbLignes);
      int y = (int)(Math.random() * terrain.nbColonnes);

      LivingEntity entity = new Tigre(x, y, INIT_ENERGIE);
      entities.add(entity);
    }

    //L'autre moitié sont des gazelles
    for (int i = 0; i < nbProies; i++){
      int x = (int)(Math.random() * terrain.nbLignes);
      int y = (int)(Math.random() * terrain.nbColonnes);

      LivingEntity entity = new Gazelle(x, y, INIT_ENERGIE);
      entities.add(entity);
    }
  }
  
  /**
   * Exécute la simulation pendant maxRound tours
   * @param maxRound Le nombre maximum de tours
   */
  public void execute(int maxRound) {
    for (int i = 0; i < maxRound && entities.size() > 0; i++)
    {
      //Boucle princiapale
      afficherEntitites();

      //Pour éviter les conflits, on retire et ajoute les nouvelles entités seulement après les avoir tous traités
      ArrayList<LivingEntity> entitiesToRemove = new ArrayList<LivingEntity>();
      ArrayList<LivingEntity> entitiesToAdd = new ArrayList<LivingEntity>();
      
      /**
       * Variables utiliser pour log des statistiques
       */
      int numberOfReproduce = 0, numberOfAnimalRemoved = 0;

      /**
       * Boucle traitant chaque animal.
       * C'est dans cette boucle et chaque entité performe leur action et leurs variables sont mis à jour
       */
      for (LivingEntity entity : entities)
      {
        if (entity.getEnergie() < 0)
        {
          entitiesToRemove.add(entity);
          numberOfAnimalRemoved++;
        }
        else
        {
          Action done = entity.doStuff(ressources, entities);

          /**
           * Si une entités souhaitent se reproduire, c'est la simulation qui décide si cela est possible
           * Dans notre cas, seules les Gazelles et les Tigres peuvent se reproduire (Il s'agit des seules races pour le moment)
           * On pourra imaginer une race comme le rat qui créera plus d'une entités lors de sa reproduction
           */
          switch (done) {
            case REPRODUCE:
              numberOfReproduce++;
              if (entity instanceof Gazelle){
                LivingEntity baby = new Gazelle(entity.getX(), entity.getY(), entity.getEnergie());
                entitiesToAdd.add(baby);
              }
              else if (entity instanceof Tigre){
                LivingEntity baby = new Tigre(entity.getX(), entity.getY(), entity.getEnergie());
                entitiesToAdd.add(baby);
              }
              else{
                log("Erreur: Entité inconnu!!");
              }
              break;
            case MOVE:

              // On vérifie la nouvelle position de l'Entité seulement si il s'est déplacer
              try {
                if (entity.getX() >= terrain.nbLignes || entity.getX() < 0 || entity.getY() >= terrain.nbColonnes || entity.getY() < 0 )
                  throw new InvalidPositionException(entity.getX(), entity.getY());
              } catch (InvalidPositionException e) {
                int newX = entity.getX(), newY = entity.getY();

                if(newX < 0)
                  newX = 0;
                else if(newX >= terrain.nbLignes)
                  newX = terrain.nbLignes - 1;

                  if(newY < 0)
                  newY = 0;
                else if(newY >= terrain.nbColonnes)
                  newY = terrain.nbColonnes - 1;

                entity.seDeplacer(newX, newY);
              }
              break;
            default:
              break;
          }
        }
      }

      //On affiche quelque statistique intéressantes
      log(String.format("%d animaux se sont reproduit", numberOfReproduce));
      log(String.format("%d animaux ont ete retire de la simulation", numberOfAnimalRemoved));
      
      //Régenération de ressource
      if(i % PERIODE_REGEN_RESS == 0){
        for (Ressource ressource : ressources){
          ressource.setQuantite(ressource.getQuantite() + 1);
        }
      }

      //On retire les animaux mort
      for (LivingEntity e : entitiesToRemove) {
        entities.remove(e);
        
      }

      //On ajoute les nouveaux nés
      for (LivingEntity e : entitiesToAdd) {
        entities.add(e);
      }
    }
  }
  
  /**
   * Permet d'afficher un message dans le terminal si {@code debug} est {@code true} 
   * @param msg Message à afficher dans la console
   */
  private final void log(String msg){
    if(debug)
      System.out.println(msg);
  }

  /**
   * Affiche le nombre d'entités présentes dans la simulation
   */
  public void afficherEntitites(){
    //String s = new String(new char[terrain.nbLignes * terrain.nbColonnes]).replace('\0', ' ');

    System.out.println(String.format("Nombre de Tigres : %d\tNombre de Gazelle : %d", getNumberOfGazelle(), getNumberOfTigre()));
    //TODO
    
  }

  /**
   * Retourne le nombre de gazelle dans la simulation, peut être optimiser en séparant les différentes races
   * en plusieurs ArrayList
   * @return Le nombre de gazelle dans la simulation
   */
  private int getNumberOfGazelle(){
    int n = 0;
    for (Entity e : entities)
      if(e instanceof Gazelle)
        n++;
      
    return n;
  }

  /**
   * Retourne le nombre de tigres dans la simulation, peut être optimiser en séparant les différentes races
   * en plusieurs ArrayList
   * @return Le nombre de tigres dans la simulation
   */
  private int getNumberOfTigre(){
    int n = 0;
    for (Entity e : entities)
      if(e instanceof Tigre)
        n++;
      
    return n;
  }
}
