package com.gmail.herman.uladzimir.project.controller;

import com.gmail.herman.uladzimir.container.MyTree;
import com.gmail.herman.uladzimir.container.exception.TreeIsEmptyException;
import com.gmail.herman.uladzimir.project.model.entity.Person;
import com.gmail.herman.uladzimir.project.model.factory.PersonFactory;
import com.gmail.herman.uladzimir.project.view.View;

public class StartTask {
    public static void main(String[] args) {
        MyTree<Person> myTree = new MyTree<>();
        Person examplePerson = new Person("MIKE", "ROBERTSON", 31);

        View.print("Tree is empty: " + myTree.isEmpty());

        myTree.add(PersonFactory.createPerson());
        myTree.add(PersonFactory.createPerson());
        myTree.add(examplePerson);
        myTree.add(PersonFactory.createPerson());
        myTree.add(PersonFactory.createPerson());

        View.print("Objects added to the tree! Tree is empty: " + myTree.isEmpty() +
                ", objects in tree: " + myTree.size());

        View.print("\nObjects In-Order:\n" + myTree.circumventInOrder());

        try {
            View.print("Tree contains " + examplePerson.getName() + " " +
                    examplePerson.getSurname() + ": " + myTree.contains(examplePerson));
            myTree.remove(examplePerson);
            View.print("Just been deleted " + examplePerson.getName() + " " +
                    examplePerson.getSurname() + "!");
            View.print("Tree contains " + examplePerson.getName() + " " +
                    examplePerson.getSurname() + ": " + myTree.contains(examplePerson));
            View.print("Objects in tree: " + myTree.size());
        } catch (TreeIsEmptyException e) {
            View.print(e.getMessage());
        }

        View.print("\nObjects In-Order:\n" + myTree.circumventInOrder());

        myTree.clear();
        View.print("Just been deleted all objects! Tree is empty: " + myTree.isEmpty());

    }
}