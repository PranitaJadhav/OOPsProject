package com.bridgelabz.clinic;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.clinicManagement.Doctor;


public class ClinicController {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Utility utility 	=	new Utility();


		DoctorImplementation doctorimpl	=	new DoctorImplementation();
		PatientImplementation patientimpl	=	new PatientImplementation();
		DisplayDetailsImplementation impl	=	new DisplayDetailsImplementation();
		System.out.println("         Operations          ");
		System.out.println(" press 1 to add doctor ");
		System.out.println(" press 2 to add patient ");
		System.out.println(" press 3 to search doctor by name ");
		System.out.println(" press 4 to search doctor by id ");
		System.out.println(" press 5 to search patient by name ");
		System.out.println(" press 6 to search patient by id ");
		System.out.println("Press 7 to exit");




		 int choice		=	utility.read_Integer()	;
		 int loop	=	0;
		 while(loop == 0) {
		 switch(choice) {
		 
		 case 1: List<Doctor> addD	=	doctorimpl.readDoctorFile();
		 		 List<Doctor> addedD	=	doctorimpl.addDoctorToList(addD);
		 		doctorimpl.writeFile(addedD);
		 		 break;
		 case 2: List<Patient> addP	=	patientimpl.readPatientFile();
		 		 List<Patient> addedp	= patientimpl.addPatientToList(addP);
		 		patientimpl.writeFile(addedp);
		 		 break;
		 case 3:List<Doctor> doctorName	=	doctorimpl.readDoctorFile();
		 					  doctorimpl.searchDocotByName(doctorName);
		 					  break;
		 					  
		 case 4:List<Doctor> doctorId	=	doctorimpl.readDoctorFile();
		 					doctorimpl.searchDoctorById(doctorId);
		 					break;
		 case 5: List<Patient> patientName	=	patientimpl.readPatientFile();
		 		 patientimpl.searchPatientByName(patientName);
		 		 break;
		 case 6: List<Patient> patientId	=	patientimpl.readPatientFile();
		 		 patientimpl.searchPatientByName(patientId);
		 		 break;
		 
		 case 7: System.out.println("Exit");
		           loop = 1;
		           break;

		 default:System.out.println("Enter valid no");
		         break;
		 
		 
		 }
		 //System.out.println("ebdvmjebvwcbvfebcv");

		 }
	}

}
