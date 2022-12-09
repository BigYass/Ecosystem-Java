
/**
 * Enum pour les mouvements 
 */
public enum Movement{
  GAUCHE, HAUT, DROITE, BAS;

/**
 * Renvoie un mouvement aléatoire
 * @return Renvoie un mouvement aléatoire parmis ceux présent dans mouvement
 */
public static Movement randomDirection(){
  Movement[] movements = values();
  int l = movements.length;
  return movements[(int) (Math.random() * l)];
}

}