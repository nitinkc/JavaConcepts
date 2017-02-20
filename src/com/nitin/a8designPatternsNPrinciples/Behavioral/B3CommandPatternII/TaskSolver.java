package com.nitin.a8designPatternsNPrinciples.Behavioral.B3CommandPatternII;

public class TaskSolver implements Command {

	private Task task;
	
	public TaskSolver(Task task){
		this.task = task;
	}
	
	@Override
	public void execute() {
		this.task.solveProblem();
	}
}
