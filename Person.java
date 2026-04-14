import java.util.Date;

public abstract class Person {
    private String Name = "";
    private String Surname = "";
    private int BornTimestamp = 0;
    private int id = 0;

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public int getBorn() {
        return BornTimestamp;
    }

    @Override
    public String toString() {
        return Name + " " + Surname;
    }

    @Override
    public int hashCode() {
        return (((id ^ 0x178412) << 3) * ((int)Name.hashCode())) >> 2;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return false;
        if ((other == null) || !(other instanceof Person)) return false;
        Person pr = (Person)other;
        return pr.id == id;
    }

    public Person(String n, String s, int b) {
        id = Main.IDUtility.getID(this);
        Name = n;
        Surname = s;
        BornTimestamp = b;
    }
}
