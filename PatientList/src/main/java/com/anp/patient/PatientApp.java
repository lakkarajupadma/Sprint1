package com.anp.patient;

import java.util.List;// pre-defined package in java
import java.util.Optional;// pre-defined package in java
import org.hibernate.HibernateException;// pre-defined package in java
import jakarta.persistence.EntityManager;// pre-defined package in java
import jakarta.persistence.EntityManagerFactory;// pre-defined package in java
import jakarta.persistence.Persistence;// pre-defined package in java

public class PatientApp{

	public static void main(String[] args) {
		
		EntityManagerFactory factory = null;
				
				
		try { 		
			factory  = Persistence.createEntityManagerFactory("lp");
					
			EntityManager em = factory.createEntityManager();
								
		System.out.println("------WELCOME TO Patient ManagementSystem------");
					
Patient P1 = new Patient (1, "Rama", "Devi", "Female","B-Positive",  "12-12-2023");
Patient P2 = new Patient(2, "Naveen", "kumar", "Male","O-Positive",  "20-12-2023");
Patient P3 = new Patient(3, "Jai", "Ram", "Male","AB-Positive", "26-12-2023");
Patient P4 = new Patient(4, "Hari", "Priya", "Female","A-Negative", "18-12-2023");			
					PatientDAO pDAO = new PatientDAO(em);
					pDAO.save(P1);
					pDAO.save(P2);
					pDAO.save(P3);
					pDAO.save(P4);
					System.out.println("Data added successfully");

					System.out.println("--------------------------");
					
					System.out.println(" Patient  details based on the id :");
					
					Optional<Patient> patientById = pDAO.findById(1);
					System.out.println(patientById);
					 
					
					System.out.println("--------------------------");
					
					System.out.println("Details of the Patients ");	
					System.out.println();
					List<Patient> allpat = pDAO.findAll();
					System.out.println(allpat);
					
					
					System.out.println("------------------");
				
					
					int  newid = 3;
					String newFirstName ="Jai" ;
					String newLastName = "Ram" ;
					String newgender = "Male"  ;
					String newbloodGroup = "AB-Positive";
					String newAppointmentdate  ="26-12-2023";
					
pDAO.updatePatient(newid, newFirstName, newLastName,newgender, newbloodGroup, newAppointmentdate);
					
					System.out.println("Data updated sucessfully");
					
					
					System.out.println("------------------"); 
					
					System.out.println("Removeing based on the id :");
					
					pDAO.remove(1);
					
					System.out.println("2nd record is removed");
					
					
				}
				catch (HibernateException e) {
					 e.printStackTrace();
				}
				catch (Exception e) {
				 e.printStackTrace();
				}
	           }
              }