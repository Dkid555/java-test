package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DesignanOrderedStream {

    class OrderedStream {
        public String[] stream;
        public int ptr = 0;

        public OrderedStream(int n) {
            stream = new String[n];
        }

        public List<String> insert(int idKey, String value) {
            stream[idKey - 1] = value;
            List<String> chunk = new ArrayList<>();
            while (ptr < stream.length && stream[ptr] != null) {
                chunk.add(stream[ptr]);
                ptr++;
            }
            return chunk;
        }
    }
}
