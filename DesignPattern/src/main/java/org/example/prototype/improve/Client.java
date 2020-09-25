package org.example.prototype.improve;

/**
 * @Title: 克隆羊
 * @Author: cmy
 * @Date: 2020/9/26 0:14
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("使用原型模式完成对象的创建");
        Sheep sheep = new Sheep("tom", 1, "白色");
        sheep.friend = new Sheep("jack", 2, "黑色");
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        Sheep sheep4 = (Sheep) sheep.clone();
        Sheep sheep5 = (Sheep) sheep.clone();
        sheep.friend.setColor("灰色");

        System.out.println(sheep);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
        System.out.println(sheep5);

        // 浅拷贝
        System.out.println("sheep.friend = " + sheep.friend + ":" + sheep.friend.hashCode());
        System.out.println("sheep2.friend = " + sheep2.friend + ":" + sheep2.friend.hashCode());
        System.out.println("sheep3.friend = " + sheep3.friend + ":" + sheep3.friend.hashCode());
        System.out.println("sheep4.friend = " + sheep4.friend + ":" + sheep4.friend.hashCode());
        System.out.println("sheep5.friend = " + sheep5.friend + ":" + sheep5.friend.hashCode());
    }
}
