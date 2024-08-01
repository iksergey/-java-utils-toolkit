package ru.ksergey.data;

import ru.ksergey.exception.EmptyStorageException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Storage<T extends Number> {
    private final List<T> items;

    public Storage() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть null");
        }
        items.add(item);
    }

    public T getItem(int index) throws EmptyStorageException {
        if (items.isEmpty()) {
            throw new EmptyStorageException("Хранилище пустое");
        }
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Индекс вышел за пределы");
        }
        return items.get(index);
    }

    public T removeItem(int index) throws EmptyStorageException {
        if (items.isEmpty()) {
            throw new EmptyStorageException("Хранилище пусто");
        }
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Индекс вышел за пределы");
        }
        return items.remove(index);
    }

    public <U extends Number> double sum() {
        double sum = 0.0;
        for (T item : items) {
            sum += item.doubleValue();
        }
        return sum;
    }

    public void addAll(Collection<? extends T> producers) {
        if (producers == null) {
            throw new IllegalArgumentException("Коллекция не может быть null");
        }
        items.addAll(producers);
    }

    public void populateAll(Collection<? super T> consumers) {
        if (consumers == null) {
            throw new IllegalArgumentException("Коллекция не может быть null");
        }
        consumers.addAll(items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Storage<?> storage = (Storage<?>) o;
        return Objects.equals(items, storage.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}
