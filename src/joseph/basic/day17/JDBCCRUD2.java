package joseph.basic.day17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCCRUD2 {
    public static void main(String[] args) throws ClassNotFoundException {
        //ex) playground 데이터베이스에 books 테이블을
        //저장된 데이터들을 조회하는 프로그램 작성
        //조회대상 : 모든 컬럼

        //JDBC 접속정보
        String drv = "org.mariadb.jdbc.Driver";
        String amz = "bigdata.cfedxhiyqmff.ap-northeast-2.rds.amazonaws.com";
        String url = "jdbc:mariadb://"+amz+":3306/playground";
        String usr = "playground";
        String pwd = "bigdata2020";

        //JDBC 관련 SQL 정의
        String readAll = " select * from books ";
        String readAll2 = " select bookname,price from books ";
        String readone = " select * from books where publish = 'oracle' ";

        Class.forName(drv);

        try(
            Connection conn =
                DriverManager.getConnection(url,usr,pwd);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(readAll);
            //지정한 SQL을 실행하고 결과집합을 받아옴
            //단, select 실행시에만 사용!
        ){
            StringBuffer sb = new StringBuffer();
            while(rs.next()) {
                //결과집합에서 불러올 데이터가 없을때까지 다음을 반복
                sb.append(rs.getString(1))
                    //결과집합에서 첫번째 컬럼의 값을 문자형태로 읽어옴
                    .append(rs.getString(2))
                    //결과집합에서 bookname 컬럼의 값을 문자형태로 읽어옴
                    .append(rs.getString(3))
                    .append(rs.getString(4))
                    .append("\n");
            }
            System.out.println(sb.toString());

        } catch (Exception ex){
            ex.printStackTrace();
        }

        // readAll2
        try(
            Connection conn = DriverManager.getConnection(url,usr,pwd);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(readAll2)
                ){
            StringBuffer sb = new StringBuffer();
            while(rs.next()) {
                sb.append(rs.getString(1)).append(" ")
                .append(rs.getString(1)).append(" ")
                        .append("\n");
            }
            System.out.println(sb.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }

        //ReadOne
        try (
            Connection conn = DriverManager.getConnection(url,usr,pwd);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(readone);
            ){
                String fmt = "%s %s %s %s";
                StringBuffer sb = new StringBuffer();

                while(rs.next()){
                    String result = String.format(fmt,
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4));
                    sb.append(result);
    }
            System.out.println(sb.toString());
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
