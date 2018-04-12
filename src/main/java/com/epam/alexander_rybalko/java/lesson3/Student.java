package com.epam.alexander_rybalko.java.lesson3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Student {
    private String name;
    private String curriculum;
    private Date startDate;
    private Date endDate;
    private List<Course> courses;

    public Student(String name, String curriculum, Date start_date) {
        this.name = name;
        this.curriculum = curriculum;
        this.startDate = start_date;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getCurriculum() {
        return this.curriculum;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    // duration of curriculum in hours
    public long getDurationOfCurriculum() {
        long result = 0;
        for (Course course : courses) {
            result += course.getDuration();
        }
        return result;
    }

    public Date getEndDate() {
        if (this.endDate == null) {
            this.endDate = countEndDate();
        }
        return this.endDate;
    }

    private Date countEndDate() {
        int necessaryMinutes = 0;
        for (Course course : this.courses) {
            necessaryMinutes += 60 * course.getDuration();
        }
        Date endDate = new Date(this.startDate.getTime());
        Calendar calendarOfEndDate = Calendar.getInstance();
        calendarOfEndDate.setTime(endDate);
        while (necessaryMinutes > 0) {
            if (calendarOfEndDate.get(Calendar.HOUR_OF_DAY) < 10) {
                calendarOfEndDate.set(Calendar.HOUR_OF_DAY, 10);
                calendarOfEndDate.set(Calendar.MINUTE, 00);
            }
            if (calendarOfEndDate.get(Calendar.HOUR_OF_DAY) >= 18) {
                calendarOfEndDate.set(Calendar.HOUR_OF_DAY, 10);
                calendarOfEndDate.set(Calendar.MINUTE, 00);
                calendarOfEndDate.add(Calendar.DAY_OF_MONTH, 1);
            }
            int currentDayMinutes = 8 * 60 - ((calendarOfEndDate.get(Calendar.HOUR_OF_DAY) - 10) * 60
                    + calendarOfEndDate.get(Calendar.MINUTE));
            if (necessaryMinutes <= currentDayMinutes) {
                calendarOfEndDate.add(Calendar.MINUTE, necessaryMinutes);
                necessaryMinutes = 0;
            } else {
                calendarOfEndDate.set(Calendar.HOUR_OF_DAY, 10);
                calendarOfEndDate.set(Calendar.MINUTE, 00);
                calendarOfEndDate.add(Calendar.DAY_OF_MONTH, 1);
                necessaryMinutes -= currentDayMinutes;
            }
        }

        return calendarOfEndDate.getTime();
    }

    // get different from two dates in minutes
    // secondDate must be after firstDate
    private long getDiffInMinutes(Date firstDate, Date secondDate) {
        long result = 0;
        Calendar firstCalendar = Calendar.getInstance();
        firstCalendar.setTime(firstDate);

        Calendar secondCalendar = Calendar.getInstance();
        secondCalendar.setTime(secondDate);

        if (secondCalendar.get(Calendar.HOUR_OF_DAY) < 10) {
            secondCalendar.set(Calendar.HOUR_OF_DAY, 18);
            secondCalendar.set(Calendar.MINUTE, 00);
            secondCalendar.set(Calendar.DAY_OF_MONTH, -1);
        }
        if (secondCalendar.get(Calendar.HOUR_OF_DAY) >= 18) {
            secondCalendar.set(Calendar.HOUR_OF_DAY, 18);
            secondCalendar.set(Calendar.MINUTE, 00);
        }

        while (!firstCalendar.getTime().equals(secondCalendar.getTime())) {
            if (firstCalendar.get(Calendar.YEAR) == secondCalendar.get(Calendar.YEAR)
                    && firstCalendar.get(Calendar.MONTH) == secondCalendar.get(Calendar.MONTH)
                    && firstCalendar.get(Calendar.DAY_OF_MONTH) == secondCalendar.get(Calendar.DAY_OF_MONTH)) {
                result += (secondCalendar.get(Calendar.HOUR_OF_DAY) - firstCalendar.get(Calendar.HOUR_OF_DAY)) * 60
                        + secondCalendar.get(Calendar.MINUTE) - firstCalendar.get(Calendar.MINUTE);
                break;
            }

            result += (18 - firstCalendar.get(Calendar.HOUR_OF_DAY)) * 60 - firstCalendar.get(Calendar.MINUTE);
            firstCalendar.set(Calendar.HOUR_OF_DAY, 10);
            firstCalendar.set(Calendar.MINUTE, 00);
            firstCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return result;
    }

    public String getNotFullReport(Date currentDate) {
        String resultOfTraining = "Training ";
        if (currentDate.after(this.getEndDate())) {
            long diffInMinutes = this.getDiffInMinutes(getEndDate(), currentDate);
            LastTime time = countLastTime(diffInMinutes);
            resultOfTraining += "is over. Time passed " + ((time.days > 0) ? (time.days + " days ") : (""))
                    + ((time.hours > 0) ? (time.hours + " hours ") : ("")) + (time.minutes + " minutes.");
        } else {
            long diffInMinutes = this.getDiffInMinutes(currentDate, getEndDate());
            LastTime time = countLastTime(diffInMinutes);

            resultOfTraining += "is not over. Time left " + ((time.days > 0) ? (time.days + " days ") : (""))
                    + ((time.hours > 0) ? (time.hours + " hours ") : ("")) + (time.minutes + " minutes.");
        }
        return this.getName() + " (" + this.getCurriculum() + ")\n" + resultOfTraining;
    }

    public String getFullReport(Date currentDate) {
        String resultOfTraining = "Training ";
        if (currentDate.after(this.getEndDate())) {
            long diffInMinutes = this.getDiffInMinutes(getEndDate(), currentDate);
            LastTime time = countLastTime(diffInMinutes);
            resultOfTraining += "is over. Time passed " + ((time.days > 0) ? (time.days + " days ") : (""))
                    + ((time.hours > 0) ? (time.hours + " hours ") : ("")) + (time.minutes + " minutes.");
        } else {
            long diffInMinutes = this.getDiffInMinutes(currentDate, getEndDate());
            LastTime time = countLastTime(diffInMinutes);

            resultOfTraining += "is not over. Time left " + ((time.days > 0) ? (time.days + " days ") : (""))
                    + ((time.hours > 0) ? (time.hours + " hours ") : ("")) + (time.minutes + " minutes.");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        return "STUDENT: " + this.getName() + "\n" + "CURRICULUM: " + this.getCurriculum() + "\n"
                + "DURATION_OF_CURRICULUM: " + this.getDurationOfCurriculum() + " hours" + "\n" + "START_DATE: "
                + simpleDateFormat.format(this.getStartDate()) + "\n" + "END_DATE: "
                + simpleDateFormat.format(this.getEndDate()) + "\n" + resultOfTraining;
    }

    private LastTime countLastTime(long timeInMinutes) {
        long countDays = timeInMinutes / 1440;
        timeInMinutes -= countDays * 1440;
        long countHours = timeInMinutes / 60;
        timeInMinutes -= countHours * 60;
        return new LastTime(countDays, countHours, timeInMinutes);
    }

    private class LastTime {
        long days;
        long hours;
        long minutes;

        private LastTime(long days, long hours, long minutes) {
            this.days = days;
            this.hours = hours;
            this.minutes = minutes;
        }
    }
}
