import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomLoadClass {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        //类加载
        byte[] classBytes = readClassByte("/Users/pro/Desktop/Helloworld.class");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Method method = Class.forName("java.lang.ClassLoader")
                .getDeclaredMethod("defineClass", byte[].class, int.class, int.class);
        method.setAccessible(true);
        Class clazz = (Class) method.invoke(classLoader, classBytes, 0, classBytes.length);

        //类链接
        method = Class.forName("java.lang.ClassLoader")
                .getDeclaredMethod("resolveClass", Class.class);
        method.setAccessible(true);
        method.invoke(classLoader,clazz);

        //类调用（包含初始化）
        method = clazz.getDeclaredMethod("test");
        method.invoke(clazz.newInstance());
    }

    public static byte[] readClassByte(String filePath) throws IOException {
        FileInputStream inputStream = new FileInputStream(filePath);
        long fileSize = new File(filePath).length();
        byte[] allBytes = new byte[(int) fileSize];
        inputStream.read(allBytes);
        return allBytes;
    }
}
