package bootcamp.java2017.ClaseHibernate.Model;

public class Note {
	private Integer partialNoteA;
	private Integer partialNoteB;
	private Integer partialNoteC;
	private Integer finalNote;
	
	public Note(){
	}
	
	public void setNoteA(Integer note){
		this.partialNoteA = note;
	}
	public void setNoteB(Integer note){
		this.partialNoteB = note;
	}
	public void setNoteC(Integer note){
		this.partialNoteC = note;
	}
	public void setFinalNote(Integer note){
		this.finalNote = note;
	}
	public Integer getNoteA(){
		return this.partialNoteA;
	}
	public Integer getNoteB(){
		return this.partialNoteB;
	}
	public Integer getNoteC(){
		return this.partialNoteC;
	}
	public Integer getFinalNote(){
		return this.finalNote;
	}
}
