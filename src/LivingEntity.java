import java.util.ArrayList;

public abstract class LivingEntity extends Entity{
  /**
   * Distance maximale à laquel un animal peut atteindre une ressource ou une autre entité
   */
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


  protected LivingEntity(int x, int y, int energie) {
    super(x, y);
    this.energie = energie;
  }

  protected LivingEntity(int energie) {
    super(0, 0);
    this.energie = energie;
  }

  protected LivingEntity(LivingEntity entity){
    super(entity.getX(), entity.getY());
    this.energie = entity.getEnergie();
  }

  public double getMaxReach(){
    return maxReachDistance;
  }

  public int getEnergie(){
    return energie;
  }
  /**
   * L'entité tente des manger/boire
   * @param ressources Liste des ressources visible pour l'être vivant
   * @param entities Liste des entités visible pour l'être vivant
   * @return Retourne 0
   */
  public Action doStuff(ArrayList<Ressource> ressources, ArrayList<LivingEntity> entities){
    Ressource[] ressourcesArray = ressources.toArray(new Ressource[ressources.size()]);
    LivingEntity[] entitiesArray = entities.toArray(new LivingEntity[entities.size()]);
    Action nextAction = cerveau.nextAction(ressourcesArray, entitiesArray);
    act(nextAction);

    energie--;
    if(energie < 0) die();

    return nextAction;
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
        Movement nextMove = cerveau.nextMove(null, null);
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

      case REPRODUCE: //La simulation s'occupe de rajotuer le clone
        energie /= 2;
        if (energie < MAX_ENERGIE / 10) die(); //Si après la reproduction il ne lui reste moins de 10% d'énergie, l'animal meurt
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