package com.Amazon;

import java.util.*;

public class SubstringwithConcatenationofAllWords {
    public static void main(String[] args) {
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    }
//    public static List<Integer> findSubstring(String s, String[] words) {
//        if(s.length() < words.length)
//            return new ArrayList<>();
//        Map<String, Integer> words_map = new HashMap<>();
//        for (String word : words){
//            words_map.put(word, words_map.getOrDefault(word, 0) + 1);
//        }
//        List<Integer> list = new ArrayList<>();
//        boolean map_size = false;
//        if(words_map.size() == 1){
//            String to_search = words[0].repeat(words.length);
//            words_map.clear();
//            words_map.put(to_search, 1);
//            map_size = true;
//        }
//
//        for (int i = 0; i < s.length(); ++i){
//            boolean[] check = {false};
//            String[] start_word = {""};
//            check_if_possible(words_map, i, s, check, start_word);
//            if(check[0]){
//                list.add(i);
//            }
////            if(!map_size && !start_word[0].isEmpty())
////                i += start_word[0].length() - 1;
//        }
//
//
//        return list;
//    }
//
//    private static void check_if_possible(Map<String, Integer> map_of_words, int start, String s, boolean[] check, String[] start_word) {
//        if(map_of_words.isEmpty()){
//            check[0] = true;
//            return;
//        }
//        if(check[0])
//            return;
//        String substring = s.substring(start);
//        Set<String> words = Set.copyOf(map_of_words.keySet());
//        for(String key : words){
//            if(substring.startsWith(key)){
////                if(start_word[0] == ""){
////                    start_word[0] = key;
////                }
//                map_of_words.put(key, map_of_words.get(key) - 1);
//                if(map_of_words.get(key) == 0)
//                    map_of_words.remove(key);
//                check_if_possible(map_of_words, key.length(), substring, check, start_word);
//                map_of_words.put(key, map_of_words.getOrDefault(key, 0) + 1);
//            }
//        }
//    }
    public static List<Integer> findSubstring(String s, String[] words) {
        if(s.length() < words.length)
            return new ArrayList<>();
        Map<String, Integer> words_map = new HashMap<>();
        for (String word : words){
            words_map.put(word, words_map.getOrDefault(word, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        if(words_map.size() == 1){
            String to_search = words[0].repeat(words.length);
            words_map.clear();
            words_map.put(to_search, 1);
        }

        for (int i = 0; i < s.length(); ++i){
            boolean[] check = {false};
            String[] start_word = {""};
            check_if_possible(words_map, i, s, check);
            if(check[0]){
                list.add(i);
            }
        }


        return list;
    }

    private static void check_if_possible(Map<String, Integer> map_of_words, int start, String s, boolean[] check) {
        if(map_of_words.isEmpty()){
            check[0] = true;
            return;
        }
        if(check[0])
            return;
        String substring = s.substring(start);
        Set<String> words = Set.copyOf(map_of_words.keySet());
        for(String key : words){
            if(substring.startsWith(key)){
                map_of_words.put(key, map_of_words.get(key) - 1);
                if(map_of_words.get(key) == 0)
                    map_of_words.remove(key);
                check_if_possible(map_of_words, key.length(), substring, check);
                map_of_words.put(key, map_of_words.getOrDefault(key, 0) + 1);
            }
        }
    }
}
