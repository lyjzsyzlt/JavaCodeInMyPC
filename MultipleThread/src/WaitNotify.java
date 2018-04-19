public class WaitNotify {
    private boolean isAWaiting;
    private boolean isBWaiting;
    private boolean isCWaiting;

    public WaitNotify(){
        isAWaiting=true;
        isBWaiting=true;
        isCWaiting=true;
    }

    private byte[] bytes=new byte[0];

    public void startA(){
        synchronized (bytes){
            System.out.println("线程A正在等待...");
            try {
                while (true) {
                    if (!isAWaiting)
                        break;
                    bytes.wait();
                }
                System.out.println("A循环结束");
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程A结束");
            wakenB();
            System.out.println("B="+isBWaiting);
        }
    }

    public void startB(){
        synchronized (bytes){
            System.out.println("线程B正在等待...");
            try{
                while (true){
                    if(!isBWaiting)
                        break;
                    bytes.wait();
                }
                System.out.println("B循环结束");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("线程B结束");
            wakenC();
            System.out.println("C="+isCWaiting);
        }
    }

    public void startC(){
        synchronized (bytes){
            System.out.println("线程C正在等待...");
            try{
                while (true){
                    if(!isCWaiting)
                        break;
                    bytes.wait();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("线程C结束");
        }
    }


    public void startWaken(){
        synchronized (bytes){
            System.out.println("唤醒开始..");
            wakenA();
        }
    }

    public void wakenA(){
        isAWaiting=false;
        bytes.notify();
    }

    public void wakenB(){
        isBWaiting=false;
        bytes.notify();
    }
    public void wakenC(){
        isCWaiting=false;
        bytes.notify();
    }


    public static void main(String[] args) {
        WaitNotify w=new WaitNotify();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                w.startA();
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                w.startB();
            }
        });

        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                w.startC();
            }
        });

        Thread t4=new Thread(new Runnable() {
            @Override
            public void run() {
                w.startWaken();
            }
        });
         t2.start();

        t1.start();

        t3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t4.start();
    }
}






