import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ParserWithRequest extends ParserDefault{



    public String requestSearch() {
        System.out.println("Введите поисковый запрос: ");
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        return st;
    }

//    public String urlReq = "https://www.sql.ru/forum/actualsearch.aspx?search=" + requestSearch() + "&sin=1&bid=66&a=&ma=0&dt=180&s=4&so=1";

    @Override
    public String urlReqSimple() {
        String urlReq = "https://www.sql.ru/forum/actualsearch.aspx?search=" + requestSearch() + "&sin=1&bid=66&a=&ma=0&dt=180&s=4&so=1";
        return urlReq;
    }

    @Override
    public List<Topic> parseDef() throws IOException {
        return parseDef();
    }
}

