package org.itstep.controller;

import org.itstep.model.Model;
import org.itstep.model.entity.NotUniqueLoginException;
import org.itstep.model.entity.NoteBook;
import org.itstep.model.entity.NoteBookDAO;
import org.itstep.view.View;

import java.util.Scanner;

/**
 * Created by student on 26.09.2017.
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        NoteBookDAO noteBookDAO = new NoteBookDAO();
        InputNoteNoteBook inputNoteNoteBook = new InputNoteNoteBook(view, sc);
        inputNoteNoteBook.inputNote();

        NoteBook noteBook = noteBookDAO.getUser(inputNoteNoteBook);
        System.out.println(noteBook);
    }

    /*private NoteBook getNoteBook(InputNoteNoteBook inputNoteNoteBook) {
        NoteBook noteBook = null;
        while(true) {
            try {
                noteBook = new NoteBook(inputNoteNoteBook.getFirstName(),
                        inputNoteNoteBook.getLoginData());
                break;
            } catch (NotUniqueLoginException e) {
                e.printStackTrace();
                System.out.println("Not Unique Login " + e.getLoginData());
                inputNoteNoteBook.inputLogin();
            }
        }
        return noteBook;
    }*/
}
