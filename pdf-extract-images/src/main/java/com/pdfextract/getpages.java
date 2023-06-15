package com.pdfextract;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.util.List;

public class getpages {
    protected void run(String fileName, String extract, String begin, String end) {
        try {
            PDDocument document = PDDocument.load(new File(fileName));
            Splitter splitter = new Splitter();
            List<PDDocument> Pages = splitter.split(document);
            PDDocument page = new PDDocument();
            for (int i = Integer.parseInt(begin) - 1; i <= Integer.parseInt(end) - 1; ++i) {
                page.addPage(Pages.get(i).getPage(0));

                System.out.println("saved");
            }
            page.save(extract + "\\" + "your_pages" + begin + "-" + end + ".pdf");
            document.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
