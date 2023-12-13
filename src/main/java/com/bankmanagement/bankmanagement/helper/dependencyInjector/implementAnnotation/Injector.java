package com.bankmanagement.bankmanagement.helper.dependencyInjector.implementAnnotation;

import com.bankmanagement.bankmanagement.App;
import com.bankmanagement.bankmanagement.helper.dependencyInjector.annotation.Inject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Injector {
    public static void performInjection(){
        performInjection(null);
    }

    public static void performInjection(Object context/*, Properties properties*/) {
        List<Class<?>> annotatedClasses = scanForAnnotatedClasses();

        for (Class<?> clazz : annotatedClasses) {
            try {
                Object instance;
                if (context != null) {
                    instance = clazz.getDeclaredConstructor(Object.class).newInstance(context);
                } else {
                    instance = clazz.getDeclaredConstructor().newInstance();
                }
                injectFields(instance);
                injectConstructor(instance);
                injectMethods(instance);
//                injectInterface(instance);
                injectSetters(instance);
//                injectConfigurations(instance, properties);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Class<?>> scanForAnnotatedClasses() {
        List<Class<?>> annotatedClasses = new ArrayList<>();

        // Replace "your.package" with the package where you want to scan for annotated classes
        String packageName = App.class.getPackage().getName();
        List<Class<?>> classes = getClassesInPackage(packageName);

        for (Class<?> clazz : classes) {
            Annotation[] annotations = clazz.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == Inject.class) {
                    annotatedClasses.add(clazz);
                    break;
                }
            }
        }

        return annotatedClasses;
    }

    // Helper method to get all classes in a package using reflection
    private static List<Class<?>> getClassesInPackage(String packageName) {
        List<Class<?>> classes = new ArrayList<>();

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String path = packageName.replace('.', '/');
            Enumeration<URL> resources = classLoader.getResources(path);

            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                java.io.File directory = new java.io.File(resource.getFile());

                if (directory.exists()) {
                    java.io.File[] files = directory.listFiles();
                    if (files != null) {
                        for (java.io.File file : files) {
                            if (file.isFile() && file.getName().endsWith(".class")) {
                                String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                                try {
                                    Class<?> clazz = Class.forName(className);
                                    classes.add(clazz);
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return classes;
    }

    private static void injectFields(Object instance) {
        Class<?> clazz = instance.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                try {
                    field.setAccessible(true);
                    Class<?> dependencyType = field.getType();
                    Object dependencyInstance = dependencyType.getDeclaredConstructor().newInstance();
                    field.set(instance, dependencyInstance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void injectConstructor(Object instance) {
        Class<?> clazz = instance.getClass();
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            if (constructor.isAnnotationPresent(Inject.class)) {
                try {
                    constructor.setAccessible(true);
                    Class<?>[] parameterTypes = constructor.getParameterTypes();
                    Object[] dependencyInstances = new Object[parameterTypes.length];

                    for (int i = 0; i < parameterTypes.length; i++) {
                        dependencyInstances[i] = parameterTypes[i].getDeclaredConstructor().newInstance();
                    }

                    Object newInstance = constructor.newInstance(dependencyInstances);
                    instance = newInstance;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void injectMethods(Object instance) {
        Class<?> clazz = instance.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Inject.class)) {
                try {
                    method.setAccessible(true);
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    Object[] dependencyInstances = new Object[parameterTypes.length];

                    for (int i = 0; i < parameterTypes.length; i++) {
                        dependencyInstances[i] = parameterTypes[i].getDeclaredConstructor().newInstance();
                    }

                    method.invoke(instance, dependencyInstances);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    private static void injectInterface(Object instance) {
//        Class<?> clazz = instance.getClass();
//        Class<?>[] interfaces = clazz.getInterfaces();
//
//        for (Class<?> iface : interfaces) {
//            if (iface.isAnnotationPresent(Inject.class)) {
//                try {
//                    Object interfaceInstance = iface.getDeclaredConstructor().newInstance();
//                    if (instance instanceof InterfaceInjector) {
//                        ((InterfaceInjector) instance).setInterface(interfaceInstance);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    private static void injectSetters(Object instance) {
        Class<?> clazz = instance.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (isSetterMethod(method) && method.isAnnotationPresent(Inject.class)) {
                try {
                    method.setAccessible(true);
                    Class<?> parameterType = method.getParameterTypes()[0];
                    Object dependencyInstance = parameterType.getDeclaredConstructor().newInstance();
                    method.invoke(instance, dependencyInstance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    private static void injectConfigurations(Object instance, Properties properties) {
//        Class<?> clazz = instance.getClass();
//        Field[] fields= clazz.getDeclaredFields();
//
//        for (Field field : fields) {
//            if (field.isAnnotationPresent(Configuration.class)) {
//                try {
//                    field.setAccessible(true);
//                    String propertyName = field.getAnnotation(Configuration.class).value();
//                    String propertyValue = properties.getProperty(propertyName);
//                    if (propertyValue != null) {
//                        Class<?> fieldType = field.getType();
//                        Object convertedValue = convertValue(propertyValue, fieldType);
//                        field.set(instance, convertedValue);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    private static boolean isSetterMethod(Method method) {
        String methodName = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();

        // Check if the method starts with "set" and has a single parameter
        return methodName.startsWith("set") && parameterTypes.length == 1;
    }

//    private static Object convertValue(String value, Class<?> targetType) {
//        // Implement your value conversion logic based on the target type
//        // This can include parsing strings to primitive types or using external libraries
//        // For simplicity, let's assume we only handle String and Integer conversions
//
//        if (targetType == String.class) {
//            return value;
//        } else if (targetType == Integer.class || targetType == int.class) {
//            return Integer.parseInt(value);
//        } else {
//            throw new UnsupportedOperationException("Unsupported conversion for type: " + targetType);
//        }
//    }
}