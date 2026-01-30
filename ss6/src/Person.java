public class Person {
    //thuộc tính
    String fullName;
    int age;
    String className;
    // contructor
    public Person (){
        //contructor không tham số
    }
    public Person(String fullName,int age, String className ){
        //constructors
        this.fullName = fullName;
        this.age = age;
        this.className = className;
    }
    //getter
    public String getFullName(){
        return this.fullName;
    }
    //setter
    public void setFullName(String fullName){


    }
}
