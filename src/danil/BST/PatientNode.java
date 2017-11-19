package danil.BST;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * CS 146 HW2 Fall 2017
 * Professor: Dr. Mike Wu
 */
public class PatientNode {
    private String patientName; // name of the Patient
    private int priority;
    public PatientNode left, right;

    public int getPriority(){
        return priority;
    }
    public String getPatientName(){
        return patientName;
    }
    public PatientNode(int priority, String name) {
        this.priority = priority;
        this.patientName = name;
        left = null;
        right = null;
    }
}
