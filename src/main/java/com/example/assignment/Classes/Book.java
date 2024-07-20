package com.example.assignment.Classes;

public class Book {
    private String studentId;
    private String studentName;
    private String bookId;
    private String bookName;
    private String bookNumber;
    private String status;

    public Book(String studentId, String studentName, String bookName, String bookNumber, String status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.bookName = bookName;
        this.bookNumber = bookNumber;
        this.status = status;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
