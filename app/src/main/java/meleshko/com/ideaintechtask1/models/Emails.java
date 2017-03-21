package meleshko.com.ideaintechtask1.models;

import io.realm.RealmObject;

public class Emails extends RealmObject {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
