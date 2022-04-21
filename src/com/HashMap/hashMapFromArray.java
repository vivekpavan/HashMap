package com.HashMap;

import java.util.LinkedList;

public class hashMapFromArray {
    private class Entry{
        private int key;
        private String value;
        public Entry(int key,String value){
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Entry>[] array;
    private int capacity;
    public hashMapFromArray(int capacity){
        this.capacity = capacity;
        array = new LinkedList[capacity];
    }
    //I have not refactored the put method
    public void put(int key,String value){
        var index = hash(key);
        if(array[index] == null)
            array[index] = new LinkedList<>();

        var bucket = array[index];
        for(var entry : bucket){
            if(entry.key == key) {
                entry.value = value;
                return;
            }
        }
        var entry = new Entry(key,value);
        array[index].addLast(entry);
    }
    public String get(int key) {
        var entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    public void remove(int key){
        var entry = getEntry(key);
        if(entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    private LinkedList<Entry> getBucket(int key){
        return array[hash(key)];
    }

    private Entry getEntry(int key){
        var bucket = getBucket(key);
        if(bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
            return null;
    }
    private int hash(int key){
        return key % capacity;
    }

}
