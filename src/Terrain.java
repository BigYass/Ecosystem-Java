import java.util.ArrayList;

public class Terrain extends Object{
  public static final int NBLIGNEMAX = 0, NBCOLONNESMAX = 0;
  public int nbLignes, nbCollonnes;

  public Terrain() {}
  public Terrain(int nbLignes, int nbCollonnes) {}
  public void affiche(int nbCaracteres) {}
  public boolean caseEstVidee(int x, int y) { return false; }
  public Ressource getCase(int x, int y) {return null;}
  public boolean setCase(int x, int y, Ressource ress){ return false; }
  public ArrayList<Ressource> lesRessources(){ return null; }
  public boolean sontValides(int x, int y) { return false; }
  public String toString() { return ""; }
  public Ressource videCase(int x, int y) {return null;} 
}
