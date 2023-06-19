package com.app.service;

import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class pdfextractallimages extends PDFStreamEngine {
    private int imageNumber = 1;

    public void setPATH1(String PATH1) {
        this.PATH1 = PATH1;
    }

    private String PATH1;

    public void extractpdf(String fileName, String extractPath) throws Exception {
        try {
            PDDocument document = PDDocument.load(new File(fileName));
            pdfextractallimages printer = new pdfextractallimages();
            printer.setPATH1(extractPath + "\\");
            int pageNum = 0;
            for (PDPage page : document.getPages()) {
                pageNum++;
                System.out.println("Processing page: " + pageNum);
                printer.processPage(page);
            }
            document.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void processOperator(Operator operator, List<COSBase> operands) throws IOException {
        String operation = operator.getName();
        if ("Do".equals(operation)) {
            COSName objectName = (COSName) operands.get(0);
            PDXObject xobject = getResources().getXObject(objectName);
            if (xobject instanceof PDImageXObject image) {

                // same image to local
                BufferedImage bImage = image.getImage();
                ImageIO.write(bImage, "PNG", new File(PATH1 + "image_" + imageNumber + ".png"));
                System.out.println("Image saved.");
                imageNumber++;

            } else if (xobject instanceof PDFormXObject form) {
                showForm(form);
            }
        } else {
            super.processOperator(operator, operands);
        }
    }
}
