import java.util.Arrays;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {


        MyIntArrayList firstArray = new MyIntArrayList(10);
        firstArray.add(1);
        firstArray.add(2);
        firstArray.add(5);

        MyIntArrayList secondArray = new MyIntArrayList();
        secondArray.add(5);


        firstArray.addAll(-1, secondArray);
        System.out.println(firstArray.indexOf(2));
        firstArray.add(1);

        for (int i = 0; i < firstArray.size(); i++) {
            System.out.print(firstArray.get(i) + " ");
        }

    }
}
