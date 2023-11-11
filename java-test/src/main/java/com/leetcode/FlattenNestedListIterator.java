package com.leetcode;

import java.util.*;

public class FlattenNestedListIterator {
    private class NestedInteger {
        public boolean isInteger() {
            return true;
        }

        public List<NestedInteger> getList() {
            return new ArrayList<>();
        }

        public Integer getInteger() {
            return 0;
        }
    }

    public class NestedIterator implements Iterator<Integer> {
        Deque<NestedInteger> deque = new ArrayDeque<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            prepareDeque(nestedList);
        }

        private void prepareDeque(List<NestedInteger> nestedIteratorList) {
            for (int i = nestedIteratorList.size() - 1; i >= 0; --i)
                this.deque.push(nestedIteratorList.get(i));
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                return null;
            }
            return this.deque.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!this.deque.isEmpty() && !this.deque.peek().isInteger()) {
                List<NestedInteger> list = this.deque.pop().getList();
                prepareDeque(list);
            }
            return !this.deque.isEmpty();
        }
    }
}
