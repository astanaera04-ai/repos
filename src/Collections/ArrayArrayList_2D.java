package Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayArrayList_2D {
    static void main(String[] args) {
        int[][] a = new int[1][1];
        a[0][0] = 1;

        int[][] b = {
                {1, 2, 3},
                {4, 5, 6}
        };
        for(int[] s: b){
            for(int d : s){
                System.out.println(d);
            }

        }

        String[] students = {"Алибек", "Айша", "Нұрлан"};
        String[] subjects = {"Математика", "Физика", "Химия", "Тарих"};
        int[][] grades = {
                {90, 85, 78, 92},
                {75, 88, 95, 80},
                {85, 70, 88, 91}
        };
        for (int i = 0; i < students.length; i++){
            System.out.print(students[i] + ":");
            for (int j = 0; j < subjects.length; j++){
                System.out.print(subjects[j] + "=" + grades[i][j] + " ");

            }
            System.out.println();
        }
////////////////////////////////////////////////////////////////////////////

        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(1);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(2);
        row2.add(2);

        mat.add(row1);
        mat.add(row2);
        for (int i = 0; i < mat.size(); i++) {
            for (int j = 0; j < mat.get(i).size(); j++) {
                System.out.print(mat.get(i).get(j) + " ");
            }
            System.out.println();
        }

        for (ArrayList<Integer> row: mat){
            for (int g : row){
                System.out.print(g + " ");
            }
            System.out.println();
        }


    }
}
