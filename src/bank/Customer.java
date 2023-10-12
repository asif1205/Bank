/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author ADMIN
 */
public class Customer {

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", mobile=" + contactInformation + '}';
    }

    public Customer() {
    }

    public Customer(int id, String name, long contactInformation) {
        this.id = id;
        this.name = name;
        this.contactInformation = contactInformation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(int contactInformation) {
        this.contactInformation = contactInformation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getMobile() {
        return contactInformation;
    }
    private int id;
    private String name;
    private long contactInformation;
}
