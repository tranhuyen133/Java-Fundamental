package BTTH;

import java.util.Objects;

public class Patient extends Person implements Comparable<Patient> {
    private String phone;

    public Patient() {}

    public Patient(String id, String name, int age, String phone) {
        super(id, name, age);
        this.phone = phone;
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public int compareTo(Patient o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public void displayInfo() {
        System.out.println(id + " - " + name + " - " + age + " - " + phone);
    }

    // Trùng ID coi như trùng bệnh nhân
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Patient)) return false;
        Patient other = (Patient) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
