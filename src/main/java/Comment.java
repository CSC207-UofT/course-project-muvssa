public class Comment {
    private User user;
    private String content;

    /**
     * This constructor generates a new comment
     * @param user - The user that wrote the comment
     * @param content - the string content of the comment
     */
    public Comment(User user, String content)
    {
        this.user = user;
        this.content = content;
    }

    /**
     * Getter method for content
     * @return content of the comment
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Setter method for content
     * @param content - the new content to replace current content with
     */
    public void setContent(String content) {
        this.content = content;
    }





}

