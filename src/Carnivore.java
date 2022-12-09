

public class Carnivore extends LivingEntity{

  public Carnivore(int x, int y, int energie) {
    super(x, y, energie);
    cerveau = new CarnivoreRandomIA(this);
  }

  public Carnivore(int energie) {
    super(energie);
    cerveau = new CarnivoreRandomIA(this);
  }

  @Override
  public void eat(Ressource ressource, int quantite) {
    //Les carnivores ne peuvent pas manger de ressources, ils perdent de l'énergie si ils essayent
    energie -= 4;
  }

  @Override
  public void eat(LivingEntity animal) {
    energie += animal.energie;
    energie = energie > MAX_ENERGIE ? MAX_ENERGIE : energie;
    animal.die();
  }

  
}
