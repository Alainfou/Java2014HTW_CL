/**EXERCISE 8
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 1.0
 */

import java.util.regex.*;
 
public class PatientenWarteschlange
{
    int size;
    Patient[] warteSchlange;
    
    /**
     * Constructor
     */
    public PatientenWarteschlange (int maxSize)
    {
        this.size = 0;
        this.warteSchlange = new warteSchlange[maxSize];
    }
    
    /**
     * Method neuerPatient
     *
     * @param patient (Patient)
     */
    public void neuerPatient (Patient patient)
    {
        check(size < 10, "Warteliste ist voll");
        this.warteSchlange[this.size] = patient;
        this.size++;
    }
    
    public void derNaechsteBitte (int patientNumber)
    {
        for (int i = size ; i > 0 ; i--)
        {
            warteSchlange[i - 1] = warteSchlange[i];
        }
    }
    
    /**
     * Method entfernePatient
     *
     * deletes a patient when entering its number from the waiting list
     *
     * @param patientNumber (int)
     */
    public String entfernePatient (int patientNummer)
    {
        int i = this.getPatientFromNumber(patientNumber);
        if (i == -1) {
        	return "Faillure";
        }
        for (int j = i ; j < this.size ; j++)
        {
            this.warteSchlange[j] = this.warteSchlange[j + 1];
        }
        this.size--;
        
        return "Patient geloescht: " + warteSchlange[i].nummer + "\t" + warteSchlange[i].name;
    }
        
    public String toString() {
        String res = ("Warteliste \nPnr \tName\n");
        
        for (int i = size ; i >= 0 ; i--)
        {
            res += Patient.nummer + "\t" + Patient.name + "\n";
        }
        
        return res;
    }
    
    /**
     * Method getPatientVonNummer
     * 
	 * finds the rank of the article in the table with its number
	 * 
	 * @param  patientNumber (int)
     * @return i (int) the rank of the article with the asked number
	 */
    public getPatientVonNummer (int patientNummer)
    {
        for (int i = 0 ; i < this.size ; i++)
        {
            if (patientNummer == this.table[i].getNummer())
            {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Method check
     *
     * @param condition (boolean), message (String)
     * throws RuntimeError if condition false.
     */
    public static void check(boolean condition, String message)
    {
        if (!condition) {
            throw new Exception(message);
        }
    }
}