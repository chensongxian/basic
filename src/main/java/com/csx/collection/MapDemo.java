package com.csx.collection;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-11
 */
public class MapDemo {
    public static void main(String[] args){
        Map<Integer,String> map = new HashMap<Integer,String>();
        method(map);
    }

    public static void method(Map<Integer,String> map){ //学号和姓名
        //添加元素
        System. out.println(map.put(8,"旺财" ));
        System. out.println(map.put(8,"小强" ));
        System. out.println(map);

        map.put(2, "张三");
        map.put(7, "赵六");
        System. out.println(map);

        //删除
        System. out.println("remove:" + map.remove(2));

        //判断
        System. out.println("containsKey:" + map.containsKey(7));

        //获取
        System. out.println("get:" + map.get(7));
    }

    public static void getByKeySet(Map<Integer,String> map){
        map.put(8, "王五");
        map.put(2, "赵六");
        map.put(7, "小强");
        map.put(6, "旺财");

        //取出map中的所有元素。
        //原理，通过keySet方法获取map中所有的键所在的set集合，在通过set的迭代器获取到每一个键。
        //再对每一个键通过map集合的get方法获取其对应的值即可。

        Set<Integer> keySet = map.keySet();
        Iterator<Integer> it = keySet.iterator();

        while(it.hasNext()){
            Integer key = it.next();
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }
    }

    public static void getByEntrySet(Map<Integer,String> map){
        map.put(8, "王五");
        map.put(2, "赵六");
        map.put(7, "小强");
        map.put(6, "旺财");

             /*
            通过Map转成Set就可以迭代。
            找到了另一个方法，entrySet。
            该方法将键和值的映射关系作为对象存储到了Set集合中，而这个映射关系的类型就是Map.Entry类型
            */
        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();

        Iterator<Map.Entry<Integer,String>> it = entrySet.iterator();

        while(it.hasNext()){
            Map.Entry<Integer,String> me = it.next();
            Integer key = me.getKey();
            String value = me.getValue();
            System. out.println(key + ":" + value);
        }
    }


    public static void getValues(Map<Integer,String> map){
        map.put(8, "王五");
        map.put(2, "赵六");
        map.put(7, "小强");
        map.put(6, "旺财");

        Collection<String> values = map.values();

        Iterator<String> it = values.iterator();
        while(it.hasNext()){
            System. out.println(it.next());
        }
    }
}
