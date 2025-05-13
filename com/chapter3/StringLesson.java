package chapter3;

public class StringLesson {
    public static void main(String[] args) {
        String s1 = new String("Sample");
        String s2 = "Sample";
        s2.concat(" Sample 3");
        System.out.println(s1 + " Sample2"); // "Sample Sample2"
        System.out.println("Concatenation: " + s1); // "Sample" this will not include the Sample2
        s1 += " Sample 2";
        System.out.println("Concatenation: " + s1); // "Sample Sample2"
        System.out.println("Concatenation: " + 1 + 2 + 3 + 4 + 'a'); // 10
        System.out.println("Concatenation: " + 1 + 'c'); // converts char c to 99 + 1 = 100
        System.out.println("Concatenation: " + 1 + (int)'c'); // same as example above, in this case, we explicitly type coerce the char c. then it adds to 1
        
        System.out.println();
        System.out.println();

        String s3 = "Sample";
        String s4 = new String("Sample");
        System.out.println("Compare String literal to new String(): " + (s3 == s4)); // false since new String is inside String pool you are comparing object and a value which is not compared
        System.out.println("Compare String literal to new String(): " + s3.equals(s4)); // true since it refers to the value itself not the object address
        System.out.println("Compare String literal to new String(): " + s3.equalsIgnoreCase(s4)); // true since it refers to the value itself not the object address
        System.out.println("Compare String literal equalsIgnoreCase: " + "HELLO".equalsIgnoreCase("hello")); // true

        System.out.println();
        System.out.println();

        System.out.println("Char At: " + "Hello".charAt(0)); // 'H'
        // System.out.println("Char At: " + "Hello".charAt(6)); // doesn't compile, String index out of bounds exception
        // System.out.println("Char At: " + "Hello".charAt(0.1)); // doesn't compile it should be number int not a double
        // System.out.println("Char At: " + "Hello".charAt('h')); // doesn't compile it should be number not a character
        
        System.out.println();
        System.out.println();

        System.out.println("Index Of 'H': " + ("HelloH".indexOf('H'))); // index 0, it's start from left, whose the first index seen that would be the return index 
        System.out.println("Index Of \"'h'\": " + "Hello".indexOf('h')); // index -1, must be uppercase h
        System.out.println("Index Of \"'l'\": " + "Hello".indexOf('l')); // index 2 same as 1st example
        System.out.println("Index Of 0: " + "Hello0".indexOf(0)); // index -1 since its number
        System.out.println("Index Of \"Lo\": " + "Hello".indexOf("Lo")); // index -1
        System.out.println("Index Of \"lo\": " + "Hello".indexOf("lo")); // index 3
        System.out.println("Index Of \"0\": " + "Hello0".indexOf("0")); // index 5
        System.out.println("Index Of \'0\', 4: " + "Hello0".indexOf('0', 2)); // index 5
        System.out.println("Index Of \'0\', 4: " + "He0lo".indexOf('0', 4)); // index -1, this is because you are exceeding the number of the indexOf '0'
        System.out.println("Index Of \'0\', 4: " + "He0lo".indexOf("lo", 2)); // index 3
        System.out.println("Index Of \'0\', 4: " + "He0lo".indexOf("lo", 3)); // index 3
        
        System.out.println();
        System.out.println();

        System.out.println("Substring: " + "Hello".substring(1, 4)); // "ell" because you say start to index 1 and stop to index 4
        System.out.println("Substring: " + "Hello".substring(4)); // "o" because you say start to index 1 and stop to index 4
        System.out.println("Substring: " + "Hello".substring(5)); // "" because you say start to index 1 and stop to index 4
        System.out.println("Substring: " + "Hello".substring(4,4)); // "" because you say start to index 1 and stop to index 4
        // System.out.println("Substring: " + "Hello".substring(1, 6)); // Error out of bounds
        // System.out.println("Substring: " + "Hello".substring(6)); // Error out of bounds
        // System.out.println("Substring: " + "Hello".substring(3, 2)); // Error out of bounds, not backwards, only forward
        
        System.out.println();
        System.out.println();

        System.out.println("Uppercase: " + " Hello ".toUpperCase()); // "HELLO"
        System.out.println("Uppercase: " + " HE lLO ".toUpperCase()); // "HELLO"

        System.out.println();
        System.out.println();
        
        System.out.println("Lowercase: " + " Hello G".toLowerCase()); // " hello "
        System.out.println("Lowercase: " + "helLo  Ooo o0 ".toLowerCase()); // "hello  ooo o0 "

        System.out.println();
        System.out.println();

        System.out.println("StartsWith: " + "Hello".startsWith("h")); // false, since it is not uppercased letter H
        // System.out.println("StartsWith: " + "Hello".startsWith('h')); // doesn't compile, only String
        // System.out.println("StartsWith: " + "Hello".startsWith(true)); // false, you supplied boolean value not a string

        System.out.println();
        System.out.println();

        System.out.println("EndsWith: " + "Hello".endsWith("lo")); // true
        System.out.println("EndsWith: " + "Hello".endsWith("Lo")); // true
        // System.out.println("EndsWith: " + "Hello".endsWith('A')); // String only
        // System.out.println("EndsWith: " + "Hello".endsWith(1)); // String only
        
        System.out.println();
        System.out.println();
        
        System.out.println("Contains: " + "Hello".contains("Lo")); // false
        System.out.println("Contains: " + "Hell0".contains("ll0")); // true
        System.out.println("Contains: " + "Hell LLo ll0".contains("ll0")); // true
        System.out.println("Contains: " + "Hell LLo l l0".contains("ll0")); // false
        System.out.println("Contains: " + "Hello".contains("l")); // true
        System.out.println("Contains: " + "Hello".contains("h")); // false, case sensitive
        
        // System.out.println("Contains: " + "Hello".contains('l')); // doesn't compile String only
        // System.out.println("Contains: " + "Hello".contains('l')); // doesn't compile String only
        
        System.out.println();
        System.out.println();

        System.out.println("Blank: " + " ". isBlank()); // true
        System.out.println("Empty: " + " ". isEmpty()); // false, because it has whitespaces

        
        System.out.println();
        System.out.println();
        
        System.out.println("Replace: " + "Hello".replace("H", "J")); // "Jello"
        System.out.println("Replace: " + "Hello".replace("P", "J"));// "Hello"
        System.out.println("Replace: " + "Hello".replace("L", "o"));// "Hello"
        System.out.println("Replace: " + "Hello".replace("l", "o"));// "Heooo"
        System.out.println("Replace: " + "Hello".replace('l', '0'));// "He00o" this one is applicable because you use the char + char
        // System.out.println("Replace: " + "Hello".replace('l', "0"));// "He00o" this one is applicable because you use the char + char
        // System.out.println("Replace: " + "Hello".replace(0, 0)); // doesn't compile because int + int is not applicating for String
        // System.out.println("Replace: " + "Hello".replace("l", '0'));// it doesn't comppile because it's not same type, char and string are not compatible
        
        System.out.println();
        System.out.println();

        System.out.println("Trim: " + " Hello ".trim()); // "Hello"
        System.out.println("Trim: " + " He llo ".trim()); // "He llo" only trim the first and last of the text
        System.out.println("Trim: " + " He llo Sa  mpleGekko  ".trim()); // "He llo Sa  mpleGekko" only trim the first and last of the text
        
        System.out.println();
        System.out.println();

        System.out.println("Equality compiled and runtime function: " + "Hello" == " Hello".trim()); // false since .trim() will run on rumtime

        var mt = new Mutable();
        mt.setName("YourName");
        System.out.println(mt.getName());

        var imt = new Immutable();
        // this compiles an error, because of final keyword indicates at intstantiate variable String name. it means that this cannot be change
        // imt.setName("TheirName");
        System.out.println(imt.getName());
        
        String a = "";
        a += 2;
        a += 'c';
        a += false;
        if(a == "2cfalse") System.out.println("==");
        if(a.equals("2cfalse")) System.out.println("eq");
    }


    public static class Mutable {
        String name = "MyName";

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    final static class Immutable {
        private final String name = "MyName";

        // this compiles an error, because of final keyword indicates at attribute String name. it means that this cannot be change
        // public void setName(String name) {
        //     this.name = name;
        // }

        public String getName() {
            return name;
        }
    }
}
