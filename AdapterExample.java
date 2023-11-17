public class AdapterExample {
  public static void main(String args []) {
    Printable p = new TextFile();
    p.print(5);
    // TODO: do the same with a PDFFile
    p = new PDFFile();
    p.print(5);
  }
}

class PDFFile implements Printable {
  private LibPDFFile adaptee;
  public PDFFile() {
    adaptee = new LibPDFFile();
  }
  @Override
  public void print(int size) {
    adaptee.stampa(size*2);
  }
}

class PDFFile1 extends LibPDFFile implements Printable {
  @Override
  public void print(int size) {
    stampa(size*2);
  }
}

interface Printable {
  // Print with the given font size
  // Size from 0 to 10
  public void print(int size);
}

class TextFile implements Printable {
  @Override
  public void print(int size) {
    // Code to print ...
  }
}

// Class to manage PDF files (from an external library)
class LibPDFFile { 
  // Print the PDF file with the given size
  // Size from 0 to 20
  public void stampa(int size) {
    // ....
  }
}

