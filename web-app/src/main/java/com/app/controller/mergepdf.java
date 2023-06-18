package com.app.controller;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;

public class mergepdf {
    protected void merge2(String file1, String file2) {
        try {
            PDFMergerUtility pdfmerge = new PDFMergerUtility();
//            MemoryUsageSetting memoryUsageSetting = null;
            pdfmerge.setDestinationFileName("C:\\Users\\dima\\Downloads" + "\\" + "merged.pdf");
            pdfmerge.addSource(new File(file1));
            pdfmerge.addSource(new File(file2));
            pdfmerge.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
            System.out.println("pdf are merged");
//            return pdfmerge.getDestinationStream();
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
