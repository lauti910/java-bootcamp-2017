package bootcamp.java2017.ClaseHibernate.Model;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private LocalTime startTime;
	private LocalTime finishTime;
	private DayOfWeek dayOfTheWeek;
	
	public Schedule(LocalTime startTime, LocalTime finishTime, DayOfWeek day){
		this.dayOfTheWeek = day;
		this.finishTime = finishTime;
		this.startTime = startTime;
	}
	public Integer getAmountOfHours() {
		//15hs - 14hs = 1h
		return this.finishTime.getHour() - this.startTime.getHour();
	}

}
