/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.students;

/**
 *
 * @author PC DMX
 */
public class Node {
    Students student;
    Node next;

    public Node(Students student) {
        this.student = student;
        this.next = null;
    }

    // Getter and Setter for Student
    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    // Getter and Setter for Next Node
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
