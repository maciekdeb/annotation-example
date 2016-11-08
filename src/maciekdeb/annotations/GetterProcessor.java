package maciekdeb.annotations;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class GetterProcessor {

    public static void process(Class target) {
        for (Field field : target.getFields()) {
            if (field.isAnnotationPresent(Getter.class)) {
                final Constructor constructor = findSingleArgumentConstructor(field.getGenericType());
                if (constructor != null) {
                    System.out.println(String.format("return %s(%s);", constructor.getName(), "list"));
                }
            }
        }
    }

    private static Constructor findSingleArgumentConstructor(Type gettersType) {
        final Class getterClass = ((ParameterizedTypeImpl) gettersType).getRawType();
        final Constructor<?>[] constructors = getterClass.getConstructors();

        for (Constructor constructor : constructors) {
            if (constructor.getParameterCount() == 1) {
                final Class[] parameterTypes = constructor.getParameterTypes();
                for (Class c : parameterTypes) {
                    if (c.isAssignableFrom(getterClass)) {
                        return constructor;
                    }
                }
            }
        }

        return null;
    }
}