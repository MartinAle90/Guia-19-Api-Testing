public class FilmPojo {
    private String title;
    private int episode_id;
    private String opening_crawl;

    private String director;

    private String producer;

    private String release_date;

    private String[] characters;

    private String[] planets;

    private String[] starships;

    private String[] vehicles;
    private String[] species;
    private String created;
    private String edited;
    private String url;

    public FilmPojo(String title, int episode_id, String opening_crawl, String director, String producer, String release_date, String[] characters, String[] planets, String[] starships, String[] vehicles, String[] species, String created, String edited, String url) {
        this.title = title;
        this.episode_id = episode_id;
        this.opening_crawl = opening_crawl;
        this.director = director;
        this.producer = producer;
        this.release_date = release_date;
        this.characters = characters;
        this.planets = planets;
        this.starships = starships;
        this.vehicles = vehicles;
        this.species = species;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    public FilmPojo() {
    }

    public String getTitle() {
        return title;
    }

    public int getEpisode_id() {
        return episode_id;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String[] getCharacters() {
        return characters;
    }

    public String[] getPlanets() {
        return planets;
    }

    public String[] getStarships() {
        return starships;
    }

    public String[] getVehicles() {
        return vehicles;
    }

    public String[] getSpecies() {
        return species;
    }

    public String getCreated() {
        return created;
    }

    public String getEdited() {
        return edited;
    }

    public String getUrl() {
        return url;
    }
}
