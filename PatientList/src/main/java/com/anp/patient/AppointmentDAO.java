package com.anp.patient;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;  // Add this line
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AppointmentDAO {

    private EntityManager em;

    public AppointmentDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Appointment appointment) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Appointment mergedAppointment = em.merge(appointment);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public Optional<Appointment> findById(int id) {
        Appointment appointment = em.find(Appointment.class, id);
        return Optional.ofNullable(appointment);
    }

    public List<Appointment> findAll() {
        return em.createQuery("from Appointment", Appointment.class).getResultList();
    }

    public void updateAppointment(int id, LocalDateTime newDateTime) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Appointment appointment = em.find(Appointment.class, id);
            if (appointment != null) {
                appointment.setAppointmentDateTime(newDateTime);
                em.merge(appointment);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void remove(int id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Appointment appointment = em.find(Appointment.class, id);
            if (appointment != null) {
                em.remove(appointment);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}
