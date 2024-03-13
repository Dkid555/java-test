package com.meta.other;

import java.util.HashMap;
import java.util.Map;

public class LRU_cache {
    private class Node {
        public int key; // Ключ узла
        public int val; // Значение узла
        public Node next; // Ссылка на следующий узел
        public Node prev; // Ссылка на предыдущий узел

        public Node(int key, int val) {
            this.key = key; // Инициализация ключа
            this.val = val; // Инициализация значения
            next = null; // Изначально следующий узел отсутствует
            prev = null; // Изначально предыдущий узел отсутствует
        }
    }

    private class LRUCache {
        private Map<Integer, Node> m; // Хранилище для хранения ключей и связанных с ними узлов
        private Node head; // Головной узел
        private Node tail; // Хвостовой узел
        private int size; // Размер кэша

        public LRUCache(int capacity) {
            size = capacity; // Устанавливаем размер кэша
            m = new HashMap<>(); // Создаем новую хэш-таблицу для хранения узлов
            head = new Node(-1, -1); // Создаем фиктивный головной узел
            tail = new Node(-1, -1); // Создаем фиктивный хвостовой узел
            head.next = tail; // Связываем головной узел с хвостовым
            tail.prev = head; // Связываем хвостовой узел с головным
        }

        // Удаление узла из списка
        private void deleteNode(Node p) {
            Node pre = p.prev; // Получаем предыдущий узел
            Node nex = p.next; // Получаем следующий узел
            pre.next = nex; // Переподключаем ссылку на следующий узел
            nex.prev = pre; // Переподключаем ссылку на предыдущий узел
        }

        // Добавление узла в начало списка
        private void addNode(Node newnode) {
            Node temp = head.next; // Сохраняем ссылку на текущий первый узел
            head.next = newnode; // Головной узел ссылается на новый узел
            newnode.prev = head; // Новый узел ссылается на головной узел
            newnode.next = temp; // Новый узел ссылается на предыдущий первый узел
            temp.prev = newnode; // Предыдущий первый узел ссылается на новый узел
        }

        // Получение значения по ключу
        public int get(int key) {
            if (!m.containsKey(key)) // Если ключ не найден в кэше
                return -1; // Возвращаем -1

            Node p = m.get(key); // Получаем узел по ключу
            deleteNode(p); // Удаляем узел из списка
            addNode(p); // Добавляем узел в начало списка
            m.put(key, head.next); // Обновляем запись в хэш-таблице
            return head.next.val; // Возвращаем значение узла
        }

        // Добавление значения по ключу
        public void put(int key, int value) {
            if (m.containsKey(key)) { // Если ключ уже существует в кэше
                Node c = m.get(key); // Получаем узел по ключу
                deleteNode(c); // Удаляем узел из списка
                c.val = value; // Обновляем значение узла
                addNode(c); // Добавляем узел в начало списка
                m.put(key, head.next); // Обновляем запись в хэш-таблице
            } else { // Если ключ не существует в кэше
                if (m.size() == size) { // Если кэш полон
                    Node prev = tail.prev; // Получаем последний узел
                    deleteNode(prev); // Удаляем последний узел из списка
                    Node l = new Node(key, value); // Создаем новый узел с указанным ключом и значением
                    addNode(l); // Добавляем новый узел в начало списка
                    m.remove(prev.key); // Удаляем запись о последнем узле из хэш-таблицы
                    m.put(key, head.next); // Обновляем запись о новом узле в хэш-таблице
                } else { // Если кэш не полон
                    Node l = new Node(key, value); // Создаем новый узел с указанным ключом и значением
                    addNode(l); // Добавляем новый узел в начало списка
                    m.put(key, head.next); // Обновляем запись о новом узле в хэш-таблице
                }
            }
        }
    }
}
//Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
//
//Implement the LRUCache class:
//
//LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
//int get(int key) Return the value of the key if the key exists, otherwise return -1.
//void put(int key, int value) Update the value of the key if the key exists.
// Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
//The functions get and put must each run in O(1) average time complexity.