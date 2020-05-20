public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        while (x < 10) {
		x+=x;			
            System.out.print(x + " ");
            x = x + 1;
        }
    }
}