package pl.sda.java.web.employee.service;

public class Lambda {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Work());
        t1.start();

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Executing t2");
            }
        });
        t2.run();

        Thread t3 = new Thread(() -> System.out.println("Executing t3"));
        t3.start();
    }
}

class Work implements Runnable{

    @Override
    public void run() {
        System.out.println("Work is executed");
    }
}


