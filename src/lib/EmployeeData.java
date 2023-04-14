package lib;

public class EmployeeData {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;

    // Primitive Obsession
    public enum Gender {
        Laki_Laki, Perempuan
    }

    private Gender gender; // Primitive Obsession

    public EmployeeData(String employeeId, String firstName, String lastName, String idNumber, String address,
            Gender gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.gender = gender;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getfirstname() {
        return firstName;
    }

    public void setfirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getlastname() {
        return lastName;
    }

    public void setlastname(String lastName) {
        this.lastName = lastName;
    }

    public String getidNumber() {
        return idNumber;
    }

    public void setidNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public Gender getgender() {
        return gender;
    }

    public void setgender(Gender gender) {
        this.gender = gender;
    }

}
