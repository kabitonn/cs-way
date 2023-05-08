package com.vika.way.spring.utils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 笛卡尔积工具类
 *
 * @author chenwei.tjw
 * @date 2023/4/21
 **/
public class CartesianUtils {

    public static <T> List<List<T>> cartesianProductForRecursive(List<List<T>> dimensionValue) {
        List<List<T>> result = new LinkedList<>();
        cartesianProduct(dimensionValue, result, 0, new LinkedList<>());
        return result;
    }

    public static <T> List<List<T>> cartesianProduct(List<List<T>> dimensionValue) {
        List<List<T>> result = new LinkedList<>();
        for (List<T> subList : dimensionValue) {
            result = cartesianProductForProduct(result,
                    subList.stream().map(Collections::singletonList).collect(Collectors.toList()));
        }
        return result;
    }

    /**
     * 递归实现
     *
     * @param dimensionValue
     * @param result
     * @param layer
     * @param currentList
     * @param <T>
     */
    private static <T> void cartesianProduct(List<List<T>> dimensionValue, List<List<T>> result, int layer, List<T> currentList) {
        if (layer < dimensionValue.size() - 1) {
            if (dimensionValue.get(layer).isEmpty()) {
                cartesianProduct(dimensionValue, result, layer + 1, currentList);
            } else {
                for (T v : dimensionValue.get(layer)) {
                    List<T> list = new LinkedList<>(currentList);
                    list.add(v);
                    cartesianProduct(dimensionValue, result, layer + 1, list);
                }
            }
        } else if (layer == dimensionValue.size() - 1) {
            if (dimensionValue.get(layer).isEmpty()) {
                result.add(currentList);
            } else {
                for (T v : dimensionValue.get(layer)) {
                    List<T> list = new LinkedList<>(currentList);
                    list.add(v);
                    result.add(list);
                }
            }
        }
    }

    /**
     * @param list1
     * @param subList
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> cartesianProduct(List<List<T>> list1, List<T> subList) {
        if (CollectionUtils.isEmpty(list1) && CollectionUtils.isEmpty(subList)) {
            return Collections.emptyList();
        } else if (CollectionUtils.isEmpty(subList)) {
            return list1;
        }
        if (CollectionUtils.isEmpty(list1)) {
            list1 = Collections.singletonList(Collections.emptyList());
        }
        List<List<T>> result = new LinkedList<>();
        for (List<T> l1 : list1) {
            for (T v2 : subList) {
                List<T> tmp = new LinkedList<>(l1);
                tmp.add(v2);
                result.add(tmp);
            }
        }
        return result;
    }

    /**
     * 笛卡尔积*笛卡尔积
     *
     * @param list1
     * @param list2
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> cartesianProductForProduct(List<List<T>> list1, List<List<T>> list2) {
        if (CollectionUtils.isEmpty(list1) && CollectionUtils.isEmpty(list2)) {
            return Collections.emptyList();
        }
        if (CollectionUtils.isEmpty(list1)) {
            list1 = Collections.singletonList(Collections.emptyList());
        }
        if (CollectionUtils.isEmpty(list2)) {
            list2 = Collections.singletonList(Collections.emptyList());
        }
        List<List<T>> result = new LinkedList<>();
        for (List<T> l1 : list1) {
            for (List<T> l2 : list2) {
                List<T> tmp = new LinkedList<>();
                tmp.addAll(l1);
                tmp.addAll(l2);
                result.add(tmp);
            }
        }
        return result;
    }


}
