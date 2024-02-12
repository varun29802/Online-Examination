package com.Project.ENTITY;

public class Answer 
{
	private int qno;
	private String qtext;
	private String submittedAnswer;
	private String answer;
	
	public int getQno() {
		return qno;
	}
	
	public void setQno(int qno) {
		this.qno = qno;
	}
	
	public String getQtext() {
		return qtext;
	}
	
	public void setQtext(String qtext) {
		this.qtext = qtext;
	}
	
	public String getSubmittedAnswer() {
		return submittedAnswer;
	}
	
	public void setSubmittedAnswer(String submittedAnswer) {
		this.submittedAnswer = submittedAnswer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answer [qno=" + qno + ", qtext=" + qtext + ", submittedAnswer=" + submittedAnswer + ", answer=" + answer
				+ "]";
	}
	
	
	
	
	
}
