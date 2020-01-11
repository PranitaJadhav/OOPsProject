package com.bridgelabz.clinic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelabz.adressbook.Person;

public class DisplayDetailsImplementation  {
	public static List<Doctor> list = new ArrayList<Doctor>();
	Doctor doctor	=	new Doctor();
	Patient patient	=	new Patient();
	Appointment appointment	=	new Appointment();
	ObjectMapper mapper = new ObjectMapper();

	public void displayDoctor(List<Doctor> doctorList) {

		for(Doctor doctor:doctorList) {
			System.out.println(doctor.toString());
			
			
		}
	}

	public void displayPatient(List<Patient> patientList) {
		 for(Patient patient:patientList) {
			 
			 System.out.println(patient.toString());
		 }
		
	}

	public void displayAppointment(List<Appointment> appointmentList) {
		for(Appointment appointment: appointmentList) {
			System.out.println(appointment.toString());
		}
		
	}

	public void displaySpecialist(List<Doctor> doctorList) {
		for(Doctor doctor:doctorList) {
			if(doctor.noOfPatient == 5) {
				System.out.println("Popular specialist dctor"+doctor.getSpecialization());
			}
			
		}
		
	}
	
	

}
