package com.rejerry.javagist.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*list 3种遍历方式和速度测试*/
/*速度: for > iterator > foreach*/
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //添加数据
        long storeStart1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long storeEnd1 = System.currentTimeMillis();
        long d = storeEnd1 - storeStart1;
        System.out.println("添加数据的时间：" + d);

        //遍历方式1---while(it.hasNext())
        System.out.println("遍历方式1--while(it.hasNext())");
        long storeStart2 = System.currentTimeMillis();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == 9999) System.out.println("选择结果是9999");
        }
        long storeEnd2 = System.currentTimeMillis();
        System.out.println(storeEnd2 - storeStart2);

        //遍历方式2--get(i)
        System.out.println("遍历方式2--get(i)");
        long storeStart3 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 9999) System.out.println("选择结果是9999");
        }
        long storeEnd3 = System.currentTimeMillis();
        System.out.println(storeEnd3 - storeStart3);

        //遍历方式3--for(Integer i)
        System.out.println("遍历方式3--Object o");
        long storeStart4 = System.currentTimeMillis();
        for (Integer i : list) {
            if (i == 9999) System.out.println("选择结果是9999");
        }
        long storeEnd4 = System.currentTimeMillis();
        System.out.println(storeEnd4 - storeStart4);
    }
}
