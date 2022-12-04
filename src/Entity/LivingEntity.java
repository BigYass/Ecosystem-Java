package Entity;

import IntelligenceArtificiel.IA;

public abstract class LivingEntity extends Entity{
  /**
   * Energie vitale permettant de faire des actions et de se reproduire
   */
  protected int energie;

  /**
   * Intelligence artificiel permettant de faire le choix de la prochaine action / mouvement
   */
  protected IA cerveau;
}