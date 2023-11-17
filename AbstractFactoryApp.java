public class AbstractFactoryApp {
  // Change visibility if needed
  private Menu menu;
  private Window window;
  // Possibly other graphical elements like buttons...
  
  // TODO: change signature appropriately
  public void initApp(WidgetFactory wf) {
    // TODO: Initializes the menu and the window with certain style
    menu = wf.createMenu();
    window = wf.createWindow();
  }
  
  public void useWindow() {
    // Does something with window
  }
  
  public void useMenu() {
    // Does something with menu
  }

  public static void main(String[] args) {
    AbstractFactoryApp app = new AbstractFactoryApp();
    app.initApp(new DarkWidgetFactory());
    app.initApp(new LightWidgetFactory());
  }
}

interface WidgetFactory {
  public Menu createMenu() ;
  public Window createWindow();
}

class DarkWidgetFactory implements WidgetFactory {
  @Override
  public Menu createMenu() {
    return new DarkMenu();
  }
  @Override
  public Window createWindow() {
    return new DarkWindow();
  }
}

class LightWidgetFactory implements WidgetFactory {
  @Override
  public Menu createMenu() {
    return new LightMenu();
  }
  @Override
  public Window createWindow() {
    return new LightWindow();
  }
}

class Window {
}

class DarkWindow extends Window {
}

class LightWindow extends Window {
}

class Menu {
}

class DarkMenu extends Menu {
}

class LightMenu extends Menu {
}
