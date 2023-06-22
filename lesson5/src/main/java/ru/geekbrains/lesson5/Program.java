package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.models.TableModel;
import ru.geekbrains.lesson5.presenters.BookingPresenter;
import ru.geekbrains.lesson5.presenters.Model;
import ru.geekbrains.lesson5.presenters.View;
import ru.geekbrains.lesson5.views.BookingView;

import java.util.Date;

public class Program {

    /**
     * TODO: Домашняя работа: Метод changeReservationTable ДОЛЖЕН ЗАРАБОТАТЬ!
     * @param args
     */
    public static void main(String[] args) {
        Model tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.showTables();

        // Клиент нажимает на кнопку "Зарезервировать", возбуждается событие,
        // вызывается метод reservationTable()

        bookingView.reservationTable(new Date(), 102, "Станислав");

        // Клиент нажимает на кнопку "Изменить бронь", возбуждается событие,
        // вызывается метод changeReservationTable()
        Date oldReservationDate = new Date();
        int oldTableNo = 102;
        Date newReservationDate = new Date();
        int newTableNo = 103;
        String name = "Станислав";
        bookingView.changeReservationTable(oldReservationDate, oldTableNo, newReservationDate, newTableNo, name);

        // Показать, что бронь была успешно изменена

    }

}
