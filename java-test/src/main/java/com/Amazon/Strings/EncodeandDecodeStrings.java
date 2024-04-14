package com.Amazon.Strings;

import java.util.List;
import java.util.stream.Collectors;

public class EncodeandDecodeStrings {
    public class EncodeDecode {
        /*
         * @param strs: a list of strings
         * @return: encodes a list of strings to a single string.
         */
        public String encode(List<String> strs) {
            return strs.stream().collect(Collectors.joining(":;"));
        }

        /*
         * @param str: A string
         * @return: decodes a single string to a list of strings
         */
        public List<String> decode(String str) {
            return List.of(str.split(":;"));
        }
    }
}
