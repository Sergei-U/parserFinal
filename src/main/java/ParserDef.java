import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//public class ParserDef {
//    public List<Topic> parserSqlRu() throws IOException {
//        ParserDefault parserDefault = new ParserDefault();
//        parserDefault.parseDef();
////        return parserDefault.topic;
//    }
//}
    // @запрос по ключевому слову нужно добавить

//    public List<Topic> topic;
//    public List<Topic> messageList;
//    String urlReq = "https://www.sql.ru/forum/job-offers";
//
//
//    public List<Topic> parseDef() throws IOException {
//
//        topic = new ArrayList<>();
//        messageList = new ArrayList<>();
//
//        Document forum = Jsoup.connect(urlReq).get();
//        Elements table = forum.getElementsByClass("postslisttopic");
//
//        for (Element e : table) {
//            String title = e.select("a[href]")
//                    .first()
//                    .text();
//            String url = e.select("a[href]")
//                    .first()
//                    .attr("href");
//            topic.add(new Topic(title, url));
//
//
//            for (Topic t : topic) {
//
//                String urlTopic = t.getUrl();
//                Document msgBody = Jsoup.connect(urlTopic).get();
////                Elements msgFooter = msgBody.getElementsByClass("msgFooter");
//                Elements msgBodyElem = msgBody.getElementsByClass("msgBody");
//                StringBuilder resulMsgBodyElem = new StringBuilder();
//                Element msg = msgBodyElem.select(".msgBody")
//                        .next()
//                        .first();
//                for (TextNode subString : msg.textNodes()) {
//                    if (!subString.text()
//                            .equals(" ")) {
//                        resulMsgBodyElem.append(subString).append(System.lineSeparator()).toString();
//                    }
//                }
//                String dateVacancy = msgBody
//                        .select("td.msgFooter").first().text();
//                dateVacancy = dateVacancy
//                        .substring(0, dateVacancy.indexOf('['));
//                messageList.add(new Topic(resulMsgBodyElem, dateVacancy));
////                System.out.println(resulMsgBodyElem + dateVacancy);
//            }
//        }
//        return topic;
//    }


