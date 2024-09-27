package com.example.project;

public class LinkedList<T> implements List<T>{
	private Node<T> head;
	private Node<T> current;
	
    public LinkedList() {
		head = current = null;
	}
	public boolean empty() {
		return head == null;
	}
	public boolean last() {
		return current.next == null;
	}
    public boolean full() {
        return false;
    }
    public void findFirst() {
        current = head;
    }
    public void findNext() {
        current = current.next;
    }
    public T retrieve() {
        return current.data;
    }
    public void update(T e) {
        current.data = e;
    }
    public void insert(T e) {
        if (empty()) {
            current = head = new Node<T>(e);
        } else {
            Node<T> tmp = current.next;
            current.next = new Node<T>(e);
            current = current.next;
            current.next = tmp;
        }
    }
    public void remove() {
        if (current == head) {
            head = head.next;
        } else {
            Node<T> tmp = head;
            while (tmp.next != current) {
                tmp = tmp.next;
            }
            tmp.next = current.next;
        }
        if (current.next == null) {
            current = head;
        } else {
            current = current.next;
        }
    }
    public T mostFrequentElement() {
        if (head.next == null) {
            return head.data;
        }
        T mostFreq = null;
        int highestFreq = 0;
        Node<T> runner = head;

        while (runner.next != null) {
            int frequency = 0;
            Node<T> tmp = runner;
            while (tmp.next != null) {
                if (tmp.data == runner.data) {
                    frequency++;
                }
                tmp = tmp.next;
            }
            if (tmp.data == runner.data) {
                frequency++;
            }
            if (frequency > highestFreq) {
                mostFreq = runner.data;
                highestFreq = frequency;
            }
            runner = runner.next;
        }
        return mostFreq;
    }
}