package meleshko.com.ideaintechtask1.models;

import io.realm.RealmObject;

public class Phones extends RealmObject {
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
