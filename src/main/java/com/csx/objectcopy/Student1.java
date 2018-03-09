package com.csx.objectcopy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/03/09
 */
public class Student1 implements Cloneable{
    // 对象引用
    private Subject subj;

    private String name;

    public Student1(String s, String sub) {
        name = s;
        subj = new Subject(sub);
    }

    public Subject getSubj() {
        return subj;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    /**
     * 重写clone方法
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //深拷贝
        Student1 s = new Student1(name, subj.getName());
        return s;
    }
}
