package fitappfiles;

import java.io.Serializable;
import java.util.ArrayList;

public class Feed implements Serializable {
    private final ArrayList<Post> posts;

    /**
     * Constructor creating an ArrayList of Posts
     */
    public Feed(){
        this.posts = new ArrayList<>();
    }

    /**
     * adds a post to the ArrayList
     * @param workout is the workout in the post
     * @param content is the String writing making the post
     */
    public void addPost(Workout workout, String content){
        Post post = new Post(workout,content);
        this.posts.add(post);
    }

    /**
     * get all posts from the User
     * @return return an ArrayList of Posts
     */
    public ArrayList<Post> getPosts(){
        return this.posts;
    }

    /**
     * Gets a single post
     * @param postNumb the index of the post you want
     * @return returns a single post at postNumb index
     */
    public Post getPost(int postNumb){
        return this.posts.get(postNumb);
    }

}
