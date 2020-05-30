package exemplo_command;

import java.awt.*;

import javax.swing.*;

public class MazePanel extends JPanel // need a JPanel for Graphics
{
	private int[][] maze = { // initialize the maze 2D array
			{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0 },
			{ 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0 },
			{ 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0 },
			{ 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0 },
			{ 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
			{ 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
			{ 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0 },
			{ 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
			{ 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0 },
			{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0 },
			{ 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0 },
			{ 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0 },
			{ 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0 },
			{ 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0 },
			{ 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 2, 0, 0 } };

	private int size, start, end; // start and end are used in paintComponent to denote the starting point in a
									// different color

	public MazePanel() {
		size = 24; // size of rows/columns of the maze
		start = 0;
		end = 5;
		// solve(maze,start,end,size); // start the recursive call starting at
		// coordinate 0,5, use size to ensure that we don't go beyond the bounds of the
		// array
		repaint(); // invoke paintComponent to output the final maze

	}

	public void autoSolve() {
		if (solve(maze, start, end, size)) {
			System.out.println("Labirinto concluído demasiado facilmente 😎");
		} else {
			System.out.println("Não consegui resolver o labirinto 😢");
		}
	}

	public void unSolve() {
		for (int i = 0; i < maze.length; i++)
			for (int j = 0; j < maze[0].length; j++)
				if (maze[i][j] == 3) {
					maze[i][j] = 1;
				}
	}

	private boolean solve(int[][] m, int x, int y, int s) // m is the maze, x, y the current coordinate, s the upper
															// bound of the 2D array
	{
		if (x >= s || x < 0 || y >= s || y < 0)
			return false; // if out of bounds, return false
		else if (m[x][y] == 3)
			return false; // if we reach a 3, we've tried that path already so we are in a loop, return
							// false
		else if (m[x][y] == 2) {
			return true; // if we reach a 2 then we found the solution, return true
		} else if (m[x][y] == 0)
			return false; // if we reach a 0, we hit a wall, return false
		else {
			m[x][y] = 3; // assume this is the right path, set this location to 3 to record where we are
			if (solve(m, x + 1, y, s))
				return true; // recursive try to solve from this point forward by trying down, up, right then
								// left
			if (solve(m, x - 1, y, s))
				return true; // we try the next location from x,y if the previous one was not true (that is,
								// did not lead to a solution)
			if (solve(m, x, y + 1, s))
				return true;
			if (solve(m, x, y - 1, s))
				return true;
			m[x][y] = 1; // starting at x,y, we could not find a way out, so reset this location to 1 and
							// return false
			return false;
		}
	}

	private void checkPosition() {
		if (start >= size || start < 0 || end >= size || end < 0) {
			// if out of bounds, return false
			start = 0;
			end = 5;
		}

		else if (maze[start][end] == 2) {
			// if we reach a 2 then we found the solution, return true
			start = 0;
			end = 5;
		} else if (maze[start][end] == 0) {
			// if we reach a 0, we hit a wall, return false
			start = 0;
			end = 5;
		}
	}

	public void paintComponent(Graphics g) // draw the maze with solution
	{
		super.paintComponent(g);
		for (int j = 0; j < size; j++) // iterate through all i,j locations in the maze
			for (int i = 0; i < size; i++) {
				if (i == start && j == end)
					g.setColor(Color.yellow); // starting point in yellow
				else if (maze[i][j] == 0)
					g.setColor(Color.white); // walls are white
				else if (maze[i][j] == 1)
					g.setColor(Color.black); // path is black
				else if (maze[i][j] == 2)
					g.setColor(Color.red); // ending point is red
				else
					g.setColor(Color.blue); // solution is blue
				g.fillRect(i * 20, j * 20, 20, 20); // draw each part of the maze using the above set color
			}
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
		checkPosition();
		repaint();
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
		checkPosition();
		repaint();
	}

}
