package activities;

public class Task3 {
    public static void main(String[] args) {
        
        String a = new String("Wow");
        String b = "Wow";
        b = a;
        String c = a;
        String d = c;
        d = a + "!";
        c = d;

        boolean bl = a == b;
        boolean b2 = d.equals(b + "!");
        boolean b3 = !c.equals(a);

        if (bl && b2 && b3)
            System.out.println("Success!");
    }
}