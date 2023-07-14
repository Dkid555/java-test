package com.brot;

import com.aayushatharva.brotli4j.Brotli4jLoader;
import com.aayushatharva.brotli4j.decoder.BrotliInputStream;
import com.aayushatharva.brotli4j.encoder.BrotliOutputStream;
import com.aayushatharva.brotli4j.encoder.Encoder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void CompressBrotli(String filePath) throws IOException {
        Brotli4jLoader.ensureAvailability();

        FileInputStream inFile = new FileInputStream(filePath);
        FileOutputStream outFile = new FileOutputStream(filePath + ".br");

// If being used to compress streams in real-time, I do not advise a quality setting above 4 due to performance
        Encoder.Parameters params = new Encoder.Parameters().setQuality(10);

// Initialize compressor by binding it to our file output stream
        BrotliOutputStream brotliOutputStream = new BrotliOutputStream(outFile, params);

        int read = inFile.read();
        while (read > -1) { // -1 means EOF
            brotliOutputStream.write(read);
            read = inFile.read();
        }

// It's important to close the BrotliOutputStream object. This also closes the underlying FileOutputStream
        brotliOutputStream.close();
        inFile.close();
    }

    public static void Decompress(String filePath) throws IOException {
        Brotli4jLoader.ensureAvailability();

        FileInputStream inFile = new FileInputStream(filePath);
        FileOutputStream outFile = new FileOutputStream(filePath + ".min.css");

        BrotliInputStream brotliInputStream = new BrotliInputStream(inFile);

        int read = brotliInputStream.read();
        while (read > -1) {
            outFile.write(read);
            read = brotliInputStream.read();
        }

        // Close the BrotliInputStream. This also closes the FileInputStream.
        brotliInputStream.close();
        outFile.close();
    }


    public static void main(String[] args) throws IOException {
        String filePath = "C:\\test\\css\\test\\swiper.css";
        CompressBrotli(filePath);
        Decompress("C:\\test\\css\\test\\swiper.css.br");
    }
}
