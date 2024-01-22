package com.anp.patient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PatientApp {

    public static void main(String[] args) {
        EntityManagerFactory factory = null;

        try {
            factory = Persistence.createEntityManagerFactory("lp");

            EntityManager em = factory.createEntityManager();

            System.out.println("------WELCOME TO Patient Management System------");

            // Creating Patient objects
            Patient patient1 = new Patient(1, "Rama", "Devi", "Female", "B-Positive", LocalDate.parse("2023-12-12"));
            Patient patient2 = new Patient(2, "Naveen", "kumar", "Male", "O-Positive", LocalDate.parse("2023-12-20"));
            Patient patient3 = new Patient(3, "Jai", "Ram", "Male", "AB-Positive", LocalDate.parse("2023-12-26"));
            Patient patient4 = new Patient(4, "Hari", "Priya", "Female", "A-Negative", LocalDate.parse("2023-12-18"));

            PatientDAO patientDAO = new PatientDAO(em);

            patientDAO.save(patient1);
            patientDAO.save(patient2);
            patientDAO.save(patient3);
            patientDAO.save(patient4);

            System.out.println("Data added successfully");
            System.out.println("--------------------------");

            // Creating Doctor objects
            Doctor doctor1 = new Doctor(1, "John", "Doe", "Cardiologist");
            Doctor doctor2 = new Doctor(2, "Jane", "Smith", "Orthopedic Surgeon");
            Doctor doctor3 = new Doctor(3, "Luna", "Rosie", "Dermatologist");
            Doctor doctor4 = new Doctor(4, "Ruby", "Mie", "Neurologist");
            
            DoctorDAO doctorDAO = new DoctorDAO(em);

            doctorDAO.save(doctor1);
            doctorDAO.save(doctor2);
            doctorDAO.save(doctor3);
            doctorDAO.save(doctor4);

            System.out.println("Doctor data added successfully");
            System.out.println("--------------------------");

            // Creating Appointment objects
            Appointment appointment1 = new Appointment(1, patient1, doctor1, LocalDateTime.parse("2023-12-12T10:00"));
            Appointment appointment2 = new Appointment(2, patient2, doctor2, LocalDateTime.parse("2023-12-20T14:30"));
            Appointment appointment3 = new Appointment(3, patient3, doctor1, LocalDateTime.parse("2023-12-15T09:30"));
            Appointment appointment4 = new Appointment(4, patient4, doctor2, LocalDateTime.parse("2023-12-22T16:45"));

            
            AppointmentDAO appointmentDAO = new AppointmentDAO(em);

            appointmentDAO.save(appointment1);
            appointmentDAO.save(appointment2);
            appointmentDAO.save(appointment3);
            appointmentDAO.save(appointment4);

            System.out.println("Appointment data added successfully");
            System.out.println("--------------------------");

            // Retrieving and printing patient details based on ID
            System.out.println("Patient details based on ID:");
            Optional<Patient> patientById = patientDAO.findById(1);
            System.out.println(patientById.orElse(null));
            System.out.println("--------------------------");

            // Retrieving and printing all patients
            System.out.println("Details of all Patients:");
            List<Patient> allPatients = patientDAO.findAll();
            allPatients.forEach(System.out::println);
            System.out.println("--------------------------");

            // Retrieving and printing all doctors
            System.out.println("Details of all Doctors:");
            List<Doctor> allDoctors = doctorDAO.findAll();
            allDoctors.forEach(System.out::println);
            System.out.println("--------------------------");

            // Retrieving and printing all appointments
            System.out.println("Details of all Appointments:");
            List<Appointment> allAppointments = appointmentDAO.findAll();
            allAppointments.forEach(System.out::println);
            System.out.println("--------------------------");

            // Updating patient data
            int updatedPatientId = 3;
            String updatedFirstName = "UpdatedJai";
            String updatedLastName = "UpdatedRam";
            String updatedGender = "UpdatedMale";
            String updatedBloodGroup = "UpdatedAB-Positive";
            LocalDate updatedAppointmentDate = LocalDate.parse("2023-12-27");

            patientDAO.updatePatient(updatedPatientId, updatedFirstName, updatedLastName, updatedGender, updatedBloodGroup, updatedAppointmentDate);

            System.out.println("Data updated successfully");
            System.out.println("--------------------------");

            // Removing patient based on ID
            int patientToRemoveId = 1;
            patientDAO.remove(patientToRemoveId);

            System.out.println("Patient record removed successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}
