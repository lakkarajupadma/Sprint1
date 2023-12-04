package com.anp.patient;


//Importing necessary annotations from Jakarta Persistence API
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Annotate the class as a JPA entity
@Entity
//Specify the table name for the entity
@Table(name = "patientex")
public class Patient {

 // Persistent field for patient id
 @Id
 // Generated value for the patient id using identity strategy
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int Patient_Id;

 // Column annotation specifying the column name for patient's first name
 @Column(name = "PATIENT_FRST_NAME")
 private String patientFirstName;

 // Column annotation specifying the column name for patient's last name
 @Column(name = "PATIENT_LAST_NAME")
 private String patientLastName;

 // Column annotation specifying the column name for patient's gender
 @Column(name = "GENDER")
 private String gender;

 // Column annotation specifying the column name for patient's blood group
 @Column(name = "BLOOD_GROUP")
 private String bloodGroup;

 // Column annotation specifying the column name for patient's appointment date
 @Column(name = "APPOINTMENT_DATE")
 private String appointmentDate;

 // Getter method for retrieving patient id
 public int getPatientId() {
     return Patient_Id;
 }

 // Setter method for setting patient id
 public void setPatientId(int patientId) {
     this.Patient_Id = patientId;
 }

 // Getter method for retrieving patient's first name
 public String getPatientFirstName() {
     return patientFirstName;
 }

 // Setter method for setting patient's first name
 public void setPatientFirstName(String patientFirstName) {
     this.patientFirstName = patientFirstName;
 }

 // Getter method for retrieving patient's last name
 public String getPatientLastName() {
     return patientLastName;
 }

 // Setter method for setting patient's last name
 public void setPatientLastName(String patientLastName) {
     this.patientLastName = patientLastName;
 }

 // Getter method for retrieving patient's gender
 public String getGender() {
     return gender;
 }

 // Setter method for setting patient's gender
 public void setGender(String gender) {
     this.gender = gender;
 }

 // Getter method for retrieving patient's blood group
 public String getBloodGroup() {
     return bloodGroup;
 }

 // Setter method for setting patient's blood group
 public void setBloodGroup(String bloodGroup) {
     this.bloodGroup = bloodGroup;
 }

 // Getter method for retrieving patient's appointment date
 public String getAppointmentDate() {
     return appointmentDate;
 }

 // Setter method for setting patient's appointment date
 public void setAppointmentDate(String appointmentDate) {
     this.appointmentDate = appointmentDate;
 }

 // Overriding the toString method to provide a custom string representation of the object
 @Override
 public String toString() {
     return "Patient[patientId=" + Patient_Id + ", patientFirstName=" + patientFirstName + ", patientLastName="
             + patientLastName + ", gender=" + gender + ", bloodGroup=" + bloodGroup + ", appointmentDate="
             + appointmentDate + ", getPatientId()=" + getPatientId() + ", getPatientFirstName()="
             + getPatientFirstName() + ", getPatientLastName()=" + getPatientLastName() + ", getGender()="
             + getGender() + ", getBloodGroup()=" + getBloodGroup() + ", getAppointmentDate()="
             + getAppointmentDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
             + super.toString() + "]";
 }

 // Parameterized constructor for creating a Patient object with all attributes
 public Patient(int patientId, String patientFirstName, String patientLastName, String gender, String bloodGroup,
         String appointmentDate) {
     super();
     this.Patient_Id = patientId;
     this.patientFirstName = patientFirstName;
     this.patientLastName = patientLastName;
     this.gender = gender;
     this.bloodGroup = bloodGroup;
     this.appointmentDate = appointmentDate;
 }

 // Default constructor
 public Patient() {
     super();
 }
}
	