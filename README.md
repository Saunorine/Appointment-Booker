# Appointment-Booker
## Table of Contents

[Description and Purpose](https://github.com/Saunorine/Appointment-Booker#description)

[Learning Outcomes and Requirements](https://github.com/Saunorine/Appointment-Booker#requirements)

[Ideas to Implement](https://github.com/Saunorine/Appointment-Booker#ideas)

[Weekly Updates](https://github.com/Saunorine/Appointment-Booker#weekly-updates)

## Description:
Java application for the user to make appointments for predetermined courses with set times and dates.

Written and collaborated by Zhanhang Xiao (https://github.com/Saunorine) and Fermin Garduno (https://github.com/FerminGarduno).

### Purpose:
A program that could schedule workout courses for a local gym. Add courses that could be written as a class with a course name, trainer name, date, time, intensity, and courseSize. Then user could use the interface to navigate courses and sort through them. Their information they logged in with would be then be added to the course member list for the staff to look at.

## Requirements:
1. A GUI that the gym member uses to login and select courses to sign up for
2. Can sort available appointments by price/trainer etc
3. Add new staff appointments
4. Return errors if needed

### Learning Outcome Requirements
  * Design principles of object-oriented programming ✓ - Created 2 objects that will work together to work the program
  * Single and multidimensional arrays ✓ - ArrayLists for Course and Accounts
  * Uses objects and classes in object ✓
  * Inheritance and polymorphism, including abstract classes and interfaces ✓
  * Generic collections and data structures ✓ - Using ArrayLists to hold objects of Courses for an Account object
  * GUI utilizing event-driven programming ✓
  * Construct programs utilizing exception handling ✓
  * Text File I/O ✓

### Ideas:
  * see if we can somehow integrate google calendar
  * reschedule appointments after being made
  * send email notifying about the appointment after booking
  * GUI will be different depending on user or staff login

## Weekly Updates
### Week 1:
Do CRC cards for the project

List requirements

Look for ways to implements learning outcomes

Plan out the inner workings

### Week 2:
Write course and account classes along with their methods and junit tests

### Week 3:
Finish up writing the classes and junit tests. Need to start looking at learning outcomes.

### Week 4: 
Write up JUnit Tests and polish up classes. Look over Accounts and staffAccounts class and see how else we can implement polymorphism and other learning outcomes.

### Week 5:
Zhanhang is going to work on the GUI assignment and try to get the first 2-3 pages done with buttons that takes the user between each one. Fermin should write up the sorting methods for sorting courses by time/date/alphabetical etc. Continue looking for ways to implement learning outcomes.

### Week 6:
Finished adding the first few windows and a placeholder for later uses

### Week 7
Got File I/O done, account/course/enrollment info is stored in text files and program saves to it when it closes and reads it when it opens back up.

still no interfaces

still need other stuff too

Fermin is going to test it out since I wrote most of the code and designed it, a fresh pair of eyes should help find the bugs and kinks.

## Week 8
Last week, going to finally add abstract and subclasses for learning outcomes, everything else is already written and working so I just need to modify and keep it the same.

Final update on May 23, 2024 got the abstract and subclasses up. fixed some parts of the program not using GUITools and finished commenting everything. Should be bug free? I hope.
