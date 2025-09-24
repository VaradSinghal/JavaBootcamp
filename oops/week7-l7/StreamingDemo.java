class Content {
    protected String title;

    public Content(String title) {
        this.title = title;
    }

    public void play() {
        System.out.println("Playing: " + title);
    }
}

class Movie extends Content {
    private double rating;
    private int duration;
    private boolean subtitles;

    public Movie(String title, double rating, int duration, boolean subtitles) {
        super(title);
        this.rating = rating;
        this.duration = duration;
        this.subtitles = subtitles;
    }

    public void showDetails() {
        System.out.println("Movie: " + title + " | Rating: " + rating + " | Duration: " + duration + " mins | Subtitles: " + (subtitles ? "Yes" : "No"));
    }
}

class TVSeries extends Content {
    private int seasons;
    private int episodes;

    public TVSeries(String title, int seasons, int episodes) {
        super(title);
        this.seasons = seasons;
        this.episodes = episodes;
    }

    public void suggestNextEpisode() {
        System.out.println("TV Series: " + title + " | Seasons: " + seasons + " | Episodes: " + episodes);
        System.out.println("Suggestion: Watch next episode!");
    }
}

class Documentary extends Content {
    private String tag;

    public Documentary(String title, String tag) {
        super(title);
        this.tag = tag;
    }

    public void showEducationalInfo() {
        System.out.println("Documentary: " + title + " | Tag: " + tag);
    }
}

public class StreamingDemo {
    public static void main(String[] args) {
        Content[] watchlist = new Content[3];
        watchlist[0] = new Movie("Inception", 8.8, 148, true);
        watchlist[1] = new TVSeries("Breaking Bad", 5, 62);
        watchlist[2] = new Documentary("Planet Earth", "Nature");

        for (Content c : watchlist) {
            c.play();
            if (c instanceof Movie) {
                Movie m = (Movie) c;
                m.showDetails();
            } else if (c instanceof TVSeries) {
                TVSeries t = (TVSeries) c;
                t.suggestNextEpisode();
            } else if (c instanceof Documentary) {
                Documentary d = (Documentary) c;
                d.showEducationalInfo();
            }
            System.out.println();
        }
    }
}
