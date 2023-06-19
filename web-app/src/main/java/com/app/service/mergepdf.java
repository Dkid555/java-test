package com.app.service;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.util.List;

public class mergepdf {
    public void merge2(String file1, String file2) {
        try {
            PDFMergerUtility pdfmerge = new PDFMergerUtility();
            pdfmerge.setDestinationFileName("C:\\Users\\dima\\Downloads" + "\\" + "merged.pdf");
            pdfmerge.addSource(new File(file1));
            pdfmerge.addSource(new File(file2));
            pdfmerge.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
            System.out.println("pdf are merged");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Upgraded, now unlimited files allowed
    public void mergeMore(List<String> filenames) {
        try {
            PDFMergerUtility pdfmerge = new PDFMergerUtility();
            pdfmerge.setDestinationFileName("C:\\Users\\dima\\Downloads" + "\\" + "merged.pdf");
            for (String file : filenames
            ) {
                pdfmerge.addSource(new File("C:\\test_upload\\" + file));
            }
            pdfmerge.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
            System.out.println("pdf are merged");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
