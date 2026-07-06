package com.mpma.reservation.util;

import com.mpma.reservation.model.ReservationEvent;

import java.util.function.Consumer;
import java.util.function.Predicate;


public class ReservationFilters {


    public static final Predicate<ReservationEvent> IS_VALID =
            event -> event.getPrice() > 0 && !event.getEmails().isEmpty();


    public static final Consumer<ReservationEvent> LOGGER =
            event -> System.out.printf("✅ Procesando: %s - %s (Precio: $%.2f)%n",
                    event.getId(), event.getPassengerName(), event.getPrice());
}