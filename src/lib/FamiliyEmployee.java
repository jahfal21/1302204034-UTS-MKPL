package lib;

import java.util.LinkedList;
import java.util.List;

public class FamiliyEmployee {
    private String spouseName;
    private String spouseIdNumber;

    private List<String> childNames;
    private List<String> childIdNumbers;

    public FamiliyEmployee() {
        childNames = new LinkedList<String>();
        childIdNumbers = new LinkedList<String>();
    }

    public void setspouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public void addchild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public String getspouseName() {
        return spouseName;
    }

    public String getspouseIdNumber() {
        return spouseIdNumber;
    }

    public List<String> getchildNames() {
        return childNames;
    }

    public List<String> getchildIdNumbers() {
        return childIdNumbers;
    }

}
