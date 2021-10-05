package com.lewiscode;

import java.util.ArrayList;

public class MobilePhone {
    private final String myNumber;
    private final ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }
    public  boolean addContact(Contact contact){
        if (findContact(contact.getName())>=0){
            return false;
        }else {
            myContacts.add(contact);
            return true;
        }
    }
    public boolean updateContact(Contact oldContact, Contact newContact){
        int position = findContact(oldContact);
        if (position < 0) {
            return false;
        }else
            myContacts.set(position, newContact);
            return true;
    }
    public boolean removeContact(Contact contact){
        if (findContact(contact)>=0){
            myContacts.remove(contact);
            return  true;
        }else {
            return false;
        }
    }
    private int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }
    private int findContact(String name){
        for (int i=0;i< myContacts.size();i++){
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(name)){
               return i;
            }
        }
        return -1;
    }
    public Contact queryContact(String name){
        if (findContact(name)>=0){
            return myContacts.get(findContact(name));
        }
        return null;
    }
    public void printContacts(){
        System.out.println("Contact List:");
        for (int i=0;i< myContacts.size();i++){
            System.out.println(i+1 + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
}
