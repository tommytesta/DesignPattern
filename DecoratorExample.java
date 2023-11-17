public class DecoratorExample {
    public static void main(String[] args) {
        MessagePrinter messagePrinter = new StandardMessagePrinter();
        messagePrinter.print("Hello");
        // Vorrei costruire
        // 1. Un DoubleMessagePrinter che stampa il messaggio due volte
        // 2. Un CapitalMessagePrinter che stampa il messaggio tutto maiuscolo
        // Vorrei avere tutte le possibili combinazioni
        // (solo doppio, solo maiuscolo, doppio e maiuscolo, ...)
        MessagePrinter dmPrinter =
          new DoubleMessagePrinter(messagePrinter);
        dmPrinter.print("Ciao");
        MessagePrinter cmPrinter =
          new CapitalMessagePrinter(messagePrinter);
        cmPrinter.print("Ciao");
        MessagePrinter dcmPrinter =
          new CapitalMessagePrinter(dmPrinter);
        dcmPrinter.print("Ciao");
    }
}

interface MessagePrinter {
  public void print(String message) ;
}

class DoubleMessagePrinter implements MessagePrinter {
  private MessagePrinter p;
  public DoubleMessagePrinter(MessagePrinter toBeDecorated) {
    p = toBeDecorated;
  }
  @Override
  public void print(String message) {
    p.print(message);
    p.print(message);
  }
}

class CapitalMessagePrinter implements MessagePrinter {
  private MessagePrinter p;
  public CapitalMessagePrinter(MessagePrinter toBeDecorated) {
    p = toBeDecorated;
  }
  @Override
  public void print(String message) {
    p.print(message.toUpperCase());
  }
}

class StandardMessagePrinter implements MessagePrinter {
  public void print(String message) {
    System.out.println(message);
  }
}
