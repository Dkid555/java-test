package com.pdfedit.service;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;


@Service
public class mergepdf {
    public void mergeMore(List<String> filenames, String PATHtoMERGE, String PATHtoUPLOADtoMerge) {
        try {

            PDFMergerUtility pdfmerge = new PDFMergerUtility();
            pdfmerge.setDestinationFileName(PATHtoMERGE + "\\" + "merged.pdf");
            for (String file : filenames
            ) {
                pdfmerge.addSource(new File(PATHtoUPLOADtoMerge + "\\" + file));
            }
            pdfmerge.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
            System.out.println("pdf are merged");

            System.out.println(PATHtoMERGE);
            System.out.println(PATHtoUPLOADtoMerge);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
