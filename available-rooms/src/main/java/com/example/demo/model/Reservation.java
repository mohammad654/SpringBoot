package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reservation{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	// private Customer customer;
	private LocalDate startDate;
	private LocalDate endDate;
	private int tableId;

	@ManyToOne
	private Room room;
	private boolean seaView;

	public Reservation() {
	}

	public Reservation(LocalDate startDate, LocalDate endDate, int tableId, Room room, boolean seaView) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.tableId = tableId;
		this.room = room;
		this.seaView = seaView;
	}

	public long getId(){
		return id;
	}
	public void setId( long id){
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public boolean isSeaView() {
		return seaView;
	}

	public int getTableId(){
		return tableId;
	}
	public void setTableId( int tableId){
		this.tableId = tableId;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public boolean getSeaView(){
		return seaView;
	}
	public void setSeaView( boolean seaView){
		this.seaView = seaView;
	}

}
