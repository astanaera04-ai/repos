package Learn_java;

import java.util.Scanner;

public class esep47 {
    static void main(String[] args) {
        String[] tasks = new String[10];
        boolean[] done = new boolean[10];
        int count = 0;
        int choice = 0;
        Scanner sc = new Scanner(System.in);


        do{

            System.out.println("1. Add task");
            System.out.println("2. View all tasks");
            System.out.println("3. Mark task done");
            System.out.println("4. Exit");
            System.out.println("Choose the number:");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("What kind of task you want to add?");
                    tasks[count] = sc.nextLine();
                    done[count] = false;
                    count++;

                    if (count >= 10) {
                        System.out.println("List is full!");
                        break;
                    }

                    if (count == 0) {
                        System.out.println("No tasks yet!");
                    }
                    break;
                case 2:
                    for(int i = 0; i < count; i++){
                        String status = done[i]? "[✓]" : "[ ]";
                        System.out.println(i + 1 + ". " + status + " " + tasks[i]);
                    }
                    break;
                case 3:
                    System.out.println("Which kind of task you done?");
                    int num = sc.nextInt();
                    done[num - 1] = true;
                    if (num < 1 || num > count) {
                        System.out.println("Invalid task number!");
                        break;
                    }
                    break;
                case 4:
                    break;
            }


        }while (choice != 4);
    }
}
