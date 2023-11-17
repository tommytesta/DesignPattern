import java.util.*;

public class FactoryMethodExample {
  public static void main(String args[]) {
    List<Student> stud = new ArrayList<Student>();
    stud.add(new PreparedStudent());
    stud.add(new LetsTryItAnywayStudent());
    stud.add(new PreparedStudent());
    for(Student s : stud) {
      int mark = s.deliverExam().getMark();
      System.out.println("You got "+mark);
    }
  }
}

abstract class Student {
  // TODO!
  protected abstract Exam createExam();
  
  public final Exam deliverExam() {
    Exam exam = null;
    // Create exam (depending on the type of student)
    exam = createExam();
    // ... Do something with exam ...
    exam.fill();
    // Return the exam for evaluation
    return exam;
  }
}

class LetsTryItAnywayStudent extends Student {
  @Override
  protected Exam createExam() {
    return new InsufficientExam();
  }
}

class PreparedStudent extends Student {
  @Override
  protected Exam createExam() {
    return new SufficientExam();
  }
}

abstract class Exam {
  protected int mark;
  public int getMark() { return mark; }
  public abstract void fill() ;
}

class SufficientExam extends Exam {
  @Override
  public void fill() { mark = 24; }
}

class InsufficientExam extends Exam {
  @Override
  public void fill() { mark = 12; }
}

