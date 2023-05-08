package com.vika.way.spring.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


/**
 * @author chenwei.tjw
 * @date 2023/4/21
 **/
public class CartesianUtilsTest {

    @Test
    public void testCartesianProductForRecursive() throws Exception {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList());
        list.add(Arrays.asList("A", "B"));
        list.add(Arrays.asList("1", "2"));
        list.add(Arrays.asList("a", "b", "c"));
        list.add(Arrays.asList());
        List<List<String>> result = CartesianUtils.cartesianProductForRecursive(list);
        System.out.println(result);
    }

    @Test
    public void testCartesianProduct() throws Exception {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("A", "B"));
        list.add(Arrays.asList("1", "2"));
        List<List<String>> result = CartesianUtils.cartesianProduct(list);
        System.out.println(result);
    }

    @Test
    public void testCartesianProduct1() throws Exception {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("A", "B"));
        list.add(Arrays.asList());
        List<List<String>> result = CartesianUtils.cartesianProduct(list);
        System.out.println(result);
    }

    @Test
    public void testCartesianProduct2() throws Exception {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("A", "B"));
        list.add(Arrays.asList("1", "2"));
        List<List<String>> result = CartesianUtils.cartesianProduct(list);
        System.out.println(result);
    }

    @Test
    public void testCartesianProduct3() throws Exception {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList());
        list.add(Arrays.asList());
        List<List<String>> result = CartesianUtils.cartesianProduct(list);
        System.out.println(result);
    }

    @Test
    public void testCartesianProductForSet1() throws Exception {
        List<Set<String>> list = new ArrayList<>();
        list.add(Sets.newHashSet("A", "B", "A"));
        list.add(Sets.newHashSet("A", "B"));
        list.add(Sets.newHashSet("1", "2"));
        Set<List<String>> result = Sets.cartesianProduct(list);
        System.out.println(result);
    }

    @Test
    public void testCartesianProductForSet2() throws Exception {
        List<Set<String>> list = new ArrayList<>();
        list.add(Sets.newHashSet("A", "B"));
        list.add(Sets.newHashSet());
        Set<List<String>> result = Sets.cartesianProduct(list);
        System.out.println(result);
    }

    @Test
    public void testCartesianProductForSet3() throws Exception {
        List<Set<String>> list = new ArrayList<>();
        list.add(Sets.newHashSet());
        list.add(Sets.newHashSet());
        Set<List<String>> result = Sets.cartesianProduct(list);
        System.out.println(result);
    }

    @Test
    public void testCartesianProductForList1() throws Exception {
        List<List<String>> list = new ArrayList<>();
        list.add(Lists.newArrayList("A", "B", "A"));
        list.add(Lists.newArrayList("1", "2"));
        List<List<String>> result = Lists.cartesianProduct(list);
        System.out.println(result);
    }

    @Test
    public void testCartesianProductForList2() throws Exception {
        List<List<String>> list = new ArrayList<>();
        list.add(Lists.newArrayList("A", "B"));
        list.add(Lists.newArrayList());
        List<List<String>> result = Lists.cartesianProduct(list);
        System.out.println(result);
    }

    @Test
    public void testCartesianProductForList3() throws Exception {
        List<List<String>> list = new ArrayList<>();
        list.add(Lists.newArrayList());
        list.add(Lists.newArrayList());
        List<List<String>> result = Lists.cartesianProduct(list);
        System.out.println(result);
    }


}
