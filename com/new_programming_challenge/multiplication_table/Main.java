package new_programming_challenge.multiplication_table;

public class Main {
    public static void main(String[] args) {
        final byte MAX_NUM = 10;

        for(int row = 1; row <= MAX_NUM; row++) {
            for(int col = 1; col <= MAX_NUM; col++)
                System.out.print((row*col) + "\t");

            System.out.println();
        }
    }
}
