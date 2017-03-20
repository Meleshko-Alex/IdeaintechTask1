package meleshko.com.ideaintechtask1.models;

import io.realm.RealmObject;

public class Phones extends RealmObject {
    private String phone_1;
    private String phone_2;

    public String getPhone_1() {
        return phone_1;
    }

    public void setPhone_1(String phone_1) {
        this.phone_1 = phone_1;
    }

    public String getPhone_2() {
        return phone_2;
    }

    public void setPhone_2(String phone_2) {
        this.phone_2 = phone_2;
    }
}
