package chapter3;

public class StringBuilderLesson {
    public static void main(String[] args) {
        // printing all of ascii char
        String str = "";
        for (char current = 0; current <= 127; current++)
            str += current;
        System.out.println(str);

        System.out.println();
        System.out.println();
        
        // inefficient way
        String alpha = "";
        for (char cur = 'A'; cur <= 'z'; cur++)
            alpha += cur;
            System.out.println(alpha);
            
        // efficient way
        StringBuilder strBldr = new StringBuilder("");
        for (char cur = 'A'; cur <= 'z'; cur++)
            strBldr.append(cur);
        System.out.println(strBldr);


        String str1 = "1";
        str1 += "2";
        str1.concat("3"); // this wil not concat because you were just saying concatinate it but not stored on a variable
        System.out.println(str1);
        // str1 = str1.concat("3"); 
        // System.out.println(str1); this will result "123"

        StringBuilder stringBuilder1 = new StringBuilder("start");
        stringBuilder1.append("+middle");
        stringBuilder1.append("+end");
        System.out.println(stringBuilder1);

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("start");
        StringBuilder sb3 = new StringBuilder(10);

        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb3);

        System.out.println();
        System.out.println();
        
        StringBuilder sb4 = new StringBuilder("animals");
        String sb4_2 = sb4.substring(sb4.indexOf("a"), sb4.indexOf("al"));
        System.out.println(sb4_2); // anim, start 0 - ends 4
        int len =  sb4_2.length();
        System.out.println(len);
        char ch = sb4.charAt(6);
        System.out.println(sb4_2 + " " + len + " " + ch); // "anime 4 s"
        
        System.out.println();
        System.out.println();
        
        StringBuilder sb5 = new StringBuilder(0).append(1).append(2).append('c').append(.0).append(1.04).append(1.0);
        sb5.append("-").append(true);
        System.out.println(sb5);
        
        System.out.println();
        System.out.println();
        
        StringBuilder sb6 = new StringBuilder("animals");
        sb6.insert(7, '2'); // animals2
        sb6.insert(0, '2'); // 2animals2
        sb6.insert(4, '2'); // 2ani2mals2
        sb6.insert(4, '@'); // 2ani@2mals2
        sb6.insert(4, 0); // 2ani0@2mals2
        sb6.insert(12, "HEELOW"); // 2ani0@2mals2HEELOW
        System.out.println(sb6); // 2ani@2mals2HEELOW
        
        System.out.println();
        System.out.println();
        
        StringBuilder sb7 = new StringBuilder("animals");
        // sb7.delete(4, 3); // out of bounds
        // sb7.delete(7, 9); // out of bounds
        sb7.delete(1, 5); // als
        System.out.println(sb7); // als
        // sb7.deleteCharAt(7); // out of bounds
        sb7.deleteCharAt(1); // as
        System.out.println(sb7); // as
        
        System.out.println();
        System.out.println();
        
        StringBuilder sb8 = new StringBuilder("animals");
        sb8.reverse();
        System.out.println(sb8);
        
        System.out.println();
        System.out.println();
        
        StringBuilder sb9 = new StringBuilder("animals");
        StringBuilder sb10 = new StringBuilder("animals");
        sb9.toString();
        sb10.toString();
        System.out.println(sb9.toString()); // animals
        System.out.println(sb9); // animals
        System.out.println(sb9 == sb10); // false
        System.out.println(sb9.toString() == sb10.toString()); // false
        System.out.println(sb9.equals(sb10)); // false
        System.out.println(sb9.toString().equals(sb10.toString())); // false
    }
}
