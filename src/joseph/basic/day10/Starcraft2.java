package joseph.basic.day10;

public class Starcraft2 {
        //인터페이스 기반으로 유닛을 정의해 봄
    public static void main(String[] args) {
        //interfaces & phone을 참고해서 새로운 방법으로 작성해보기
        // starcraft 이용해서 복사 붙여넣기

        //public static void main(String[] args) {
            //SCV s = new SCV();
            // SCV s = new SCV("SCV",45,5,2.81,50,0);
            // SCV 유닛을 만들때 마다 초기값을 지정하는 것은
            // 다소 번거로움
            //즉, 동일한 속성을 가진 유닛을 만들때 마다
            //메개변수를 통해 객체를 만드는 것은 비효율적임
            // 이런경우, 생성자내에서 초기값을 지정하는 것이 나음

            SCV2 s = new SCV2();
            s.attack();
            s.move();
            s.specialAbility();
            System.out.println();


            Marine2 m = new Marine2();
            m.attack();
            m.move();
            m.specialAbility();
            System.out.println();

            Firebat2 f = new Firebat2();
            f.attack();
            f.move();
            f.specialAbility();
            System.out.println();

        }
    }

    abstract class Unit2{
        protected String name;
        protected int hp;
        protected int power;
        protected double mvspd;
        protected int mineral;
        protected int gas;

//     public Unit(String name, int hp, int power, double mvspd, int mineral, int gas) {
//         this.name = name;
//         this.hp = hp;
//         this.power = power;
//         this.mvspd = mvspd;
//         this.mineral = mineral;
//         this.gas = gas;
//     }

        protected Unit2() {
        }

       // abstract public void attack();
        //abstract void move();
        //abstract void specialAbility();
    }

    //추상클래스에서 정의했던 추상메서드를
    //독립적인 코드들로 분리함 -> 인터페이스
    interface Unit2Action{
        abstract public void attack();
        void move();  //abstract public 생략가능
        void specialAbility();
    }

    class SCV2 extends Unit2 implements Unit2Action {
        final String fmtattck = "융합절단기를 이용해서 대상에 %d의 피해를 주고있습니다\n";
        final String fmtmove =  "지정한 위치로 %.2f 속도로 이동중입니다\n";
        final String fmtspabty = "대상을 수리하는 중입니다\n";


        public SCV2() {
            name = "SCV2";
            hp = 45;
            power = 0;
            mvspd = 2.81;
            mineral = 50;
            gas = 0;
        }



        @Override
        public void attack() {
            //sout("융합절단기를 이용해서.....")
            //추상메서드를 이용해서 부모클래스에 정의된
            //attack메서드를 유닛에 맞게 재정의함
            System.out.printf(fmtattck,power);
        }

        @Override
        public void move() {
            System.out.printf(fmtmove,mvspd);
        }

        @Override
        public void specialAbility() {
            System.out.printf(fmtspabty);
        }
    }

    class Marine2 extends Unit2 implements Unit2Action {

        final String fmtattck = "가우스소총을 이용해서 대상에 %d의 피해를 주고있습니다\n";
        final String fmtmove =  "지정한 위치로 %.2f 속도로 이동중입니다\n";
        final String fmtspabty = "전투자극제를 사용해서 이동속도는 50%%증가, 공격속도 33%% 증가합니다\n";

        public Marine2() {
            name = "해병대";
            hp = 50;
            power = 30;
            mvspd = 2.95;
            mineral = 50;
            gas = 0;
        }

        @Override
        public void attack() {
            System.out.printf(fmtattck,power);
        }

        @Override
        public void move() {
            System.out.printf(fmtmove,mvspd);
        }

        @Override
        public void specialAbility() {
            System.out.printf(fmtspabty);
        }
    }

    class Firebat2 extends Unit2 implements Unit2Action {

        final String fmtattck = "화염방사기를 이용해서 대상에 %d의 피해를 주고있습니다\n";
        final String fmtmove =  "지정한 위치로 %.2f 속도로 이동중입니다\n";
        final String fmtspabty = "전투자극제를 사용해서 이동속도는 50%%증가, 공격속도 33%% 증가합니다\n";

        public Firebat2() {
            name = "화염방사병";
            hp = 50;
            power = 8 * 2;
            mvspd = 1.875;
            mineral = 50;
            gas = 25;
        }

        @Override
        public void attack() {
            System.out.printf(fmtattck,power);
        }

        @Override
        public void move() {
            System.out.printf(fmtmove,mvspd);
        }

        @Override
        public void specialAbility() {
            System.out.printf(fmtspabty);
        }

    }


