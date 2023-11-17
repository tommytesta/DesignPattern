import java.io.IOException;

public class SingletonApp {
  public static void main(String[] args) throws Exception {
    Preferences.getPrefs().loadFromFile("myprefs.txt");
    int x = Preferences.getPrefs().getScreenX();
    Preferences.getPrefs().setScreenY(1024);
  }
}

class Preferences {
  private String userID;
  private int screenX, screenY;
  private static Preferences myprefs = null;

  private Preferences() {
    userID = null;
    screenX = 1920;
    screenY = 1080;
  }
  // Problema di concorrenza la cui soluzione vedremo più avanti
  public static Preferences getPrefs() {
    if (myprefs == null) myprefs = new Preferences();
    return myprefs;
  }
  public String getUserID() { return userID; }
  public void setUserID(String userID) { this.userID = userID; }
  public int getScreenX() { return screenX; }
  public void setScreenX(int screenX) { this.screenX = screenX; }
  public int getScreenY() { return screenY; }
  public void setScreenY(int screenY) { this.screenY = screenY; }
  public void loadFromFile(String fileName) throws IOException {
    // ....
  }
  public void saveToFile(String fileName) throws IOException {
    // ....
  }
}
