package com.isa.bootcamp;

public class Score {
    private Integer points;
    private  String  feedBack;
    private Student student;
    private Task task;



    public Integer getPoints() {
        return points;
    }

    public String getFeedBack(String String) {
        return feedBack;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public Student getStudent() {
        return student;
    }

    public Task getTask() {
        return task;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
