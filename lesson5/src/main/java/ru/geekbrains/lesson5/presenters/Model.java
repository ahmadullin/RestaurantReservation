package ru.geekbrains.lesson5.presenters;

import ru.geekbrains.lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {
    Collection<Table> loadTables();

    /**
     * Бронирование столика
     * @param reservationDate Дата бронирования
     * @param tableNo Номер столика
     * @param name Имя клиента
     */
    int reservationTable(Date reservationDate, int tableNo, String name);

    /**
     *
     * @param oldReservationDate Старая дата бронирования
     * @param oldTableNo Старый номер столика
     * @param newReservationDate Новая дата бронирования
     * @param newTableNo Новый номер столика
     * @param name Имя клиента
     */
    int changeReservationTable(Date oldReservationDate, int oldTableNo, Date newReservationDate, int newTableNo, String name);
}
