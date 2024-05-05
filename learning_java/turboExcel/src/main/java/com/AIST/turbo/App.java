package com.AIST.turbo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.apache.poi.ss.usermodel.*;
import java.io.*;

public class App {
    public static void main(String[] args) {
        Workbook work = new HSSFWorkbook();
        OutputStream outf = null;
        FileWriter fwrite = null;
        FileReader fread = null;
        try {
            outf = new FileOutputStream("/home/aydin/Documents/CarsInfo.xlsx");
            fwrite = new FileWriter("/home/aydin/Documents/PageNumber.txt");
            fread = new FileReader("/home/aydin/Documents/PageNumber.txt");

            Sheet sheet = work.createSheet("Cars_Sheet");

            // Read page number from file
            BufferedReader reader = new BufferedReader(fread);
            String pageNumberStr = reader.readLine();
            int pageNumber = 1; // Default page number
            if (pageNumberStr != null && !pageNumberStr.isEmpty()) {
                pageNumber = Integer.parseInt(pageNumberStr);
            }
            reader.close();

            int k = 0;
            while (k < 5) {
                String url = "https://turbo.az/autos";
                pageNumber += k; // Increment page number
                if (pageNumber > 1) {
                    url += "?page=" + pageNumber;
                }
                Document doc = Jsoup.connect(url).get();
                Elements carLinks = doc.getElementsByAttributeValue("class", "products-i__link");

                int i = 0;
                for (Element carLink : carLinks) {
                    String urlCar = carLink.attr("href");
                    Document docCar = Jsoup.connect(urlCar).get();
                    Elements properties = docCar.getElementsByAttributeValue("class", "product-properties__i-value");
                    Row row = sheet.createRow(i);
                    int j = 0;
                    for (Element property : properties) {
                        String prop = property.text();
                        Cell cell = row.createCell(j);
                        cell.setCellValue(prop);
                        j++;
                    }
                    i++;
                }

                k++;
            }

            // Write updated page number back to file
            BufferedWriter writer = new BufferedWriter(fwrite);
            writer.write(Integer.toString(pageNumber));
            writer.close();

            // Write workbook to file
            work.write(outf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outf != null) {
                    outf.close();
                }
                if (fwrite != null) {
                    fwrite.close();
                }
                if (fread != null) {
                    fread.close();
                }
                if (work != null) {
                    work.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}