

public class Herbivore extends LivingEntity{

  public Herbivore(int x, int y, int energie) {
    super(x, y, energie);
    cerveau = new HerbivoreRandomIA(this);
  }

  public Herbivore(int energie) {
    super(energie);
    cerveau = new HerbivoreRandomIA(this);
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
