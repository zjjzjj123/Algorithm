package sort;

import sun.awt.image.IntegerInterleavedRaster;

import java.util.*;

//map的遍历
public class MapList {

    public static void test()
    {

        int[] a = {1,2,2,3,4,3};

        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<a.length; i++)
        {
            list.add(a[i]);
            map.put(a[i],map.getOrDefault(a[i],0) + 1);
        }

        Set<Integer> set = map.keySet(); //
        Iterator<Integer> it = set.iterator();
        for(int key:map.keySet())
        {
            map.get(key);
        }

        Set<Map.Entry<Integer,Integer>> set1 = map.entrySet();
        Iterator<Map.Entry<Integer,Integer>> it1 = set1.iterator();
        while(it.hasNext())
        {
            Map.Entry<Integer,Integer> map1 = it1.next();
            Integer k = map1.getKey();
        }



        //keyset   entry


        System.out.println(map);
        System.out.println(list);
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(map.get(o1) - map.get(o2) != 0) return map.get(o1) - map.get(o2); //按照升序排列
//                else
//                    return o1 - o2;
//            }
//        });
//        System.out.println(list);
//        int k = 2;
//        Set<Integer> s = new HashSet<>();
//        for(int i=k; i<list.size(); i++)
//        {
//            s.add(list.get(i));
//        }
//        System.out.println(s.size());

    }


}
