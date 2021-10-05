package com.lewiscode;

import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static MobilePhone mobilePhone = new MobilePhone("7053939348");
    public static void main(String[] args) {
	// write your code here
        boolean quit = false;
        int option;
        while (!quit){
            printOptions();
            System.out.println("Enter your option:");
            option =scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 0:
                    System.out.println("shutting down ...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
            }
        }
    }
    public static void printOptions(){
        System.out.println("\n Press");
        System.out.println("0 - To quit the app");
        System.out.println("1 - To print the list of contacts");
        System.out.println("2 - TO add an contact to the list");
        System.out.println("3 - To update an contact in the list");
        System.out.println("4 - To remove an contact from the list");
        System.out.println("5 - To search for an contact from the list");
    }
    public static void addContact(){
        System.out.print("Enter the name:");
        String name =scanner.nextLine();
        System.out.println("Enter the number");
        String phoneNumber = scanner.nextLine();
        Contact contact = new Contact(name,phoneNumber);
        if (mobilePhone.addContact(contact)){
            System.out.println("new contact name = " + name + ", phone = " + phoneNumber);
        }else {
            System.out.println(name + "exists");
        }

    }
    public static void updateContact(){
        System.out.print("Enter the current name");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(name);
        if (contact == null) {
            System.out.println(name + " not found");
        }else {
            System.out.print("Enter new name:");
            String newName =scanner.nextLine();
            System.out.print("Enter new number:");
            String phoneNumber =scanner.nextLine();
            Contact newContact = Contact.createContact(newName,phoneNumber);
            if(mobilePhone.updateContact(contact,newContact)){
                System.out.println(newName + "was updated successfully");
            }else {
                System.out.println( newName + "was not updated");
            }
        }
    }
    public static void removeContact(){
        System.out.print("Enter the contact name:");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(name);
        if(contact ==null){
            System.out.println(name + " not contact file");
        }else {
           if(mobilePhone.removeContact(contact)) {
               System.out.println(name + " was successfully deleted");
           }else {
               System.out.println( "Error deleting " + name );
           }
        }
    }
    public static void queryContact(){
        System.out.print("Enter the contact name:");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(name);
        if(contact == null){
            System.out.println( name + "not in file");
        }else {
            System.out.println("name = "+ contact.getName() +
                    ", phone number ="+ contact.getPhoneNumber());
        }
    }
}
