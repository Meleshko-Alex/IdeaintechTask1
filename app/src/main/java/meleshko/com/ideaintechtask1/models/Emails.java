package meleshko.com.ideaintechtask1.models;

import io.realm.RealmObject;

public class Emails extends RealmObject {
    private String email_1;
    private String email_2;

    public String getEmail_1() {
        return email_1;
    }

    public void setEmail_1(String email_1) {
        this.email_1 = email_1;
    }

    public String getEmail_2() {
        return email_2;
    }

    public void setEmail_2(String email_2) {
        this.email_2 = email_2;
    }
}
