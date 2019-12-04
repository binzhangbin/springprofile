package cn.bin.zhang.inverse;

import cn.bin.zhang.ioc.MoAttack;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public class IOCInverse {
    private InputStream inputStream = ClassLoader.getSystemResourceAsStream("beans.xml");
    private  SAXReader saxReader = new SAXReader();
    //xml解析setter注入
    @SuppressWarnings({"unchecked","unused"})
    private Object parseXMLBySetter() throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
         Document document = saxReader.read(inputStream);
         Element root = document.getRootElement();
        Object retObj=null;
        //String rootName = root.getName();
//        System.out.println(rootName);
        List<Element> elements = root.elements();
        Map<String, Object> beanMap = new HashMap<>();
        for (Element element : elements) {
            if ("bean".equals(element.getName())) {
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                Class<?> aClass = Class.forName(className);
                Object object = aClass.newInstance();
                beanMap.put(id, object);
                Iterator<Element> iterator = element.elementIterator();
                while (iterator.hasNext()) {
                    Element nextElement = iterator.next();
                    String propertyName = "property";
                    if (propertyName.equals(nextElement.getName())) {
                        String propertyname = nextElement.attributeValue("name");
                        String propertyValue = nextElement.attributeValue("ref");
                        Set<String> strings = beanMap.keySet();
                        for (String keyName : strings) {
                            if (keyName.equals(propertyValue)) {
                                //setter
                                String methodName = "set" + propertyname.toUpperCase().charAt(0) + propertyname.substring(1);
                                Method setterMethod = aClass.getMethod(methodName,beanMap.get(propertyValue).getClass().getInterfaces()[0]);
                                setterMethod.invoke(object, beanMap.get(keyName));

                                //getter
                                String methodName1 = "get" + propertyname.toUpperCase().charAt(0) + propertyname.substring(1);
                                Method getMethod = aClass.getMethod(methodName1);
                                getMethod.invoke(object);
                                retObj=object;
                            }
                        }
                    }
                }
            }
        }
        return retObj;
    }

    //xml解析构造注入
    @SuppressWarnings("unchecked")
    private Object parseXMLByConstructor() throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Document document = saxReader.read(inputStream);
        Element root = document.getRootElement();
        List<Element> elements = root.elements();
        Map<String, Object> beanMap = new HashMap<>();
        Object retObj=null;
        for (Element element : elements) {
            if ("bean".equals(element.getName())) {
                String className = element.attributeValue("class");
                String id = element.attributeValue("id");
                Class<?> aClass = Class.forName(className);
                Object object = aClass.newInstance();
                beanMap.put(id, object);
                Iterator<Element> iterator = element.elementIterator();
                while (iterator.hasNext()) {
                    Element nextElement = iterator.next();
                    String propertyName = "constructor-arg";
                    if (propertyName.equals(nextElement.getName())) {
                        String propertyValue = nextElement.attributeValue("ref");
                        Set<String> strings = beanMap.keySet();
                        for (String keyName : strings) {
                            if (keyName.equals(propertyValue)) {
                                Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(beanMap.get(propertyValue).getClass().getInterfaces()[0]);
                                declaredConstructor.setAccessible(true);
                                retObj=declaredConstructor.newInstance(beanMap.get(propertyValue));
                            }
                        }
                    }
                }
            }
        }
        return retObj;
    }

    public static void main(String[] args) {
        try {
//            MoAttack setterObj =(MoAttack)new IOCInverse().parseXMLBySetter();
//            setterObj.cityGateAsk();


            MoAttack setterObj =(MoAttack)new IOCInverse().parseXMLByConstructor();
            setterObj.cityGateAsk();
        } catch (DocumentException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
