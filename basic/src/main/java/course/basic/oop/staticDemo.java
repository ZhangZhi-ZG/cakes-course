package course.basic.oop;

public  class staticDemo {

    //static修饰变量--可以直接通过类名.变量名方式调用
    public static String name = "staticDemo";

    //static修饰内部类
    public static class InnerClass{

        public static void foo2() {
            System.out.println("InnerClass.foo2");
        }

        //没有被static修饰，需要实例化才能被调用
        public void foo1(){
            System.out.println("静态类的内部方法");
        }
    }

    //static修饰内部类，可以被静态方法直接调用，不需要实例化为对象
    public static void foo1(){

        System.out.println("staticDemo");
    }


    public static void main(String[] args) {
        staticDemo.InnerClass.foo2();
        //直接通过类名调用，不需要实例化
        System.out.println("staticDemo.name = " + staticDemo.name);
        //直接通过staticDemo类名访问InnerClass
        InnerClass sd = new staticDemo.InnerClass();
        sd.foo1();


    }
}
