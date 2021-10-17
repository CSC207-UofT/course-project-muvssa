# Progress Report

---
### Specification

Our specification aims to highlight the key functionality of our Fitness Tracker program. 
This includes: 
* Using the Android App platform
* Ability to add exercises to create workouts and routines
* Social media aspect 
  * Such as the ability to post and view others' posts
  * Follow other people and view their workouts
  * Display your routine and weekly schedule on your profile for others to view

We made sure to mention who the target audience is to remind us who we are making 
the program for. We also kept the specification simple enough so that it’s easy to see
what the program does, but detailed enough to know what features are required and how
the flow of the program should be like.

---
### CRC Model

To summarize the CRC Model, it is best to categorize them into their clean architecture 
layer and give a brief summary:
* Entities
  * **User**: Represents a user of the fitness tracker 
  * **Exercise**: Represents a very general exercise. 
  * **TimedExercise**: Represents a type of exercise that uses “time” as it’s tracking unit.
(I.E: planks, skipping, jogging, etc.)
  * **RepExercise**: Represents a type exercise that uses one repetition as a tracking unit.
(I.E push-ups, pull-ups, etc.)
  * **WeightedRepExercise**: Represents a type of rep-exercise that is weighted. 
(I.E bench-press, squats, deadlifts). 
  * **Comment**: Represents a comment on a User’s post.'

* Use Cases
  * **Workout**: Represents a series of exercises done in a particular order 
  * **Routine**: Represents a series of workouts done in a particular order 
  * **WeeklySchedule**: Represents a user’s workout schedule for the week 
  * **WorkoutTracker**: Tracks all of the user’s workouts and exercises. 
  * **FollowManager**: Tracks all the profiles that a profile is following and its followers
  * **Feed**: Represents a list of posts that a profile can view
  * **Post**: Represents a social media post containing comments, likes, the workout and 
a message about the workout.

* Controllers 
  * **Profile**: Represents a user’s social profile 
  * **Profiles**: A collection of Profile objects.
  
* UI
  * **Screen**: Displays information about a profile 
  * **InformationInput**: Takes input from user and displays relevant information using Screen.

---
### Scenario Walk-Through and Skeleton Program
The skeleton program we made contains a lot of the base components to run our future 
program. We started with following the specifications we laid out, making sure at least 
our program could run it. However further details mentioned in the specifications such
as a graphical interface and the android part of the program will be added in the 
next phase on top of the skeleton program. For now though the skeleton of our program 
works by communicating through hard coded inputs in java and receiving printed out 
statements. It shows a good outline of what our program will look like in the future and 
functions to show the general features. The scenario walk-through outlines exactly what 
our skeleton program can accomplish now and how it feeds directly to following the 
specifications.

---
### What has worked well with our design
We have yet to start working on a proper user interface to visually span our works abiding
by clean architecture. Although, we have attained to create the necessary classes to align
with our usage breakdown and CRC model. We have successfully created classes for profile
set-up (entity), workouts/routines and interacting with posts (use cases). The desired
functionality of this work has been verified through our testing file.

We have fully formed the essential classes of our app with input capability, 
enabling people to make a profile, create workouts etc. We have created a class, 
FitApp.java, consisting of hard coded inputs to show that our skeleton program works.
All of these classes contain documentation (as comments) to elaborate on what each and 
every component within the class does, for easier comprehension. Some of them, like 
User.java for instance contain getter and setter methods (to secure data or enable 
updates of data). Our own classes, the Java built-in ones and packages have been used 
appropriately when it came to implementing our code, such as ArrayLists, java.time and 
HashMaps. Some different classes share object(s), for example, objects of our own type, 
User, is one of the more popular types used in various classes.

In conclusion, with the highlighted elements utilized to ensure the functionality of our 
code (by following clean architecture, usage breakdown and CRC aspect), the base of this 
program has been properly addressed.


---
### Brief summary of what each group member worked on and what we plan on working on next
For phase 0, we decided to distribute the tasks to groups of people. For tasks with a 
heavier weight, we assigned more people. Below is a summary of our assignments:
* __Task 1 (Domain):__ Everyone discussed it during our first meeting.
* __Task 2 (Specification):__ Souren, Munim, Sana & Abdullah
* __Task 3 (CRC Model):__ Abdullah, Victor, Sana, Uthman & Munim
* __Task 4 (Scenario Walkthrough):__ Abdullah
* __Task 5 (Skeleton Program):__ Since this is weighted heavily, we further split this task
by the classes in our CRC Model. Below is a summary of what classes each person did:
  * _Uthman:_ &nbsp;&nbsp; ProfileTest, Routine, WeeklySchedule
  * _Abdullah:_ &nbsp;&nbsp; WorkoutTracker, Post, Comment
  * _Souren:_ &nbsp;&nbsp; User, ProfileManager, Profiles, Feed, FollowManager, Screen, ProfileTest, FitApp
  * _Munim:_ &nbsp;&nbsp; InformationInput(ongoing)
  * _Victor:_ &nbsp;&nbsp; RepExercise, TimedExercise, WeightedRepExercise
  * _Sana:_ &nbsp;&nbsp; Workout, Exercise
* __Task 6 (Progress Report):__ Similar to the Skeleton Program, we split this task
into sections and assigned them to each person
  * _Uthman:_ &nbsp;&nbsp; Specification
  * _Abdullah:_ &nbsp;&nbsp; CRC Model
  * _Souren:_ &nbsp;&nbsp; Scenario Walkthrough and Skeleton Program
  * _Munim:_ &nbsp;&nbsp; What has worked well with our design
  * _Victor:_ &nbsp;&nbsp; Brief summary of what each group member worked on and what we plan on 
working on next
  * _Sana:_ &nbsp;&nbsp; Open questions we are struggling with

Our future plans heavily include incorporating the Android aspect of the project and ensuring
that our design is near perfect. We want to ensure that any problems in the design are
detected early on. We also need to further develop our classes by adding more methods to
make sure they are fulfilling their responsibility. Finally, we also want to start thinking
about the User Interface of our app.

---
### Open questions we are struggling with
For phase 0, our group has made promising  progress and has shown great skills, 
however, we did face a few issues during the process. Below are some open questions 
that have given our group some trouble.

1. Understanding and importing ideas can be quite challenging, when we were creating 
the CRC model we encountered a few challenges. We were struggling in making the 
perfect CRC model, which needed a thorough understanding of our program and what 
we are really trying to do. It took us a few nights to fully implement all our ideas 
and intelligence onto the cards because we were trying to make sure that we are covering 
all the components for the same. It was crucial to correctly make the classes and 
input the methods in accordance with what it does. __Apart from this, an open question
we would like to ask is, how to properly assign the cards the specific SOLID principle 
and the clean architecture.__ It was quite confusing to comprehend what to do and how to 
implement it, but in the end we all got together and tried to figure it out as a team.  


2. We are having a hard time trying to figure out the clean architecture layers each
class represents, specifically between entity and use cases. For example, the 
WeeklySchedule class is simply just a collection of workouts, and isn’t doing anything
with them other than organizing them in a particular way, so it seems like an entity. 
But at the same time, it’s organizing them to be used in a specific way and to be displayed
by the profile, which makes it seem like it may also be a use case. __So is there a way that
we can ensure that a class is an entity and not a use case (and vice-versa)?__


3. At times, it’s hard to determine whether a class is too big and if it should be 
split up into multiple classes. For example, we struggled with determining if we should
split Profile into multiple classes. In the end, we added a FollowManager class to deal
with users they are following and followers that they have, and a Feed class to represent
the list of posts that the profile has and can view. This added an additional complication
of having to deal with an extra layer of classes. __Is there another approach to this other
than introducing the FollowManager class which consists of a list of people the profile is
following and its followers.__


4. This next question is going to be similar to the context above, but there are subtle
differences that make it important to ask it specifically. We want to know how much we
should split our classes. For example, we have the Exercise class, and an exercise consists
of reps and sets, which are just integer values. __We were wondering if it is worth 
separating a rep and a set as its own class.__


