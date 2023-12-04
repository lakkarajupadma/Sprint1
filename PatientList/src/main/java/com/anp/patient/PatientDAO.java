package com.anp.patient;

//Importing necessary packages and classes
import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PatientDAO {

 private EntityManager em;

 // Constructor to initialize the EntityManager
 public PatientDAO(EntityManager em) {
     this.em = em;
 }

 // Method to save a patient to the database
 public void save(Patient patient) {
     EntityTransaction tx = em.getTransaction();
     try {
         tx.begin();
         // Using merge instead of persist to handle detached entities
         Patient mergedPatient = em.merge(patient);
         tx.commit();
     } catch (Exception e) {
         if (tx != null && tx.isActive()) {
             tx.rollback();
         }
         e.printStackTrace(); // Log or handle the exception appropriately
     }
 }

 // Method to find a patient by ID
 public Optional<Patient> findById(int id) {
     Patient patient = em.find(Patient.class, id);
     return Optional.ofNullable(patient);
 }

 // Method to retrieve all patients from the database
 public List<Patient> findAll() {
     // Using JPQL to query for all patients
     return em.createQuery("from Patient", Patient.class).getResultList();
 }

 // Method to update patient information in the database
 public void updatePatient(int id, String newFirstName, String newLastName, String newGender, String newBloodGroup, String newAppointmentDate) {
     EntityTransaction tx = em.getTransaction();
     try {
         tx.begin();
         // Finding the patient by ID
         Patient patient = em.find(Patient.class, id);
         if (patient != null) {
             // Updating patient information
             patient.setPatientFirstName(newFirstName);
             patient.setPatientLastName(newLastName);
             patient.setGender(newGender);
             patient.setBloodGroup(newBloodGroup);
             patient.setAppointmentDate(newAppointmentDate);
             em.merge(patient);
         }
         tx.commit();
     } catch (Exception e) {
         if (tx != null && tx.isActive()) {
             tx.rollback();
         }
         e.printStackTrace(); // Log or handle the exception appropriately
     }
 }

 // Method to remove a patient from the database by ID
 public void remove(int id) {
     EntityTransaction tx = em.getTransaction();
     try {
         tx.begin();
         // Finding the patient by ID
         Patient patient = em.find(Patient.class, id);
         if (patient != null) {
             // Removing the patient from the database
             em.remove(patient);
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
