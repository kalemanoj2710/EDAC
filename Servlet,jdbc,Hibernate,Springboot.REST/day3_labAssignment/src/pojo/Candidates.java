package pojo;

public class Candidates {
/*create table candidates(id int primary key auto_incre
name varchar(20) unique,party varchar(20),votes int);*/
	private int id;
	private String name;
	private String party;
	private int votes;
	public Candidates(int id, String name, String party, int votes) {
		super();
		this.id = id;
		this.name = name;
		this.party = party;
		this.votes = votes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	@Override
	public String toString() {
		return "Candidates [id=" + id + ", name=" + name + ", party=" + party + ", votes=" + votes + "]";
	}
	
}
