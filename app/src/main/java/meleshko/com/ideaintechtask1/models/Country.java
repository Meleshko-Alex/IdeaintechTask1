package meleshko.com.ideaintechtask1.models;

public class Country {
    private String name;
    private String phoneCode;
    private int flagImageRes;
    private String firstLetter;

    public Country(String name, String phoneCode, int flagImageRes) {
        this.name = name;
        this.phoneCode = phoneCode;
        this.flagImageRes = flagImageRes;
    }

    public String getName() {
        return name;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public int getFlagImageRes() {
        return flagImageRes;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }
}
