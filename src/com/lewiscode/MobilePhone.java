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
        if (findContact(contact)>=0){
            System.out.println(contact + "exists");
            return true;
        }else {
            myContacts.add(contact);
            return false;
        }
    }
    public boolean updateContact(Contact oldContact, Contact newContact){
        int position = findContact(oldContact);
        if (position < 0) {
            System.out.println(oldContact + " doesn't exists");
            return false;

        }else if (findContact(oldContact.getName())!=-1){
            System.out.println("contact with the "+newContact.getName()+" already exists. update was not successful");
        }else
            myContacts.set(position, newContact);
            System.out.println(oldContact + " was updated to " + newContact + "successfully");
            return true;
    }
    public boolean removeContact(Contact contact){
        if (findContact(contact)>=0){
            myContacts.remove(contact);
            System.out.println(contact + " was successfully removed");
            return  true;
        }else {
            System.out.println(contact + " doesn't exists");
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
