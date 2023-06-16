package com.pdfextract;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;

public class mergepdf {
    protected void merge2(String file1, String file2, String location) {
        try {
            PDFMergerUtility pdfmerge = new PDFMergerUtility();
//            MemoryUsageSetting memoryUsageSetting = null;
            pdfmerge.setDestinationFileName(location + "\\" + "merged.pdf");
            pdfmerge.addSource(new File(file1));
            pdfmerge.addSource(new File(file2));
            pdfmerge.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
            System.out.println("pdf are merged");
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
