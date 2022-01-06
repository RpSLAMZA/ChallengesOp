package com.company;
import javax.imageio.IIOException;

import static com.company.SerializationHelper.deserializeFromFile;
import static com.company.SerializationHelper.serialiseToFile;

import java.io.IOException;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
class ThrowException extends Exception {
    ThrowException(String message){
        super(message);
    }
}
public class Main{
   public static Scanner input= new Scanner(System.in);
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//ArrayList To store details
        ArrayList<String> Unames = new ArrayList<String>();
        ArrayList<String> Usurnames = new ArrayList<String>();
        ArrayList<String> UdateOfBirth = new ArrayList<String>();
        ArrayList<String> UemailAddress = new ArrayList<String>();

        String filePath = "C:\\Users\\User\\IdeaProjects\\project2\\src\\com\\company\\UserDatabase.txt";
        Menu: do{int menuOption = MenuOp();
            switch(menuOption) {
                case 1: registerUser(Unames, Usurnames, UemailAddress, UdateOfBirth,filePath );
                            break;
                case 2: update(Unames, Usurnames, UemailAddress, UdateOfBirth,filePath);
                    break;
                case 3: delete(Unames, Usurnames, UemailAddress,UdateOfBirth,filePath );
                    break;
                case 4: View(Unames, Usurnames, UemailAddress, UdateOfBirth,filePath );
                    break;
                case 5:
                    break Menu;
                default:System.out.println("Invalid Option , Please Try Again");
                    break;}
        }while(true);}

    static int MenuOp(){
        Scanner scannerMenu = new Scanner(System.in);
        int option;
        while(true){
            System.out.println("---------------Welcome----------------");
            System.out.println("---Please Choose an Option------------");
            System.out.println("(1)Add a user");
            System.out.println("--------------------------------------");
            System.out.println("(2)Update a user");
            System.out.println("--------------------------------------");
            System.out.println("(3) Delete a user");
            System.out.println("--------------------------------------");
            System.out.println("(4)List users");
            System.out.println("--------------------------------------");
            System.out.println("(5)Press 5 to Exit/Quit\n \n ");
            System.out.println("--------------------------------------");

            try{option = scannerMenu.nextInt();
                break;
            }catch(Exception e){
                System.out.println("Option not valid");
                scannerMenu.next();
            }
        }
        return option;
    }

    /*Displays options to user when they want to update
    and returns the option*/
    static int updateMenuOption(){
        Scanner scannerMenu = new Scanner(System.in);
        int option;
        while(true){
            System.out.println("---------------Update Details----------------");
            System.out.println("(1) Name");
            System.out.println("(2) Surname ");
            System.out.println("(3) Email Address");
            System.out.println("(4) Date of birth ");
            System.out.println("(5) Update All Details \n");
            try{option = scannerMenu.nextInt();
                if(option >= 1 && option <= 5){
                    break;}
            }catch(Exception e){
                System.out.println("Please Select A Valid Option");
                scannerMenu.next();
            }
        }
        return option;
    }

    static void registerUser(ArrayList<String> name, ArrayList<String> surname,
                             ArrayList<String> emails, ArrayList<String> dateOfBirth, String filePath) throws IOException,ClassNotFoundException {

            ArrayList<ArrayList<String> > userDatabase;
            userDatabase = (ArrayList<ArrayList<String>>) deserializeFromFile(filePath);
            if(userDatabase.get(0).size() == 0) {
                userDatabase.add(name);
                userDatabase.add(surname);
                userDatabase.add(emails);
                userDatabase.add(dateOfBirth);
            }else{
                name = userDatabase.get(0);
                surname = userDatabase.get(1);
                emails = userDatabase.get(2);
                dateOfBirth = userDatabase.get(3);
            }



        String userName = InputGetUserName();
        name.add(userName);
        String userSurname = InputGetSurname();
        surname.add(userSurname);
        String userEmail = InputgetUserEmail();
        emails.add(userEmail);
        String dob = InputgetUserDOB();
        dateOfBirth.add(dob);
        int year = Integer.parseInt(dob.split("/")[2]);
        int age = 2021-year;			//Calculate age
        System.out.println("You are "+ age + " years old" );
        System.out.println("Hello " + userName + " " +userSurname +
                " Thank You For Registering. \n");
    }

   static void update(ArrayList<String> name, ArrayList<String> surname, ArrayList<String> emails,
                      ArrayList<String> dateOfBirth, String filePath) throws IOException,ClassNotFoundException{
       ArrayList<ArrayList<String> > userDatabase;
       int updateOption;
       String userName;
       String userSurname;
       String userEmail;
       String dob;
       userDatabase = (ArrayList<ArrayList<String>>) deserializeFromFile(filePath);


        try{name = userDatabase.get(0);
            surname = userDatabase.get(1);
            emails = userDatabase.get(2);
            dateOfBirth = userDatabase.get(3);
            checkUsers(emails);
            System.out.print("Please Enter your email: ");
            String email = input.nextLine();
            for(int i = 0; i < emails.size(); i++){
                if(email.equalsIgnoreCase(emails.get(i))){
                    System.out.println("Name: "+ name.get(i) + "\tSurname: " + surname.get(i) + "\tEmail: " + emails.get(i) + "\tDOB " + dateOfBirth.get(i));updateOption = updateMenuOption();
                    if(updateOption == 1){userName = InputGetUserName();name.set(i, userName);
                    }else if(updateOption == 2){userSurname =InputGetSurname();surname.set(i, userSurname);
                    }else if(updateOption == 3){userEmail = InputgetUserEmail();emails.set(i, userEmail);
                    }else if(updateOption == 4){dob = InputgetUserDOB();dateOfBirth.set(i, dob);
                    }else if(updateOption == 5){userName = InputGetUserName();name.set(i, userName);
                        userSurname = InputGetSurname();surname.set(i, userName);userEmail = InputgetUserEmail();
                        emails.set(i, userEmail);dob = InputgetUserDOB();dateOfBirth.set(i, dob);
                    }
                    serialiseToFile(userDatabase, filePath);
                }
            }
        }catch(Exception e){
            System.out.println("A User Is Not Registered");
        }
    }

    /*Takes an arraylist of emails and first checks if it's not empty
    then check if the user exists and deletes user if email matches ones
    stored in database.
    */
    static void delete(ArrayList<String> name, ArrayList<String> surname, ArrayList<String> emails,
                       ArrayList<String> dateOfBirth, String filePath) throws IOException, ClassNotFoundException {

        ArrayList<ArrayList<String> > userDatabase;
        userDatabase = (ArrayList<ArrayList<String>>) deserializeFromFile(filePath);
        try{
            name = userDatabase.get(0);
            surname = userDatabase.get(1);
            emails = userDatabase.get(2);
            dateOfBirth = userDatabase.get(3);
            checkUsers(emails);  	//Check size of arraylist
            System.out.print("Enter your email: ");
            String email = input.nextLine();
            int temp = emails.size();
            for(int i = 0; i < emails.size(); i++){
                if(email.equalsIgnoreCase(emails.get(i))){
                    String tempName = name.get(i);
                    String tempsurname = surname.get(i);
                    name.remove(i);
                    surname.remove(i);
                    emails.remove(i);
                    dateOfBirth.remove(i);
                    System.out.println("User "+ tempName + " " + tempsurname+
                            " Deleted");
                    i--;
                }

                serialiseToFile(userDatabase, filePath);
            }if(temp == emails.size()){
                System.out.println("Not Deleted!");
            }
        }catch(Exception e){
            System.out.println("No users, Please Try Again");
        }
    }

    static void View(ArrayList<String> names, ArrayList<String> surnames, ArrayList<String> emails,
                     ArrayList<String> dateOfBirth, String filePath){
        ArrayList<ArrayList<String> > userDatabase;
        try{
            userDatabase = (ArrayList<ArrayList<String>>) deserializeFromFile(filePath);
            names = userDatabase.get(0);
            surnames = userDatabase.get(1);
            emails = userDatabase.get(2);
            dateOfBirth = userDatabase.get(3);
            checkUsers(names);
            for(int i = 0; i < names.size(); i++){
                System.out.println("1. Name          : " + names.get(i));
                System.out.println("2. surname       : " + surnames.get(i));
                System.out.println("3. Email Address : " + emails.get(i));
                System.out.println("4. Date Of Birth : " + dateOfBirth.get(i));
            }
        }catch(Exception e){
            System.out.println("User is not Registered");
        }
    }
    //validate name
    static String InputGetUserName(){while(true){System.out.print("Please Enter Your name: ");
            String name = input.nextLine();
            try{NameVal(name);return name;
            }catch(Exception e){System.out.println("Invalid Input, Please Try Again");
            }}}
    //validate surname
    static String InputGetSurname(){
        while(true){System.out.print("Please Enter Your surname : ");
            String surname = input.nextLine();
            try{SurnameVal(surname);
                return surname;
            }catch(Exception e){System.out.println("Invalid Input, Please Try Again");
            }}}


    //validate Email
    static String InputgetUserEmail(){
        while(true){System.out.print("Please Enter your email: ");
            String email = input.nextLine();
            try{EmailVal(email);
                return email;
            }catch(Exception e){System.out.println("Invalid Input, Please Try Again!");
            }}}

    //Validate date of birth
    static String InputgetUserDOB(){String dob;
        int yearC;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        while(true){System.out.print("Enter your date of birth(dd/MM/yyyy): ");
            dob = input.nextLine();
            try{Date date = dateFormat.parse(dob);
                if(dob.length() == 10){
                    yearC = Integer.parseInt(dob.split("/")[2]);
                    if(yearC < 2021){return dob;
                    }else{
                        System.out.println("Date of Birth Invalid, Please Try Again!");
                    }
                }else{System.out.println("Invalid Input, Please Try Again!");
                }
            }catch(Exception e){System.out.println("Invalid Input, Please Try Again!");
            }}}
    //Validation that check users, if not throw exception
    static void checkUsers(ArrayList<String> arrayList) throws ThrowException {
        ArrayList<String> userNames = arrayList;
        if (userNames.size() == 0) {throw new ThrowException("");
        }}
    //validatiotion of name,surname,email and date of birth
    static void NameVal(String nameValidation) throws ThrowException{
        if(!Pattern.matches("^[a-zA-Z]+$",nameValidation)){
            throw new ThrowException("");
        }
    }
    static void SurnameVal(String surnameValidation) throws ThrowException{
        if(!Pattern.matches("^[a-zA-Z]+$",surnameValidation)){
            throw new ThrowException("");
        }
    }
    static void EmailVal(String emailValidation) throws ThrowException{
        if(!Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
                emailValidation)){throw new ThrowException("");
        }
    }


    }


