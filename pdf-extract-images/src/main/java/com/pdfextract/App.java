package com.pdfextract;


import org.apache.pdfbox.contentstream.PDFStreamEngine;

import java.util.Scanner;

public class App extends PDFStreamEngine {
    public static void main(String[] args) throws Exception {
        System.out.println("What would you like to do with pdf:"
                + "\n1 - Extract all images\n");
        String inp = new Scanner(System.in).nextLine();
        if (inp.equals("1")) {
            System.out.println("Put file path + name:\n");
            String file = new Scanner(System.in).nextLine();
            System.out.println("Extraction path:\n");
            String path = new Scanner(System.in).nextLine();
            new pdfextractallimages().extractpdf(file, path);
        }
    }
}
