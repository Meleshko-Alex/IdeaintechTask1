package meleshko.com.ideaintechtask1.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class User extends RealmObject {
    @PrimaryKey
    private int userId;
    @Required
    private String fullName;
    private RealmList<Phones> phones;
    private RealmList<Emails> emails;
    private String avatar;
    private String role;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public RealmList<Phones> getPhones() {
        return phones;
    }

    public void setPhones(RealmList<Phones> phones) {
        this.phones = phones;
    }

    public RealmList<Emails> getEmails() {
        return emails;
    }

    public void setEmails(RealmList<Emails> emails) {
        this.emails = emails;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
