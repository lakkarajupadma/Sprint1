package com.anp.patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class DoctorDAO {

    private EntityManager em;

    public DoctorDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Doctor doctor) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Doctor mergedDoctor = em.merge(doctor);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(); // Log or handle the exception appropriately
        }
    }

    public Optional<Doctor> findById(int id) {
        Doctor doctor = em.find(Doctor.class, id);
        return Optional.ofNullable(doctor);
    }

    public List<Doctor> findAll() {
        return em.createQuery("from Doctor", Doctor.class).getResultList();
    }

    public void updateDoctor(int id, String newFirstName, String newLastName, String newSpecialization) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Doctor doctor = em.find(Doctor.class, id);
            if (doctor != null) {
                doctor.setDoctorFirstName(newFirstName);
                doctor.setDoctorLastName(newLastName);
                doctor.setSpecialization(newSpecialization);
                em.merge(doctor);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(); // Log or handle the exception appropriately
        }
    }

    public void remove(int id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Doctor doctor = em.find(Doctor.class, id);
            if (doctor != null) {
                em.remove(doctor);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(); // Log or handle the exception appropriately
        }
    }
}
