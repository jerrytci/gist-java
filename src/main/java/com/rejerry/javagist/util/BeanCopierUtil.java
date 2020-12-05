package com.rejerry.javagist.util;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author imyzt
 * @date 2020/01/15
 * @description bean拷贝缓存工具类
 * 合理使用, 注意Map大小
 */
@UtilityClass
@Slf4j
public class BeanCopierUtil {

    private static final Map<String, BeanCopier> BEAN_COPIER_MAP = new ConcurrentHashMap<>();

    /**
     * 使用BeanCopier拷贝对象属性
     * 1. target不能使用链式调用 {@link lombok.experimental.Accessors#chain}
     * 2. 只会拷贝source,target属性类型和名称完全一致的字段
     * @param source 源
     * @param target 目标
     * @param useCache 是否使用缓存
     * @param converter converter对象
     * @param <S> 源对象泛型
     * @param <T> 目标对象泛型
     * @return 返回target对象
     */
    public <S, T> T copy(S source, T target, boolean useCache, Converter converter) {

        requireNonNull(source, target);
        boolean useConverter = Objects.nonNull(converter);

        Class<?> targetClass = target.getClass();

        String key = getKey(source, targetClass);

        BeanCopier beanCopier = getBeanCopier(useCache, key, createBeanCopier(source, targetClass, useConverter));
        beanCopier.copy(source, target, converter);
        return target;
    }

    /**
     * 使用BeanCopier拷贝对象属性
     * 1. target不能使用链式调用 {@link lombok.experimental.Accessors#chain}
     * 2. 只会拷贝source,target属性类型和名称完全一致的字段
     * @param source 源
     * @param targetClass 目标类对象
     * @param useCache 是否使用缓存
     * @param converter converter对象
     * @param <S> 源对象泛型
     * @param <T> 目标对象泛型
     * @return 返回target对象
     */
    public <S, T> T copy(S source, Class<T> targetClass, boolean useCache, Converter converter) {

        requireNonNull(source, targetClass);
        boolean useConverter = Objects.nonNull(converter);

        String key = getKey(source, targetClass);

        BeanCopier beanCopier = getBeanCopier(useCache, key, createBeanCopier(source, targetClass, useConverter));

        T instance;
        try {
            instance = targetClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new IllegalArgumentException();
        }
        beanCopier.copy(source, instance, converter);
        return instance;
    }

    private static BeanCopier getBeanCopier(boolean useCache, String key, BeanCopier beanCopier2) {
        BeanCopier beanCopier;
        if (useCache) {
            beanCopier = BEAN_COPIER_MAP.computeIfAbsent(key, k -> beanCopier2);
        } else {
            beanCopier = beanCopier2;
        }
        return beanCopier;
    }

    private static <S> void requireNonNull(S source, Object targetClass) {
        Objects.requireNonNull(source, "源对象不能为空");
        Objects.requireNonNull(targetClass, "目标对象不能为空");
    }

    public <S, T> T copy(S source, T target) {
        return copy(source, target, true, null);
    }

    public <S, T> T copy(S source, Class<T> targetClass) {
        return copy(source, targetClass, true, null);
    }

    public <S, T> T copy(S source, Class<T> targetClass, boolean useCache) {
        return copy(source, targetClass, useCache, null);
    }

    public <S, T> T copy(S source, Class<T> targetClass, Converter converter) {
        return copy(source, targetClass, true, converter);
    }

    public <S, T> T copy(S source, T target, boolean useCache) {
        return copy(source, target, useCache, null);
    }

    public <S, T> T copy(S source, T target, Converter converter) {
        return copy(source, target, true, converter);
    }

    private static <S, T> BeanCopier createBeanCopier(S source, Class<T> target, boolean useConverter) {
        return BeanCopier.create(source.getClass(), target, useConverter);
    }

    private static <S, T> String getKey(S source, Class<T> targetClass) {
        return source.getClass().getName() + ":" + targetClass.getName();
    }
}