package com.bridgelabz.clinic;

public class Appointment {
	String patient;
	String doctor;
	String date;
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Appointment [patient=" + patient + ", doctor=" + doctor + ", date=" + date + "]";
	}
	
	

}
