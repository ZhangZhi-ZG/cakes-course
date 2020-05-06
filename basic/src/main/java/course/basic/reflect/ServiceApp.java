package course.basic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author haoc
 */
public class ServiceApp {

//  public static void main(String[] args) {
//    User2 user = new User2();
//    user.setName1("1");
//    user.setName2("1");
//    user.setName3("3");
//
//    String ret = new Service().createUser(user);
//  }

  /**
   * <bean id="" class="xxx.xxx.ServiceImpl"></>
   *
   * @param args
   * @throws ClassNotFoundException
   */

  public static void main(String[] args) throws ClassNotFoundException {
    String serviceName = "course.basic.reflect.Service#createUser";
    // 1.拆分，以# 拆，arr[0] = course.basic.reflect.Service, arr[1]=createUser
    // 2.arr[0] = course.basic.reflect.Service, 去找到它的类对象
    Class<?> clazz = Class.forName("course.basic.reflect.Service");
    // 3.基于clazz, 找到方法
    Method[] methods = clazz.getMethods();
    for (Method method : methods) {
      if (method.getName().equals("createUser")) {
        Class<?>[] types = method.getParameterTypes();
        Class<?> type = types[0];
//        System.out.println("type.getName() = " + type.getName());
        // 4.拿到方法的属性，然后拼接成代码
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
          System.out.println("field.getName() = " + field.getName());
          // 5.拿到了 属性名，接下来就做如下的 字符串拼接，
          // name1 -> user.setName1("");
        }
      }
    }
  }

}
