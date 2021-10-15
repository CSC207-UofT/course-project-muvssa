import java.util.ArrayList;

public class Post {
    private Workout workout;
    private ArrayList<Comment> comments;
    private ArrayList<User> likes;
    private String content;

    /**
     * Creates a new post given a workout
     * @param workout - The workout to create the post for.
     * @param content - Any details regarding the workout
     */
    public Post(Workout workout, String content)
    {
        this.workout = workout;
        this.content = content;
    }

    /**
     *  Adds a comment into the post
     * @param comment - the actual comment
     */
    public void addComment(Comment comment)
    {
        this.comments.add(comment);
    }

    /**
     * Adds a like into the post
     * @param user - the user who liked the post
     */
    public void addLike(User user)
    {
        this.likes.add(user);
    }

    /**
     *
     * @return the number of total users that liked this post
     */
    public int getTotalLikes()
    {
        return this.likes.size();
    }

}



