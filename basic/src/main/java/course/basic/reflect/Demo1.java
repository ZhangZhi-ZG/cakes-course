package course.basic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author haoc
 */
public class Demo1 {

  public static void main(String[] args) {
//    testMethod();

//    testField();

    testConstructor();
  }

  public static void testConstructor() {

    Class<User> userClass = User.class;

    Constructor<?>[] constructors = userClass.getConstructors();
    for (Constructor<?> constructor : constructors) {
      //获取构造方法的名称
      System.out.println("constructor.getName() = " + constructor.getName());
      //获取构造方法的入参数据类型
      Class<?>[] parameterTypes = constructor.getParameterTypes();

      System.out.print("param list=");
      for (Class<?> type : parameterTypes) {
        System.out.print(type.getName() + ",");
      }
      System.out.println();
    }
  }

  public static void testField() {
    Class<User> userClass = User.class;
//    Field[] fields = userClass.getFields();
    Field[] fields = userClass.getDeclaredFields();
    for (Field field : fields) {
      //获取类属性变量名称
      System.out.println("field.getName() = " + field.getName());
      //获取属性变量的数据类型
      System.out.println("field Type Name() = " + field.getType().getName());
    }
  }

  public static void testMethod() {
    Class<User> userClass = User.class;

//    Method[] methods = userClass.getMethods();
    Method[] methods = userClass.getDeclaredMethods();

    for (Method method : methods) {
      //获取方法的名称
      System.out.println("method.getName() = " + method.getName());
      //获取方法的异常类型
      Class<?>[] types = method.getExceptionTypes();
      for (Class<?> type : types) {
        System.out.println("ex type=" + type);
      }

      // 描述方法的权限的，private, public, protected, static, final
      int modifiers = method.getModifiers();
      boolean isPub = Modifier.isPublic(modifiers);

      int parameterCount = method.getParameterCount();
      System.out.println("parameterCount = " + parameterCount);

      System.out.println("===========\n");
    }
  }

}
