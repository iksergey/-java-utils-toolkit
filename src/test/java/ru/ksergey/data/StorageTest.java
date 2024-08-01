package ru.ksergey.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ksergey.exception.EmptyStorageException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {

    private Storage<Integer> storage;

    @BeforeEach
    void setUp() {
        storage = new Storage<>();
    }

    @Test
    void addItemTestSuccessfullyAddsItem() throws EmptyStorageException {
        storage.addItem(5);
        Integer expected = 5;
        Integer actual = storage.getItem(0);

        assertEquals(expected, actual);
    }

    @Test
    void addItemTestThrowsExceptionForNullItem() {
        assertThrows(IllegalArgumentException.class, () -> storage.addItem(null));
    }

    @Test
    void getItemTestReturnsCorrectItem() throws EmptyStorageException {
        storage.addItem(10);
        storage.addItem(20);

        Integer expected1 = 10;
        Integer actual1 = storage.getItem(0);
        Integer expected2 = 20;
        Integer actual2 = storage.getItem(1);

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    void getItemTestThrowsExceptionForEmptyStorage() {
        assertThrows(EmptyStorageException.class, () -> storage.getItem(0));
    }

    @Test
    void getItemTestThrowsExceptionForInvalidIndex() {
        storage.addItem(5);
        assertThrows(IndexOutOfBoundsException.class, () -> storage.getItem(1));
    }

    @Test
    void removeItemTestSuccessfullyRemovesItem() throws EmptyStorageException {
        storage.addItem(5);
        storage.addItem(10);

        Integer expectedRemoved = 5;
        Integer actualRemoved = storage.removeItem(0);
        Integer expectedRemaining = 10;
        Integer actualRemaining = storage.getItem(0);

        assertEquals(expectedRemoved, actualRemoved);
        assertEquals(expectedRemaining, actualRemaining);
    }

    @Test
    void removeItemTestThrowsExceptionForEmptyStorage() {
        assertThrows(EmptyStorageException.class, () -> storage.removeItem(0));
    }

    @Test
    void removeItemTestThrowsExceptionForInvalidIndex() {
        storage.addItem(5);
        assertThrows(IndexOutOfBoundsException.class, () -> storage.removeItem(1));
    }

    @Test
    void sumTestCalculatesCorrectSum() {
        storage.addItem(5);
        storage.addItem(10);
        storage.addItem(15);

        double expected = 30.0;
        double actual = storage.sum();

        assertEquals(expected, actual, 0.001);
    }

    @Test
    void sumTestReturnsZeroForEmptyStorage() {
        double expected = 0.0;
        double actual = storage.sum();

        assertEquals(expected, actual, 0.001);
    }

    @Test
    void addAllTestSuccessfullyAddsAllItems() throws EmptyStorageException {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        storage.addAll(numbers);

        Integer expected1 = 1;
        Integer actual1 = storage.getItem(0);
        Integer expected2 = 2;
        Integer actual2 = storage.getItem(1);
        Integer expected3 = 3;
        Integer actual3 = storage.getItem(2);

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    @Test
    void addAllTestThrowsExceptionForNullCollection() {
        assertThrows(IllegalArgumentException.class, () -> storage.addAll(null));
    }

    @Test
    void populateAllTestSuccessfullyPopulatesCollection() {
        storage.addItem(1);
        storage.addItem(2);
        storage.addItem(3);
        List<Number> numbers = new ArrayList<>();
        storage.populateAll(numbers);

        List<Number> expected = Arrays.asList(1, 2, 3);
        List<Number> actual = numbers;

        assertEquals(expected, actual);
    }

    @Test
    void populateAllTestThrowsExceptionForNullCollection() {
        assertThrows(IllegalArgumentException.class, () -> storage.populateAll(null));
    }

    @Test
    void equalsTestReturnsTrueForEqualStorages() {
        Storage<Integer> storage1 = new Storage<>();
        Storage<Integer> storage2 = new Storage<>();
        storage1.addItem(1);
        storage1.addItem(2);
        storage2.addItem(1);
        storage2.addItem(2);

        boolean expected = true;
        boolean actual = storage1.equals(storage2);

        assertEquals(expected, actual);
    }

    @Test
    void equalsTestReturnsFalseForDifferentStorages() {
        Storage<Integer> storage1 = new Storage<>();
        Storage<Integer> storage2 = new Storage<>();
        storage1.addItem(1);
        storage2.addItem(2);

        boolean expected = false;
        boolean actual = storage1.equals(storage2);

        assertEquals(expected, actual);
    }

    @Test
    void hashCodeTestReturnsSameHashCodeForEqualStorages() {
        Storage<Integer> storage1 = new Storage<>();
        Storage<Integer> storage2 = new Storage<>();
        storage1.addItem(1);
        storage1.addItem(2);
        storage2.addItem(1);
        storage2.addItem(2);

        int expected = storage1.hashCode();
        int actual = storage2.hashCode();

        assertEquals(expected, actual);
    }
}