package hello;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class VtuFetch {
    public static void main(String[] args) throws Exception {
    	 Scanner in = new Scanner(System.in);
    	 String usn;
         System.out.println("Enter The USN");
         usn = in.nextLine();
         
         Document doc = Jsoup.connect("http://www.fastvturesults.com/check_new_results/"+usn).
        		userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.101 Safari/537.36").get();
        for (Element table : doc.select("table[id=scell]")) {
            for (Element row : table.select("tr:gt(0)")) {
               Elements tds = row.select("td:not([rowspan])");
               System.out.println("Semester"+" "+"Attempt"+" "+" "+"Total Marks"+" "+"     Result"+" "+"                          Percentage");
               System.out.println(tds.get(0).text() + "        " + tds.get(1).text()+"          "+ tds.get(2).text()+"            "+ tds.get(3).text()+"                              "+ tds.get(4).text());
            }
       }
    }
}