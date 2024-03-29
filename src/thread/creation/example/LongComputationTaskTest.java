package thread.creation.example;

import java.math.BigInteger;

public class LongComputationTaskTest {

    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new LongComputationTask(new BigInteger("20000"), new BigInteger("1000000")));


        thread.setDaemon(true);
        thread.start();
        Thread.sleep(100);
        thread.interrupt();

    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;


        public LongComputationTask(BigInteger base, BigInteger power){
            this.base = base;
            this.power = power;
        }

        @Override
        public void run(){
            System.out.println(base+"^"+power+" = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power){
            BigInteger result = BigInteger.ONE;

            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) !=0; i = i.add(BigInteger.ONE)){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("Prematurally interuppted computation");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }
            return result;
        }

    }

}
