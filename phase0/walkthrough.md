# Walkthrough

---
A typical walkthrough of our program would start with the user creating their account. 
This would be done using the Profiles class which would create a new Profile 
(and that Profile class will construct a User object) for the user. This user can now 
log in to the app using their username and password. The Profiles class would log the 
user in and select the appropriate Profile object for the user. The user would then be 
presented with a few options.

They can create a new workout, adding different types of exercises. This would require 
the use of Workout and Exercise classes. The Exercise classes family include TimedExercise,
RepExercise, WeightRepBased classes.

Using the workouts created, they can create a routine of multiple workouts, which is done by
the Routine class. A routine allows the user to organize their workouts.

They can also create a weekly schedule, assigning workouts to specific days. This is done
through the WeeklySchedule class.

Once they’re done setting up their routines and workouts, they can begin tracking their 
workouts (the number of sets, reps and rest time). This will also allow the app to generate
useful statistics for the user. This is managed by the WorkoutTracker class.

Once their workout is finished, it will be stored inside WorkoutTracker, but also, a social
media post for that workout will be created (Through the Post class). This post will then 
be published on the user’s profile. This post will be stored in the Feed class that the 
profile keeps an object of.

Other users can leave a comment (via the Comment class) and like a particular post on the
user’s profile.

Furthermore, the user will be able to follow other users and other users will be able to 
follow the user. This is managed by the FollowManager class object inside the profile.

All the input will be taken by InformationInput class and displayed by Screen class. 
This is temporary and will eventually be replaced by an Android App interface
