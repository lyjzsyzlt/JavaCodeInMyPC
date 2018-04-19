/**
 * @Author: YongjieLv
 * @Description: 龟兔赛跑总共20米，兔子每秒0.5米，乌龟每秒0.1米，兔子每跑2米休息10秒
 *               其中一个跑到终点后另一个则停止

 * @Date: Create in 18:06 2018/4/12
 * @Modified By:
 */
public class RabbitTurtle {
    private float all=20.0f; // 总共20米
    private float rabbitVelocity=0.5f; // 兔子的速度
    private float turtlrVelocity=0.1f; // 乌龟的速度
    private float s1=0.0f; // 兔子已经跑得长度
    private float s2=0.0f; // 乌龟已经跑得长度
    volatile boolean  flag=true;
    volatile long currentTime1=0;
    long currentTime2=0;
    
    public void rabbit(){
        /**
         * @Author: Yongjie LV
         * @Date: 9:51 2018/4/19
         * @param : 
         * @Return: void
         * @Description:
         */
                s1+=0.5;
                currentTime1+=1;
                System.out.println("第"+currentTime1+"秒，兔子走了"+s1);

                if(all-s1<0.0000000001){
                    flag=false;
                    System.out.println("兔子已经到达终点");
                if(s1%2==0){
                    currentTime1+=10;
                }
            }
}

    public void turtle(){
                s2=(float)0.1*currentTime1;
                currentTime2++;
                System.out.println("第"+currentTime1+"秒，乌龟走了"+s2);
                if(all-s2<0.0000000001){
                    flag=false;
                    System.out.println("乌龟已经到达终点");
                }
    }

    public static void main(String[] args) {
        RabbitTurtle r=new RabbitTurtle();
       new Thread(new Runnable() {
            @Override
            public void run() {
                while(r.flag) {
                    r.rabbit();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(r.flag) {
                    r.turtle();
                }
            }
        }).start();
    }
}
