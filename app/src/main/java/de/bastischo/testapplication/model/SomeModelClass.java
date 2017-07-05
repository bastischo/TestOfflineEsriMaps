package de.bastischo.testapplication.model;

/**
 * Created by Sebastian on 09.06.2016.
 */
public class SomeModelClass {
    private String name;
    private int age;
    private boolean male;

    @Override
    public String toString() {
        return name + "," + age + "," + (male ? "male" : "female");
    }

    public static SomeModelClass fromString(String object) {
        SomeModelClass smc = new SomeModelClass();
        String[] fields = object.split(",");
        smc.name = fields[0];
        smc.age = Integer.valueOf(fields[1]);
        smc.male = fields[2].equals("male");
        return smc;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof SomeModelClass))
            return false;

        SomeModelClass osmc = (SomeModelClass) other;
        return osmc.name.equals(name) && osmc.male == male && osmc.age == age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
