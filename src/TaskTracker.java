import java.math.BigInteger;
import java.util.Scanner;

public class TaskTracker {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MIN_MENU_NUMBER = 0;
    private static final int MAX_MENU_NUMBER = 8;
    private static final BigInteger MIN_INT = BigInteger.valueOf(Integer.MIN_VALUE);
    private static final BigInteger MAX_INT = BigInteger.valueOf(Integer.MAX_VALUE);

    public static void main(String[] args) {
        run();
    }

    // Task Tracker 실행
    public static void run(){
        int menuNumber = -1;

        while(true){
            // 메뉴 목록 출력
            printMenuList();

            // 메뉴 번호 입력
            menuNumber = enterMenuNumber();

            // 0. 프로그램 종료
            if(menuNumber == 0){
                System.out.println("프로그램이 종료되었습니다.");
                break;
            }

            // 메뉴 분기
            switch(menuNumber){
                case 1: // 1. 할 일 등록
                    performAddTask();
                    break;
                case 2: // 2. 할 일 전체 조회
                    performFindTaskAll();
                    break;
                case 3: // 3. 완료 할 일 조회
                    performFindCompletedTasks();
                    break;
                case 4: // 4. 미완료 할 일 조회
                    performFindUncompletedTasks();
                    break;
                case 5: // 5. 할 일 완료 처리
                    performUpdateTaskComplete();
                    break;
                case 6: // 6. 할 일 미완료 처리
                    performUpdateTaskUncomplete();
                    break;
                case 7: // 7. 할 일 삭제
                    performRemoveTask();
                    break;
                case 8: // 8. 할 일 통계 조회
                    performPrintTaskStatistics();
                    break;
            }
        }
    }

    // 메뉴 목록 출력
    public static void printMenuList(){
        String[] menuList = {
                "0. 프로그램 종료",
                "1. 할 일 등록",
                "2. 할 일 전체 조회",
                "3. 완료 할 일 조회",
                "4. 미완료 할 일 조회",
                "5. 할 일 완료 처리",
                "6. 할 일 미완료 처리",
                "7. 할 일 삭제",
                "8. 할 일 통계 조회"
        };

        System.out.println("\n[ Task Tracker ]\n");

        for(String menu: menuList){
            System.out.println(menu);
        }

        System.out.println("\n==================================================\n");
    }

    // 메뉴 번호 입력
    public static int enterMenuNumber(){
        String inputLine = null;
        int menuNumber = -1;

        while(true){
            System.out.print("메뉴 입력 >>> ");

            inputLine = scanner.nextLine().trim();

            if(!validateIntOfForm(inputLine)){
                System.out.println("유효 형식에 벗어난 입력입니다. 다시 입력하세요.");
                System.out.println("\n==================================================\n");                continue;
            }

            menuNumber = Integer.parseInt(inputLine);

            if(!validateIntOfRange(menuNumber, MIN_MENU_NUMBER, MAX_MENU_NUMBER)){
                System.out.println("유효 범위에 벗어난 입력입니다. 다시 입력하세요.");
                System.out.println("\n==================================================\n");                continue;
            }

            System.out.println("\n==================================================\n");
            break;
        }

        return menuNumber;
    }

    // 정수 입력 유효 형식 검사
    public static boolean validateIntOfForm(String inputLine){

        // 빈 줄 검사
        if(inputLine.isEmpty()){
            return false;
        }

        // 여러 값 검사
        String[] values = inputLine.split("[\\s,]+");
        if (values.length > 1 && !values[0].isEmpty()) {
            return false;
        }

        // 실수 검사
        if (inputLine.matches("[+-]?(?:[0-9]+\\.[0-9]*|\\.[0-9]+)(?:[eE][+-]?[0-9]+)?"
                + "|[+-]?[0-9]+[eE][+-]?[0-9]+")) {

            return false;
        }

        // 문자 검사
        if (!inputLine.matches("[+-]?[0-9]+")) {
            return false;
        }

        // 정수 범위 검사
        BigInteger number = new BigInteger(inputLine);
        if (number.compareTo(MIN_INT) < 0 || number.compareTo(MAX_INT) > 0) {
            return false;
        }

        return true;
    }

    // 정수 입력 유효 범위 검사
    public static boolean validateIntOfRange(int number, int start, int end){
        return number >= start && number <= end;
    }

    // 할 일 등록
    public static void performAddTask(){
        System.out.println("할 일 등록 수행");
    }

    // 할 일 전체 조회
    public static void performFindTaskAll(){
        System.out.println("할 일 전체 조회 수행");
    }

    // 완료 할 일 조회
    public static void performFindCompletedTasks(){
        System.out.println("완료 할 일 조회 수행");
    }

    // 미완료 할 일 조회
    public static void performFindUncompletedTasks(){
        System.out.println("미완료 할 일 수행");
    }

    // 할 일 완료 처리
    public static void performUpdateTaskComplete(){
        System.out.println("할 일 완료 처리 수행");
    }

    // 할 일 미완료 처리
    public static void performUpdateTaskUncomplete(){
        System.out.println("할 일 미완료 처리 수행");
    }

    // 할 일 삭제
    public static void performRemoveTask(){
        System.out.println("할 일 삭제 수행");
    }

    // 할 일 통계 조회
    public static void performPrintTaskStatistics(){
        System.out.println("할 일 통계 조회 수행");
    }
}
