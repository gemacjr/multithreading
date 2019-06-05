package thread.creation.example;

public class ThreadExample2 {

    public static void main(String[] args) {

        Thread thread = new NewThread();

        thread.start();
    }

    private static class NewThread extends Thread {

        @Override
        public void run(){
            System.out.println("hello from " + this.getName() + "");
        }
    }
}
