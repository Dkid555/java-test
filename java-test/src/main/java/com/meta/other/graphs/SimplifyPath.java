package com.meta.other.graphs;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
    public String simplifyPath(String path) {
        List<String> paths = new ArrayList<>(List.of(path.split("/")));
        int length = paths.size();
        for (int i = 0; i < length; ++i) {
            switch (paths.get(i)) {
                case ".", "" -> {
                    paths.remove(i--);
                    --length;

                }
                case ".." -> {
                    if (i != 0) {
                        paths.remove(--i);
                        --length;
                    }
                    paths.remove(i--);
                    --length;
                }
            }
        }
        return "/" + String.join("/", paths);
    }
}
