public class PrintingEvenOddThread {

  public static void main(String[] args) {
    OddEvenNumberPrinter printer = new OddEvenNumberPrinter(10);
    Thread oddThread = new Thread(new Runnable() {
      @Override
      public void run() {
        printer.printOddNumber();
      }
    });
    Thread evenThread = new Thread(new Runnable() {
      @Override
      public void run() {
        printer.printEvenNumber();
      }
    });
    oddThread.start();
    evenThread.start();

    try {
      System.out.println("Joining :");
      oddThread.join();
      evenThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class OddEvenNumberPrinter {
  int number = 0;
  boolean isOdd = true;
  int count = 20;

  OddEvenNumberPrinter(int count) {
    this.count = count;
  }

  void printOddNumber() {
    synchronized (this) {
      while (number < count) {
        while (!isOdd) {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println("Odd :" + number);
        number++;
        isOdd = false;
        notifyAll();
      }
    }
  }

  void printEvenNumber() {
    synchronized (this) {
    while (number < count) {
      while (isOdd) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println("Even :" + number);
      number++;
      isOdd = true;
      notifyAll();
    }}
  }
}
