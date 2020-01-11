package com.bridgelabz.clinic;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.clinicManagement.Patient;

public interface PatientInterface {
	public List<Patient> addPatientToList(List<Patient> patientList);
	public List<Patient> readPatientFile();
	public void writeFile(List<Patient> PatientList) throws JsonGenerationException, JsonMappingException, IOException ;
	
}
