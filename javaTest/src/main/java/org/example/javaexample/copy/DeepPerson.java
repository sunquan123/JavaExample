package org.example.javaexample.copy;

public class DeepPerson implements Cloneable {
    private Address address;

    public DeepPerson(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // 省略构造函数、Getter&Setter方法
    @Override
    public DeepPerson clone() {
        try {
            DeepPerson person = (DeepPerson) super.clone();
            person.setAddress(person.getAddress().clone());
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
