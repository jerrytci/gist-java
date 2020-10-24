package com.rejerry.javagist.copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyTest {
    private static final Map<String, List<CopyBean>> copyBeanMap = new HashMap<String, List<CopyBean>>() {{
        List<CopyBean> copyBeans = new ArrayList<>();
        copyBeans.add(new CopyBean("zhouzhouma", "zhouzhou"));
        put("m1", copyBeans);

        List<CopyBean> copyBeansLiked = new ArrayList<>();
        copyBeansLiked.add(new CopyBean("shangmeiyoudiantiao", "shangmei"));
        put("m2", copyBeansLiked);
    }};

    public static void main(String[] args) {
        testStaticFinalCollection();
    }

    /**
     * 测试静态变量
     * 1 静态容器变量本省不可以改变，但是可以改变容器里面的内容。
     * 2 从静态容器变量获取的值是引用类型，使用时注意更改值时会改变容器里面的内容
     */
    private static void testStaticFinalCollection() {
        List<CopyBean> copyBeans = copyBeanMap.get("m1");
        List<CopyBean> likeCopyBeans = copyBeanMap.get("m2");
        copyBeans.add(new CopyBean("zhouzhouma_weibo", "shiqige_zhouzhouma"));
        System.out.println("copyBeans = " + copyBeans.size());

        likeCopyBeans.addAll(copyBeans);
        System.out.println("likeCopyBeans.size() = " + likeCopyBeans.size());

        System.out.println("copyBeanMap = " + copyBeanMap);
        System.out.println("1 = " + 1);

        // can`t compile
        // copyBeanMap = new HashMap<>();

        // can`t compile
        // final Map<String, List<CopyBean>> testMap = new HashMap<>();
        // copyBeanMap = testMap;

        // can`t compile
        // copyBeanMap = testCopyBeanMap;

        // can`t compile
        // copyBeanMap = null;
    }

    private static final Map<String, List<CopyBean>> testCopyBeanMap = new HashMap<>();

}
