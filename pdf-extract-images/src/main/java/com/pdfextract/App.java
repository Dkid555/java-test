package com.pdfextract;


import org.apache.pdfbox.contentstream.PDFStreamEngine;

import java.util.Scanner;

public class App extends PDFStreamEngine {
    public static void main(String[] args) throws Exception {
//        while(true){
//        ExecutorService service = Executors.newFixedThreadPool(1);
//        service.submit(() -> {
//            System.out.println("What would you like to do with pdf:"
//                    + "\n1 - Extract all images\n" + "2 - Spit pdf\n"
//                    + "3 - get pages");
//            String inp = new Scanner(System.in).nextLine();
//            if (inp.equals("1")) {
//                System.out.println("Put file path + name:\n");
//                String file = new Scanner(System.in).nextLine();
//                System.out.println("Extraction path:\n");
//                String path = new Scanner(System.in).nextLine();
////            Path createpath = Files.createTempDirectory(path);
//                try {
//                    new pdfextractallimages().extractpdf(file, path);
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if (inp.equals("2")) {
//                System.out.println("Put file path + name:\n");
//                String file = new Scanner(System.in).nextLine();
//                System.out.println("Extraction path:\n");
//                String path = new Scanner(System.in).nextLine();
//                new pdfsplit().run(file, path);
//            }
//            if (inp.equals("3")) {
//                System.out.println("Put file path + name:\n");
//                String file = new Scanner(System.in).nextLine();
//                System.out.println("Extraction path:\n");
//                String path = new Scanner(System.in).nextLine();
//                System.out.println("Begin:\n");
//                String Begin = new Scanner(System.in).nextLine();
//                System.out.println("End:\n");
//                String End = new Scanner(System.in).nextLine();
//                new getpages().run(file, path, Begin, End);
//            }
//            service.shutdown();
//        }
//        );
//        }

        System.out.println("What would you like to do with pdf:"
                + "\n1 - Extract all images\n" + "2 - Spit pdf\n"
                + "3 - get pages\n" + "4 - merge 2 pdf");
        String inp = new Scanner(System.in).nextLine();
        if (inp.equals("1")) {
            System.out.println("Put file path + name:\n");
            String file = new Scanner(System.in).nextLine().replaceAll("\"", "");
            System.out.println("Extraction path:\n");
            String path = new Scanner(System.in).nextLine();
//            Path createpath = Files.createTempDirectory(path);
            new pdfextractallimages().extractpdf(file, path);
        }
        if (inp.equals("2")) {
            System.out.println("Put file path + name:\n");
            String file = new Scanner(System.in).nextLine().replaceAll("\"", "");
            System.out.println("Extraction path:\n");
            String path = new Scanner(System.in).nextLine();
            new pdfsplit().run(file, path);
        }
        if (inp.equals("3")) {
            System.out.println("Put file path + name:\n");
            String file = new Scanner(System.in).nextLine().replaceAll("\"", "");
            System.out.println("Extraction path:\n");
            String path = new Scanner(System.in).nextLine();
            System.out.println("Begin:\n");
            String Begin = new Scanner(System.in).nextLine();
            System.out.println("End:\n");
            String End = new Scanner(System.in).nextLine();
            new getpages().run(file, path, Begin, End);
        }
        if (inp.equals("4")) {
            System.out.println("Put file1 path + name:\n");
            String file1 = new Scanner(System.in).nextLine().replaceAll("\"", "");
            System.out.println("Put file2 path + name:\n");
            String file2 = new Scanner(System.in).nextLine().replaceAll("\"", "");
            System.out.println("Destination:\n");
            String location = new Scanner(System.in).nextLine();
            new mergepdf().merge2(file1, file2, location);
        }
    }
}
