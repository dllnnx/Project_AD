package com.example.project_ad;

import java.io.Serializable;

public class Tof_Task implements Serializable {
	private long id;
	private String ruWord, enWord;
	private int bool;

	public Tof_Task(long id, String ruWord, String enWord, int bool) {
		this.id = id;
		this.ruWord = ruWord;
		this.enWord = enWord;
		this.bool = bool;
	}

	public long getId() {
		return id;
	}

	public String getRuWord() {
		return ruWord;
	}

	public String getEnWord() {
		return enWord;
	}

	public int getBool() {
		return bool;
	}
}
