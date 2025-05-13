package chapter3;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayLesson {

    public static void main(String[] args) {
        Student[] s0 = { new Student("Sample", "Course 1", 2), new Student("Sample2", "Course 2", 3) };
        
        System.out.println(Arrays.toString(s0)); // [{ Fullname = Sample, Course = Course 1, Age = 2 }, { Fullname = Sample2, Course = Course 2, Age = 3 }]

        int [] s1 = new int[3];
        int s2 [] = new int[3];
        System.out.println(Arrays.toString(s1) + " " + Arrays.toString(s2)); // [0, 0, 0] [0, 0, 0]
 
        for(Student i: s0) 
            System.out.println(i); 
            /**
             * { Fullname = Sample, Course = Course 1, Age = 2 } 
             * { Fullname = Sample2, Course = Course 2, Age = 3 } 
            */
        
        String[] s3 = { "2", "1" , "3", "4", " 10", "200", "300", "30"};
        Arrays.sort(s3); // in string when sorting, it will evaluate the ascii codes so the result will be 10, 1, 2, 200, 3, 30, 300

        for(String s: s3)
            System.out.print(s + " ");

        System.out.println();
        System.out.println();

        System.out.println(Arrays.binarySearch(s3, "3"));
        // binary search
        //  1,  2,  3,  4,  5
        //  0   1  2   3   4
        //-1 -2  -3 -4  -5  -6. between each holes it corresponds a negative value so that you will get the negative value if not found in binary search

        int[] s4 = {1,3,4,5,6,9};
        Arrays.sort(s4);
        System.out.println(Arrays.binarySearch(s4, 7)); 
        /**
         * (index) 
         * size + 1 
         */ 
        System.out.println();
        System.out.println();

        List<String> list = new ArrayList<>();
        list.add("hawk");
        list.add("new");
        Object[] objectArr = list.toArray();
        System.out.println(objectArr.length);
        System.out.println(Arrays.toString(objectArr));
        String[] stringArr = list.toArray(new String[5]);
        System.out.println(stringArr.length);
        System.out.println(Arrays.toString(stringArr));
        System.out.println(Arrays.toString(new String[3]));


        String[] arr = { "hawk", "robin"};
        List<String> list1 = Arrays.asList(arr);
        System.out.println(list1.size());
        list1.set(1, "test"); // ["hawk", "test"]
        arr[0] = "new"; // ["new", "test"]
        for (String b: arr)
            System.out.println(b + " ");
        // list1.remove(1); // unsupported because of Array is a 
        // fixed number and you cannot remove or add new item from a list but you can modify it using set

        Integer[] arr123 = new Integer[3];
        List<Integer> listStr = Arrays.asList(arr123);
        Object[] listStr1 = listStr.toArray();
        System.out.println("LIST: "+Arrays.toString(listStr1));

        
        System.out.println();
        System.out.println();

        ArrayList<String> one = new ArrayList<>();
        List<String> two = new ArrayList<>();

        one.add(1);
        one.contains(1);
        System.out.println(one.equals(two));
        two.add("2");
        System.out.println(one.equals(two));
        one.add("2");
        System.out.println(one.equals(two));

        List<String> arrr = Arrays.asList("1","3");
        System.out.println(arrr);
        arrr.set(0, "123");
        System.out.println(arrr);
        // arrr.add("123"); // unsupported
        System.out.println(arrr);
        // arrr.remove("123"); // unsupported
        System.out.println(arrr);

        LocalDate now = LocalDate.now();
        LocalDate dob = LocalDate.of(1990, 4, 3);
        System.out.println(now.minusYears(dob.getYear()).getYear());

        Period age = Period.between(dob, LocalDate.now());
        System.out.println(age.getYears());
        age = age.plusMonths(1);
        System.out.println(age.getMonths());

        int[] num = new int[]{1,2,3};
        System.out.println(num);
    }

    public static void main1(String... args) {
        
    }

    public static void main2(String args []) {
        
    }

    public static void main3(String [] args) {
        
    }

    public static void main4(String args[]) {
        
    }

    // public static void main4(String args...) {
        
    // }
}
