public class Animal {
    private String breed;

    private String name;

    private Boolean gender;

    public Animal() {
    }

    public Animal(String breed, String name, Boolean gender) {
        this.breed = breed;
        this.name = name;
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}