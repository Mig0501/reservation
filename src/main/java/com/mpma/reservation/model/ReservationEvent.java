package com.mpma.reservation.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public final class ReservationEvent {

    // ========== ATRIBUTOS FINAL (INMUTABLES) ==========
    private final String id;
    private final String passengerName;
    private final Double price;
    private final List<String> emails;

    // ========== CONSTRUCTOR CON COPIA DEFENSIVA ==========
    public ReservationEvent(String id, String passengerName, Double price, List<String> emails) {
        // Validaciones para evitar nulos
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.passengerName = Objects.requireNonNull(passengerName, "El nombre no puede ser nulo");
        this.price = Objects.requireNonNull(price, "El precio no puede ser nulo");

        // COPIA DEFENSIVA: Crear una NUEVA lista inmutable
        this.emails = emails != null
                ? Collections.unmodifiableList(new ArrayList<>(emails))
                : Collections.emptyList();
    }

    // ========== GETTERS (SIN SETTERS) ==========
    public String getId() {
        return id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Double getPrice() {
        return price;
    }

    // Getter con COPIA DEFENSIVA para la lista
    public List<String> getEmails() {
        return new ArrayList<>(emails);
    }

    // ========== MÉTODOS ÚTILES ==========
    @Override
    public String toString() {
        return String.format("ReservationEvent{id='%s', passenger='%s', price=%.2f, emails=%d}",
                id, passengerName, price, emails.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationEvent that = (ReservationEvent) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}