// Doctor.java
package com.anp.patient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    @Column(name = "DOCTOR_FIRST_NAME")
    private String doctorFirstName;

    @Column(name = "DOCTOR_LAST_NAME")
    private String doctorLastName;

    @Column(name = "SPECIALIZATION")
    private String specialization;

    public Doctor() {
        // Default constructor
    }

    public Doctor(int doctorId, String doctorFirstName, String doctorLastName, String specialization) {
        this.doctorId = doctorId;
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
        this.specialization = specialization;
    }

    // Getter and Setter methods

    @Override
    public String toString() {
        return "Doctor [doctorId=" + doctorId + ", doctorFirstName=" + doctorFirstName + ", doctorLastName="
                + doctorLastName + ", specialization=" + specialization + "]";
    }

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorFirstName() {
		return doctorFirstName;
	}

	public void setDoctorFirstName(String doctorFirstName) {
		this.doctorFirstName = doctorFirstName;
	}

	public String getDoctorLastName() {
		return doctorLastName;
	}

	public void setDoctorLastName(String doctorLastName) {
		this.doctorLastName = doctorLastName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
}
