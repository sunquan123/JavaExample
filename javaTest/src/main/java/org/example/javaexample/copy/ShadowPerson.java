package org.example.javaexample.copy;

public class ShadowPerson  implements Cloneable {
    private Address address;

    public ShadowPerson(Address address) {
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
    public ShadowPerson clone() {
        try {
            ShadowPerson person = (ShadowPerson) super.clone();
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
