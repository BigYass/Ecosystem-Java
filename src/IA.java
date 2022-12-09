/**
 * Class permettant aux {@codeLivingEntity} de faire de choix
 */
public interface IA {

  /**
   * Renvoie le prochain mouvement choisis (nombre compris entre 0 et 3 représantants les 4 directions)
   * @param ressrouces Les ressources du terrain que l'entité peut "voir"
   * @param entities Les autres entités de la simulation que l'entité peut "voir"
   * @return Retourne un <code>Tools.Movement représentant la direction que l'entité souhaites aller:
   * @see Tools.Movement
   */
  public Movement nextMove(Ressource[] ressources, LivingEntity[] entities);

  public Action nextAction(Ressource[] ressources, LivingEntity[] entities);
}
