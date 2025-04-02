package usantatecla.movies.vAdrianAlonso;

public class MovieBuilder {

	private String title;
	
	private Price price;
	private Movie movie;
	
	public MovieBuilder() {
		title = "movieName";
	}
	
	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public MovieBuilder childrens() {
		this.movie = new ChildrenMovie(this.title, this.price);
		return this;
	}
	
	public MovieBuilder regular() {
		this.movie = new RegularMovie(this.title, this.price);
		return this;
	}
	
	public MovieBuilder newRelease() {
		this.movie = new NewReleaseMovie(this.title, this.price);
		return this;
	}
	
	public Movie build() {
		return this.movie;
	}
}
