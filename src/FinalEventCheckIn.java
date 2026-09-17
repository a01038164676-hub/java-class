import java.util.Scanner;

class StudentEntry {
    String studentId;
    String name;
}

public class FinalEventCheckIn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentEntry[] entries = new StudentEntry[5];
        int count = 0;
        while (true) {
            System.out.println("\n[취업 특강 접수]");
            System.out.println("1 신청  2 명단  3 취소  4 현황  0 종료");
            System.out.print("선택: ");
            String menu = scanner.nextLine().trim();

            if (menu.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (menu) {
                case "1":
                    System.out.print("학번: ");
                    String studentId = scanner.nextLine().trim();
                    System.out.print("이름: ");
                    String name = scanner.nextLine().trim();
                    if (studentId == "" || name == "") {
                        System.out.println("빈 학번이나 빈 이름은 넣으실 수 없습니다");
                        break;
                    }

                    boolean duplicate = false;
                    for (StudentEntry entry : entries) {
                        if (entry != null && entry.studentId.equals(studentId)) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (duplicate) {
                        System.out.println("중복된 학번입니다.");
                        break;
                    }

                    int emptyIndex = -1;
                    for (int i = 0; i < entries.length; i++) {
                        if(entries[i] == null) {
                            emptyIndex = i;
                            count +=1;
                            break;
                        }
                    }

                    if (emptyIndex == -1) {
                        System.out.println("정원마감");
                        break;
                    }
                    StudentEntry newEntry = new StudentEntry();
                    newEntry.studentId = studentId;
                    newEntry.name = name;
                    entries[emptyIndex] = newEntry;
                    System.out.println(name + "학생 신청 완료");
                    break;

                case "2":
                    boolean isEmpty = true;
                    // TODO 5. null을 건너뛰며 위치, 학번, 이름을 출력하세요.
                    // 아무도 없으면 "등록된 신청자가 없습니다."를 출력하세요.
                    for (int i = 0; i < entries.length; i++) {
                        if (entries[i] != null) {
                            System.out.println(i+1 + "번 학생 " + "학번:" + entries[i].studentId + " 이름:" + entries[i].name);
                            isEmpty =false;
                        }
                    }
                    if(isEmpty){
                    System.out.println("등록된 신청자가 없습니다.");
                }
                    break;

                case "3":
                    boolean found = false;
                    System.out.print("취소할 학번: ");
                    String cancelId = scanner.nextLine().trim();
                    // TODO 6. 학번을 찾아 해당 칸에 null을 넣으세요.
                    // 없는 학번이라면 그 사실을 알려 주세요.
                    for (int i = 0;i < entries.length;i++) {
                        if (entries[i] != null && entries[i].studentId.equals(cancelId)) {
                            System.out.println("신청 취소 완료");
                            entries[i] = null;
                            count -=1;
                            found = true;
                            break;
                        }
                    }
                        if(!found){
                            System.out.println("등록되지 않은 학번입니다.");
                    }
                    break;

                case "4":
                    // TODO 7. null이 아닌 칸을 세어 현재 인원과 남은 자리를 출력하세요.
                    System.out.println("현재 신청:" + count + "명");
                    System.out.println("남은 자리:" + (entries.length - count) + "명");
                    break;

                default:
                    System.out.println("0부터 4까지 선택하세요.");
                    break;
            }
        }
    }
}