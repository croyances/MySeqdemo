package com.example.demo.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author caiwenhai
 * @version 1.0
 * @date 2020/12/8 15:36
 */
public class MyListImpl<E> implements MyList<E> {

    private E[] a;

    volatile private int size; //容器中数据的个数

    @Override
    public void add(E o) {
        //备份原数组
        E[] temp=a;
        //1.先给数组扩容

        a = create(o.getClass(),size+1);
        //2.把value赋值到新数组中
        a[size]= o;
        //3.原数组中数据进行拷贝
        for(int i=0;i<size;i++){
            a[i]=temp[i];
        }
        //4.长度改变+1
        size++;

    }

    @Override
    public int size(E o) {
        return size;
    }

    public E[] create(Class type,int size) {
        return (E[]) Array.newInstance(type, size);
    }

    @Override
    public int t(student e) {
        e.setAge(12);
        return 1;
    }

    public static void main(String[] args) {
        Integer aa = 1;
        Integer b = 2;
        Integer c = 1;
        Integer d = 2;

        MyListImpl m = new MyListImpl();
        m.add(aa);
        m.add(b);
        m.add(c);
        m.add(d);
        System.out.println(aa==c);
        System.out.println(m.a[1]==m.a[3]);
        System.out.println(m.a[1].equals(m.a[3]));
        MyListImpl m2 = new MyListImpl();
        m2.add("SDASD");
        m2.add("1211");

        MyListImpl m3 = new MyListImpl();
        m3.add(new student("AS",12));
        m3.add(new student("AS21",213));
        m3.add(new student("AS21",213));

        student as21 = new student("AS21", 213);
        m3.t(as21);
        System.out.println(as21);

        List<student> students = new ArrayList<>();
        students.add(new student("AS", 12));
        students.add(new student("BS", 32));
        students.add(new student("AS", 22));
        students.add(new student("AS", 32));
        students.add(new student("BS", 22));
        students.stream().sorted(Comparator.comparing(student::getAge).thenComparing(student::getName)).collect(Collectors.toList())
                .forEach(System.out::println);



        System.out.println(m.size);
        System.out.println(m2.size);
        System.out.println(m3.size);
        MyListImpl q = new MyListImpl();
        Thread a = new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                q.add(i);
            }
        });

        new Thread(()->{
            while (true){
                if (q.size==5){
                    a.stop();
                    System.out.println("元素个数已到5");
                    System.out.println(m.size);
                    System.out.println(m2.size);
                    System.out.println(m3.size);
                    System.out.println(q.size);
                    break;
                }
            }
        }).start();
        a.start();
    }


    static class student{
        private String name;
        private Integer age;

        public student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
