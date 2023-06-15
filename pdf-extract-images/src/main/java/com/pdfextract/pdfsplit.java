package com.pdfextract;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.util.List;

public class pdfsplit {
    protected void run(String fileName, String extract) {
        try {
            PDDocument document = PDDocument.load(new File(fileName));
            Splitter splitter = new Splitter();
            List<PDDocument> Pages = splitter.split(document);
            for (int i = 0; i < Pages.size(); ) {
                PDDocument page = Pages.get(i);
                page.save(extract + "\\" + (++i) + ".pdf");
                System.out.println("saved");
            }
            document.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
