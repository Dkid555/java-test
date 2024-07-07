package com.Amazon;

public class DesignaTextEditor {

    public static void main(String[] args) {
        TextEditor text = new TextEditor();
//["TextEditor", "addText", "deleteText", "addText", "cursorRight", "cursorLeft", "deleteText", "cursorLeft", "cursorRight"]
//[[], ["leetcode"], [4], ["practice"], [3], [8], [10], [2], [6]]
        text.addText("com/javatest/leetcode");
        System.out.println(text.deleteText(4));
        text.addText("practice");
        System.out.println(text.cursorRight(3));
        System.out.println(text.cursorLeft(8));
        System.out.println(text.deleteText(10));
        System.out.println(text.cursorLeft(2));
        System.out.println(text.cursorRight(6));
        //[null, null, 4, null, "etpractice", "leet", 4, "", "practi"]
    }
    private static class TextEditor {
        private final StringBuilder text;
        private int cursor;
        public TextEditor() {
            this.text = new StringBuilder();
            this.cursor = 0;
        }

        public void addText(String text) {
            this.text.insert(this.cursor, text);
            this.cursor += text.length();
        }

        public int deleteText(int k) {
            int prev = this.text.length();
            this.text.delete(Math.max(this.cursor - k, 0), this.cursor);
            this.cursor = Math.max(this.cursor - k, 0);
            return prev - this.text.length();
        }

        public String cursorLeft(int k) {
            this.cursor = Math.max(this.cursor - k, 0);
            return this.text.substring(Math.max(0, this.cursor - 10), this.cursor);
        }

        public String cursorRight(int k) {
            this.cursor = Math.min(this.cursor + k, this.text.length());
            return this.text.substring(Math.max(0, this.cursor - 10), this.cursor);
        }
    }
}
