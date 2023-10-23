package com.leet_easy;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int result = 0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].contentEquals("./"))
                continue;
            switch (logs[i]) {
                case "../" -> {
                    if (result > 0)
                        --result;
                }
                default -> {
                    ++result;
                }
            }
        }
        return result;

    }
}
