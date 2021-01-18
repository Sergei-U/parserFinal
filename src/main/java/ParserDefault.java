import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Usov
 * @version 1.0.0
 */
@Data
public class ParserDefault implements ParserInterfaceSqlRU{
    
    public List<Topic> topic;
    public List<Topic> messageList;
    private String url;


    public void setUrl(String url) {
        this.url = urlReqSimple();
    }

    public String urlReqSimple () {
        String urlReq = "https://www.sql.ru/forum/job-offers";
        return urlReq;
    }



    public List<Topic> parseDef() throws IOException {

        topic = new ArrayList<>();
        messageList = new ArrayList<>();

        Document forum = Jsoup.connect(urlReqSimple()).get();
        Elements table = forum.getElementsByClass("postslisttopic");

        for (Element e : table) {
            String title = e.select("a[href]")
                    .first()
                    .text();
            String url = e.select("a[href]")
                    .first()
                    .attr("href");
            topic.add(new Topic(title, url));


            for (Topic t : topic) {

                String urlTopic = t.getUrl();
                Document msgBody = Jsoup.connect(urlTopic).get();
//                Elements msgFooter = msgBody.getElementsByClass("msgFooter");
                Elements msgBodyElem = msgBody.getElementsByClass("msgBody");
                StringBuilder resulMsgBodyElem = new StringBuilder();
                Element msg = msgBodyElem
                        .select(".msgBody")
                        .next()
                        .first();
                for (TextNode subString : msg.textNodes()) {
                    if (!subString.text()
                            .equals(" ")) {
                        resulMsgBodyElem
                                .append(subString)
                                .append(System.lineSeparator())
                                .toString();
                    }
                }
                String dateVacancy = msgBody
                        .select("td.msgFooter")
                        .first()
                        .text();
                dateVacancy = dateVacancy
                        .substring(0, dateVacancy.indexOf('['));
                messageList.add(new Topic(resulMsgBodyElem, dateVacancy));
//                System.out.println(resulMsgBodyElem + dateVacancy);
            }
        }
        return topic;
    }
}
