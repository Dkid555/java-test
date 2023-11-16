package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileinSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String fullPaths : paths
        ) {
            String[] All = fullPaths.split(" ");
            String Path = All[0];
            String extra = Path.charAt(paths.length - 1) == '/' ? "" : "/";
            for (int i = 1; i < All.length; ++i) {
                String[] fileNames = All[i].split("\\(");
                String fileName = fileNames[0];
                String content = fileNames[1];
                List<String> list = map.getOrDefault(content, new ArrayList<>());

                list.add(Path + extra + fileName);
                map.put(content, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1)
                result.add(entry.getValue());
        }
        return result;
    }

    public List<List<String>> findDuplicate2(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> hashmap = new HashMap<>();
        for (String path : paths) {
            String[] fullPaths = path.split(" ");
            String dirrectory = fullPaths[0];
            for (int i = 1; i < fullPaths.length; i++) {
                StringBuilder content = new StringBuilder();
                int j = 0;
                for (j = fullPaths[i].length() - 2; j >= 0 && fullPaths[i].charAt(j) != '('; j--) {
                    content.insert(0, fullPaths[i].charAt(j));
                }

                String fileName = fullPaths[i].substring(0, j);
                hashmap.putIfAbsent(content.toString(), new ArrayList<>());
                hashmap.get(content.toString()).add(dirrectory + "/" + fileName);
            }
        }

        for (String string : hashmap.keySet()) {
            if (hashmap.get(string).size() >= 2) {
                result.add(new ArrayList<>(hashmap.get(string)));
            }
        }
        return result;
    }
}
