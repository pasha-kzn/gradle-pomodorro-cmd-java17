import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello, World");
        String [] userInput = new Scanner(System.in).nextLine().split(" ");
        System.out.println("Пользователь ввел >> " + userInput);

        int workTime = 1;
        int breakTime = 1;
        int size = 60;

        for (int i = 0; i < userInput.length; i++) {
            switch (userInput[i]) {
                case "-help" -> System.out.println("""
                            \nPomodoro - это приложение для улучшения личной эффективности.
                            -w - сколько работать
                            -b - сколько отдыхать
                            -help - вызвать помощь
                            """);
                case "-w" -> workTime = Integer.parseInt(userInput[++i]);
                case "-b" -> breakTime = Integer.parseInt(userInput[++i]);
            }
        }
        System.out.printf("workTime = %d, breakTime = %d ", workTime, breakTime);


        long startTime = System.currentTimeMillis();
        timer(workTime, breakTime, size);
        long endTime = System.currentTimeMillis();

        System.out.println("\nТаймер работал " + (endTime - startTime)/(1000 * 60) + " минут(ы)");
    }

    public static void timer(int workTimeMin, int breakTimeMin, int size) throws InterruptedException {
        printProgress("Work progress: ", workTimeMin, size);
        printProgress("Break progress: ", breakTimeMin, size);
    }

    private static void printProgress(String process, int time, int size) throws InterruptedException {
        String progress = "";

        double countMinutes = 1/60;
        for (int i = 0; i < size; i++){
            progress = progress + "х";
            for (int j = 0; j < time; j++) {
                //progressF = String.format("%-60s, progress");
                //System.out.print("\r[ " + progressF + " ]");
                System.out.print("\r[ " + progress + " ]");
                Thread.sleep(1000);

            }
        }
        System.out.println("\n" + process + "100%");
    }
}
