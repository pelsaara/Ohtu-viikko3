package ohtu;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "011120775"; //011120775
        if (args.length > 0) {
            studentNr = args[0];
        }
        String url2 = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
        String courseInfo = Request.Get(url2).execute().returnContent().asString();

        Gson mapper = new Gson();
        Course course = mapper.fromJson(courseInfo, Course.class);

        System.out.println(course);
        System.out.println("");

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";
        String bodyText = Request.Get(url).execute().returnContent().asString();

        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        System.out.println("Opiskelijanumero: " + studentNr);
        System.out.println("");
        for (Submission submission : subs) {
            System.out.println(submission.printSub(course.maxExes(submission.getWeek())));
        }

        String urlStats = "https://studies.cs.helsinki.fi/ohtustats/stats";
        String bodyTextStats = Request.Get(urlStats).execute().returnContent().asString();
        JsonParser parser = new JsonParser();
        JsonObject parsittudata = parser.parse(bodyTextStats).getAsJsonObject();

        int tehtavat = 0;
        int palautukset = 0;

        for (int j = 1; j <= parsittudata.size(); j++) {
            palautukset += parsittudata.get(j + "").getAsJsonObject().get("students").getAsInt();
            tehtavat += parsittudata.get(j + "").getAsJsonObject().get("exercise_total").getAsInt();
        }

        System.out.println("\n Kurssilla yhteensä " + palautukset + " palautusta, palautettuja tehtäviä " + tehtavat + " kpl");

    }
}
