package test;

import java.util.*;

public class MergeSort {

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int i = 0, j = 0;
        int LS = left.size(), RS = right.size();
        int N = LS + RS;

        List<Integer> res = Arrays.asList(new Integer[N]);

        for(ListIterator<Integer> li = res.listIterator(); li.hasNext();) {
            li.next();

            if (i < LS && j < RS) {
                int le = left.get(i);
                int ri = right.get(j);

                if (le < ri) {
                    li.set(le);
                    i++;
                } else {
                    li.set(ri);
                    j++;
                }
            } else {
                if (i < LS) {
                    li.set(left.get(i));
                    i++;
                } else if (j < RS) {
                    li.set(right.get(j));
                    j++;
                }
            }
        }



        return res;
    }

    private static List<Integer> sort(List<Integer> list) {
        int N = list.size();

        if (N == 1) {
            return Collections.nCopies(1, list.get(0));
        }

        if (N == 2) {
            if (list.get(0) > list.get(1)) {
                return Arrays.asList(list.get(1), list.get(0));
            } else {
                return Arrays.asList(list.get(0), list.get(1));
            }
        }


        int half = N / 2;
        List<Integer> left = sort(list.subList(0, half));
        List<Integer> right = sort(list.subList(half, N));

        return merge(left, right);

    }

    public static void main(String... args) {
//        List<Integer> list = new ArrayList<>();
//
//        for (int i = 10; i < 30; i++) {
//            list.add(i);
//        }
//
//        Collections.shuffle(list);
//
//        list.stream().forEach(e -> System.out.printf("%d, ", e));
//
//        List<Integer> res = sort(list);
//        System.out.println("\n");
//
//        res.stream().forEach(e -> System.out.printf("%d, ", e));

        List<Integer> li = Arrays.asList(120, 80, 25, 20, 30);
        Collections.sort(li);

    }
}
