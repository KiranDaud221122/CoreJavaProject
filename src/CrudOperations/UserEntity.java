package CrudOperations;

public class UserEntity {

    private String name;
    private String email;
    private String contactNumber;

    public UserEntity(String name, String email, String contactNumber) {
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
