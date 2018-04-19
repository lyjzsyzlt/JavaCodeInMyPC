public class VolatileTest {
    public static void main(String[] args) throws InterruptedException {
            MyRunnable mr=new MyRunnable();
            Thread t=new Thread(mr);
            Thread t2=new Thread(new ChangeValue(mr));
            t.start();
           // Thread.sleep(100);
            t2.start();
            t.join();
            t2.join();
            System.out.println(mr.i);
            System.out.println(mr.flag);
    }
}
class MyRunnable implements Runnable{
    boolean running=true;
    int i=0;
    int flag=0;
    public void run(){
        flag=1;
        while (running){
            i++;
        }
    }
}

class ChangeValue implements Runnable{
    private MyRunnable mr;
    public ChangeValue(MyRunnable myRunnable){
        mr=myRunnable;
    }
    @Override
    public void run() {

        mr.flag=2;
        mr.running=false;
    }
}

