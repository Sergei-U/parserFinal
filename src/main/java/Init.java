import java.io.IOException;
import java.util.Scanner;

/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class Init<init> {

    public Init {

        System.out.println("1 - Парсинг на сайте SQL.ru по вакансиям без поискового запроса");
        Scanner scanner = new Scanner(System.in);
        int numOfOperation = scanner.nextInt();

        switch (numOfOperation) {
            case 1:
            ParserDef parserDef = new ParserDef();

                try {
                    parserDef.parserSqlRu();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(parserDef);
                break;
            case 2:
            ParserWithRequest parserWithRequest = new ParserWithRequest();
            parserWithRequest.parserWithReq();
            System.out.println(parserWithRequest.topic);
        }
    }
}

