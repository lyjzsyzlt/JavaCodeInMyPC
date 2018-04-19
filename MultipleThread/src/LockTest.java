import org.omg.PortableServer.THREAD_POLICY_ID;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {
    public static void main(String[] args) throws InterruptedException {
       // ReentrantLockTest.test();
       // lockInterruptiblyTest.test();
        ReadWriteLock.test();
    }
}

@SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
class  ReentrantLockTest{
    private List<Integer> list=new ArrayList<>();
    private Lock lock=new ReentrantLock();
    public void insert(Thread thread){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"获得了锁");
            for(int i=0;i<5;i++){
                list.add(i);
            }
        }catch (Exception e){

        }finally {
            System.out.println(Thread.currentThread().getName()+"释放了锁");
            lock.unlock();
        }
    }

    public static void test() throws InterruptedException {
        ReentrantLockTest r=new ReentrantLockTest();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                r. insert(Thread.currentThread());
            }
        });

        Thread t2=new  Thread(new Runnable() {
            @Override
            public void run() {
                r.insert(Thread.currentThread());
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        for(int i=0;i<r.list.size();i++){
            System.out.println(r.list.get(i));
        }
    }
}

class lockInterruptiblyTest{
    private Lock lock=new ReentrantLock();

    public void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();
        try{
            System.out.println(Thread.currentThread().getName()+"获得了锁");
            long startTime = System.currentTimeMillis();
            while (true){
                if(System.currentTimeMillis()-startTime>0.1){
                    System.out.println("超时");
                    break;
                }else{
                    //System.out.println("to do something");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("释放了锁");
            lock.unlock();
        }
    }

    public static void  test(){
        lockInterruptiblyTest l=new lockInterruptiblyTest();

        Thread t1=new  Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    l.insert(Thread.currentThread());
                }catch (InterruptedException e){
                    System.out.println(Thread.currentThread().getName()+"被中断");
                }
            }
        });

       Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    l.insert(Thread.currentThread());
                }catch (InterruptedException e){
                    System.out.println(Thread.currentThread().getName()+"被中断");
                }
            }
        });

        Thread t3= new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    l.insert(Thread.currentThread());
                }catch (InterruptedException e){
                    System.out.println(Thread.currentThread().getName()+"被中断");
                }
            }
        });

       t1.start();
       t2.start();
       t3.start();
       t2.interrupt();
       t3.interrupt();

    }
}

class ReadWriteLock{
    private ReentrantReadWriteLock rw=new ReentrantReadWriteLock();
    private int data;

    public void read(Thread thread){
        rw.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"获取了读锁");
        try{
            System.out.println(Thread.currentThread().getName()+"读取"+data);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rw.readLock().unlock();
            System.out.println(Thread.currentThread().getName()+"释放了读锁");
        }
    }

    public void write(Thread thread){
        rw.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+"获取了写锁");
        try{
                data=(int)(Math.random()*100);
                System.out.println(Thread.currentThread().getName()+"写入"+data);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rw.writeLock().unlock();
            System.out.println(Thread.currentThread().getName()+"释放了写锁");
        }
    }
    public static void test(){
        ReadWriteLock rwl=new ReadWriteLock();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                    rwl.read(Thread.currentThread());
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                    rwl.write(Thread.currentThread());
            }
        });

        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                    rwl.read(Thread.currentThread());
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

}
