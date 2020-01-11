package com.bridgelabz.clinic;


import java.util.Date;
import java.util.List;
import java.util.Scanner;



/**
 * @author admin1
 *
 */
public class Utility {
	
	Scanner sc	=	new Scanner(System.in);
	public  String read_String() {
		return sc.next();
	}
	public int read_Integer() {
		return sc.nextInt();
	}

 public Doctor addDoctorToList(){
	 Doctor doctor	=	new Doctor();
	 
	 System.out.println("enter the name of doctor");
	 doctor.setName(read_String());
	 System.out.println("enter the id of doctor");
	 doctor.setId(read_Integer());
	 System.out.println("enter the specialization of doctor");
	 doctor.setSpecialization(read_String());
	 System.out.println("enter the availabity of doctor");
	 doctor.setAvailability(read_String());
	 
	 doctor.setNoOfPatient(0);
	 return doctor;
}
	public Patient addPatientToList() {
		
		Patient patient	=	new Patient();
		System.out.println("Enter the name of patient");
		patient.setName(read_String());
		System.out.println("Enter the patient id");
		patient.setId(read_Integer());
		System.out.println("Enter the patient mobile no");
		patient.setMobileNo(read_Integer());
		System.out.println("Enter the patient age");
		patient.setAge(read_Integer());


		return patient;
		
		
	}
	public Appointment addAppointmentToList(List<Doctor> doctorList, List<Patient> patientList)
	{
		Appointment appointment	=	new Appointment();
		System.out.println("Enter name of Patient");
		String patientName	= read_String();
		int count = 0;
		  for(Patient patient: patientList) {
			  
			  if(patient.getName().equals(patientName)) {
				  
				  count++;
				  System.out.println("Enter the name of doctor whose appointment you want");
				  String doctorName	=	read_String();
				  System.out.println("Enter the id of doctor whose appointment you want");
				  int doctorId	=	read_Integer();
				  Date d	=	new Date();
				  String date	=	d.toString();
				  for(Doctor doctor:doctorList) {
					  
					  if(doctor.getName().equals(doctorName)) {
						  
						  if(doctor.getId() == doctorId) {
							  
							  if(doctor.getNoOfPatient() < 5) {
								  
								  appointment.setDoctor(doctorName);
								  appointment.setPatient(patientName);
								  appointment.setDate(date);
								  doctor.setNoOfPatient(doctor.getNoOfPatient()+1);
								  System.out.println("Appointment fixed on date"+date);
								  return appointment;
							  }//if
							  else {
								  System.out.println("Soryy..! Try for next date");
							  }//if
						  }//if
					  }//for
				  }//f
			  }//for
			  if(count == 0) {
				  System.out.println("Sorry..! You are not registerd patient");
				  System.exit(0);
			  }
			  
		  }
		return null;
		
		
	}		
	
}