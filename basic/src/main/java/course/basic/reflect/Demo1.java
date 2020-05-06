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
      System.out.println("constructor.getName() = " + constructor.getName());
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
      System.out.println("field.getName() = " + field.getName());

      System.out.println("field Type Name() = " + field.getType().getName());
    }
  }

  public static void testMethod() {
    Class<User> userClass = User.class;

//    Method[] methods = userClass.getMethods();
    Method[] methods = userClass.getDeclaredMethods();

    for (Method method : methods) {
      System.out.println("method.getName() = " + method.getName());
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
