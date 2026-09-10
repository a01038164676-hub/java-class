import java.util.Scanner;

public class FinalMultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== 원하는 범위의 구구단 =====");
        System.out.print("시작 단(2~9): ");
        int startDan = scanner.nextInt();
        System.out.print("끝 단(2~9): ");
        int endDan = scanner.nextInt();

        // TODO 1: 위의 입력 규칙을 만족하지 않는 경우를 하나의 조건식으로 작성한다.
        boolean invalid = false;

        if (invalid) {
            System.out.println("2~9 범위를 순서대로 입력하세요.");
        } else {
            // TODO 2: 바깥쪽 for문의 초기식, 조건식, 증감식을 모두 작성한다.
            for (int dan = startDan; dan <= endDan; dan += 1) {
                System.out.println("[" + dan + "단]");

                // TODO 3: 안쪽 for문의 초기식, 조건식, 증감식을 모두 작성한다.
                for (int number = 1; number < 10; number += 1) {
                    // TODO 4: 한 줄에 출력할 구구단 계산 결과를 구한다.
                    int result = startDan * number;
                    System.out.println(dan + " x " + number + " = " + result);
                }

                System.out.println();
            }
        }

        scanner.close();
    }
}
