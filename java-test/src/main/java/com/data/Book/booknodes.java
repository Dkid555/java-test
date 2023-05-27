package com.data.Book;

class booknodes {
    String Name;
    String Surname;
    String Brief_Info;


    booknodes() {
    }

    booknodes(String Name) {
        this.Name = Name;
    }

    booknodes(String Name, String Surname) {
        this.Name = Name;
        this.Surname = Surname;
    }

    booknodes(String Name, String Surname, String Brief) {
        this.Name = Name;
        this.Surname = Surname;
        this.Brief_Info = Brief;
    }

    @Override
    public String toString() {
        return ("name: " + this.Name +
                "\nSurname: " + this.Surname + "\nBrief information: " + this.Brief_Info).replaceAll(" null", "");
    }
}
