package com.leetcode;

public class DesignBrowserHistory {


    private static class BrowserHistory {

        private static class TwoWayListNode {
            String url;
            TwoWayListNode nextPage;
            TwoWayListNode previousPage;

            public TwoWayListNode(String url, TwoWayListNode nextPage, TwoWayListNode previousPage) {
                this.url = url;
                this.nextPage = nextPage;
                this.previousPage = previousPage;
            }
        }

        TwoWayListNode history;

        public BrowserHistory(String homepage) {
            this.history = new TwoWayListNode(homepage, null, null);
        }

        public void visit(String url) {
            this.history.nextPage = new TwoWayListNode(url, null, this.history);
            this.history = this.history.nextPage;
        }

        public String back(int steps) {
            while (steps > 0) {
                --steps;
                if (this.history.previousPage != null)
                    this.history = this.history.previousPage;
                else
                    break;
            }

            return this.history.url;
        }

        public String forward(int steps) {
            while (steps > 0) {
                --steps;
                if (this.history.nextPage != null)
                    this.history = this.history.nextPage;
                else
                    break;
            }
            return this.history.url;
        }
    }

    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory("google.com");
        history.visit("Petco.com");
        history.visit("Brightline.com");
        history.visit("vk.com");
        history.visit("plitkazavr.ru");
        history.visit("4pda.to");
        System.out.println(history.back(3));
        System.out.println(history.forward(10));
    }
}
