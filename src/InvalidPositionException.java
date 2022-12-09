public class InvalidPositionException extends Exception{
  public InvalidPositionException() {}

  public InvalidPositionException(int x, int y){
    super(String.format("Invalid position: x=%d y=%d", x, y));
  }
}
