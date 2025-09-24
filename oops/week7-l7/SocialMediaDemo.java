import java.time.LocalDateTime;

class SocialMediaPost {
    protected String author;
    protected String content;
    protected LocalDateTime time;

    public SocialMediaPost(String author, String content) {
        this.author = author;
        this.content = content;
        this.time = LocalDateTime.now();
    }

    public void display() {
        System.out.println("Post by " + author + " at " + time);
        System.out.println(content);
    }
}

class InstagramPost extends SocialMediaPost {
    private int likes;

    public InstagramPost(String author, String content, int likes) {
        super(author, content);
        this.likes = likes;
    }

    @Override
    public void display() {
        System.out.println("Instagram Post by @" + author + " at " + time);
        System.out.println("#" + content.replace(" ", " #"));
        System.out.println("Likes: " + likes);
    }
}

class TwitterPost extends SocialMediaPost {
    private int retweets;

    public TwitterPost(String author, String content, int retweets) {
        super(author, content);
        this.retweets = retweets;
    }

    @Override
    public void display() {
        System.out.println("Tweet by @" + author + " at " + time);
        System.out.println(content + " (" + content.length() + " chars)");
        System.out.println("Retweets: " + retweets);
    }
}

class LinkedInPost extends SocialMediaPost {
    private int connections;

    public LinkedInPost(String author, String content, int connections) {
        super(author, content);
        this.connections = connections;
    }

    @Override
    public void display() {
        System.out.println("LinkedIn Post by " + author + " | " + connections + " connections");
        System.out.println("\"" + content + "\"");
        System.out.println("Posted on: " + time.toLocalDate());
    }
}

public class SocialMediaDemo {
    public static void main(String[] args) {
        SocialMediaPost[] feed = new SocialMediaPost[3];
        feed[0] = new InstagramPost("alice", "sunset vibes at the beach", 340);
        feed[1] = new TwitterPost("bob_dev", "Java overriding makes OOP powerful!", 76);
        feed[2] = new LinkedInPost("carol_smith", "Excited to start my new role at TechCorp!", 500);

        for (SocialMediaPost post : feed) {
            post.display();
            System.out.println();
        }
    }
}
