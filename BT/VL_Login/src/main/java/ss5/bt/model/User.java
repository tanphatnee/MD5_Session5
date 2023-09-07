package ss5.bt.model;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
//import ss5.bt.service.UserService;

public class User implements Validator {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String tel;
    private int age;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String email, String tel, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tel = tel;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if(user.firstName.trim().equals("")){
            errors.rejectValue("firstName", "invalid.empty");
        } else if (!user.firstName.matches("(^[a-zA-Z0-9._#?!@$%^&*-]{5,45}$)")) {
            errors.rejectValue("firstName", "invalid.name");
        } else if (user.lastName.trim().equals("")){
            errors.rejectValue("lastName", "invalid.empty");
        }  else if (!user.lastName.matches("(^[a-zA-Z0-9._#?!@$%^&*-]{5,45}$)")) {
            errors.rejectValue("lastName", "invalid.name");
        } else if (!user.tel.matches("(^0\\d{9}$)")){
            errors.rejectValue("tel", "invalid.tel");
        } else if (!user.email.matches("(^[A-Za-z0-9]+[A-Za-z0-9._%+-]*@[a-z]+(\\.[a-z]+)$)")){
            errors.rejectValue("email", "invalid.email");
        } else if (user.age<18){
            errors.rejectValue("age", "invalid.age");
        }
    }
}
