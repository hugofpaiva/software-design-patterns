package exemplo_command;

import java.awt.*;

import javax.swing.*;

public class MazePanel extends JPanel {
	private int[][] maze = { // Criado de forma estática para mais facil visualização do labirinto antes de
								// executar
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

	private int size, x, y; // Size corresponde ao tamanho do labirinto, x à posição do jogador no eixo
							// horizontal e y à posição do jogador no eixo vertical

	// Criação do labirinto
	public MazePanel() {
		size = 24;
		x = 0;
		y = 5;
		repaint();

	}

	// Soluciona o labirinto criando um caminho desde a posição do jogador até à
	// posição final
	public void autoSolve() {
		if (solve(maze, x, y, size)) {
			System.out.println("Labirinto concluído demasiado facilmente 😎");
		} else {
			System.out.println("Não consegui resolver o labirinto 😢");
		}
	}

// Desfaz a solução do labirinto
	public void unSolve() {
		for (int i = 0; i < maze.length; i++)
			for (int j = 0; j < maze[0].length; j++)
				if (maze[i][j] == 3) {
					maze[i][j] = 1;
				}
	}

	private boolean solve(int[][] m, int x, int y, int s) // m é o labirinto, x, y as coordenadas atuais e s os limites
															// máximos do labirinto
	{
		if (x >= s || x < 0 || y >= s || y < 0)
			return false; // Fora dos limites
		else if (m[x][y] == 3)
			return false; // Entrou-se num loop
		else if (m[x][y] == 2) {
			return true; // Encontrou-se a solução
		} else if (m[x][y] == 0)
			return false; // Encontrou-se uma parede
		else {
			m[x][y] = 3; // Estamos no caminho certo, guardamos esta coordenado com valor 3 para
							// sinalizar isso mesmo
			// A partir daqui tenta-se resolver, recursivamente, para todos os 4 lados
			// possíveis
			if (solve(m, x + 1, y, s))
				return true;
			if (solve(m, x - 1, y, s))
				return true;
			if (solve(m, x, y + 1, s))
				return true;
			if (solve(m, x, y - 1, s))
				return true;
			m[x][y] = 1; // No caso de não se ter encontrado nenhum caminho, voltamos a colocar o valor 1
			return false;
		}
	}

	private void checkPosition() {
		// Verificação se batemos em alguma parede, saímos fora dos limites do jogo ou
		// terminámos o jogo. Voltamos para o início em caso afirmativo
		if (x >= size || x < 0 || y >= size || y < 0) {
			x = 0;
			y = 5;
		} else if (maze[x][y] == 2) {
			x = 0;
			y = 5;
		} else if (maze[x][y] == 0) {
			x = 0;
			y = 5;
		}
	}

	// Desenha o labirinto
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int j = 0; j < size; j++) 
			for (int i = 0; i < size; i++) {
				if (i == x && j == y)
					g.setColor(Color.yellow); // Ponto de início
				else if (maze[i][j] == 0)
					g.setColor(Color.white); // Paredes
				else if (maze[i][j] == 1)
					g.setColor(Color.black); // Caminho
				else if (maze[i][j] == 2)
					g.setColor(Color.red); // Chegada
				else
					g.setColor(Color.blue); // Caminho da solução
				g.fillRect(i * 20, j * 20, 20, 20);
			}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		checkPosition();
		repaint();
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		checkPosition();
		repaint();
	}

}
