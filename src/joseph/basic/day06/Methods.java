package joseph.basic.day06;

public class Methods {
    public static void main(String[] args) {
        // 메서드
        // 어떤 특정 작업을 수행하기 위한 코드들의 집합
        // C 언어의 함수와도 유하사다
        // 유사한 코드들의 반복적으로 사용하는 것을 피할 수 있음
        // 모듈화를 통해 프로그램의 이해도 증가
        //코드의 문제발생 또는 기능 변경시에
        // 손쉽게 유지보수 가능

        // 메서드 형식
            // 접근지정자 반환타입 메서드명 (매개변수 목록) {
            // 메서드 몸체
            // return 변수
            //}
        // 접근지정자 : 메서드 접근허용여부 (public/private)
        // 반환타입 : 메서드 실행 후 반환하는 자료의 타입 지정(return)
        //           반환타입이 없는 경우 void로 정의
        // 매개변수목록 : 메서드 호출시 전달하는 변수 지정

        // 메서드 호출
        // 메서드명()
        // 메서드명(매개변수값)

        //ex) 1 ~ 10사이 난수 10 생성 v1
        for (int i = 1; i <= 10; ++i) {
            int magic = (int) (Math.random() * 10) + 1;
            System.out.print(magic + " ");
        }
        System.out.println("");

        //ex) 1 ~ 10사이 난수 10 생성 v1
        for (int i = 1; i <= 10; ++i) {
            make_magic();
        } // for
        System.out.println();

        // 인삿말 출력 v1
        System.out.println("Hello,World!!");

        // 인삿말 출력 v2
        sayHello();

        // 인삿말 v2b - Hello, Java라는 메세지 출력
        sayHello2();

        // 인삿말 v3 - 인삿말을 대상을 변수화
        sayHello3("World"); //Hello, World
        sayHello3("Java"); //Hello, Java

        // 인삿말 v4 - 반환타입이 있는 메서드
        String say = sayHello4("Python");
        System.out.println(say);


    }// main


    //1 ~ 10 사이 임의의 난수를 출력하는 메서드
    public static void make_magic() {
        int magic = (int) (Math.random() * 10) + 1;
        System.out.print(magic + " ");
    }

    //간단한 인삿말을 출력하는 메서드
        public static void sayHello(){
            System.out.println("Hello,World!!");
        }
    //간단한 인삿말을 출력하는 메서드 2
        public static void sayHello2(){
            System.out.println("Hello,Java!!");
        }

        //간단한 인삿말을 출력하는 메서드 3
        //인삿말을 구성한 후 콘솔에 출력
        public static void sayHello3(String msg) {
            System.out.println("Hello," + msg + "!!");
        }

        public static String sayHello4(String msg) {
            String say = "Hello," + msg + "!!";
            return say;
    }

    } // class