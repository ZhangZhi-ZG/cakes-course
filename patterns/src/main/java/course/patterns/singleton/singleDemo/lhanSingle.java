package course.patterns.singleton.singleDemo;

/**
 * @author zzhg
 * @date 2020-05-31
 */
public class lhanSingle {

    private  volatile static  lhanSingle INSTANCE;

    private lhanSingle() {
    }

    public static lhanSingle getInstance(){
        System.out.println(Thread.currentThread().getName()+"lhanSingle.getInstance");
        System.out.println(Thread.currentThread().getName()+"start INSTANCE = " + INSTANCE);
        if (INSTANCE == null){
            System.out.println(Thread.currentThread().getName()+"first INSTANCE = " + INSTANCE);
            synchronized (lhanSingle.class){
                System.out.println(Thread.currentThread().getName()+" next INSTANCE = " + INSTANCE);
                if (INSTANCE ==null){
                    INSTANCE = new lhanSingle();
                    System.out.println(Thread.currentThread().getName()+" get INSTANCE = " + INSTANCE);
                }
            }
        }

        return INSTANCE;
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(()->lhanSingle.getInstance());
        Thread t2 = new Thread(()->lhanSingle.getInstance());
        Thread t3 = new Thread(()->lhanSingle.getInstance());
        Thread t4 = new Thread(()->lhanSingle.getInstance());
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }




}
