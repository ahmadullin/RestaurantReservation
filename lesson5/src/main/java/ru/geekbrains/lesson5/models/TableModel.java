package ru.geekbrains.lesson5.models;

import ru.geekbrains.lesson5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    /**
     * Получить все столики
     * @return
     */
    public Collection<Table> loadTables(){
        if (tables == null)
        {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());

        }

        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate Дата бронирования
     * @param tableNo Номер столика
     * @param name Имя клиента
     */
    public int reservationTable(Date reservationDate, int tableNo, String name){
        for (Table table: tables) {
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика.");
    }

    /**
     * TODO: Разработать самостоятельно в рамках домашней работы
     * Поменять бронь столика
     */

    /**
     *
     * @param oldReservationDate Старая дата бронирования
     * @param oldTableNo Старый номер столика
     * @param newReservationDate Новая дата бронирования
     * @param newTableNo Новый номер столика
     * @param name Имя клиента
     */
    public int changeReservationTable(Date oldReservation, int oldTableNo, Date newReservationDate, int newTableNo, String name){
        int reservationId = reservationTable(newReservationDate, newTableNo, name);
        for (Table table: tables) {
            if (table.getNo() == oldTableNo){
                for (Reservation reservation : table.getReservations()) {
                    if (reservation.getDate().equals(oldReservation)) {
                        table.getReservations().remove(reservation);
                        break;
                    }
                }
                break;
            }
        }
        return reservationId;
    }

}
