package grafo1;

import java.util.ArrayList;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class Grafoss {

	public static void main(String[] args) {

		Graph g = new SingleGraph("Exemplo1");
		
		int[][] matriz = new int[5][5];
		
		// 1-------- -----
		matriz[0][0] = 0;
		matriz[0][1] = 1;
		matriz[0][2] = 1;
		matriz[0][3] = 0;
		matriz[0][4] = 1;
		// ---------------

		// 2--------------
		matriz[1][0] = 1;
		matriz[1][1] = 0;
		matriz[1][2] = 1;
		matriz[1][3] = 1;
		matriz[1][4] = 0;
		// ---------------

		// 3--------------
		matriz[2][0] = 1;
		matriz[2][1] = 1;
		matriz[2][2] = 0;
		matriz[2][3] = 1;
		matriz[2][4] = 1;
		// ---------------

		// 4--------------
		matriz[3][0] = 0;
		matriz[3][1] = 0;
		matriz[3][2] = 1;
		matriz[3][3] = 1;
		matriz[3][4] = 0;
		// ---------------

		// 5--------------
		matriz[4][0] = 1;
		matriz[4][1] = 0;
		matriz[4][2] = 1;
		matriz[4][3] = 0;
		matriz[4][4] = 0;
		// ---------------

		g.addNode("1");
		g.addNode("2");
		g.addNode("3");
		g.addNode("4");
		g.addNode("5");

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {

				if (matriz[i][j] == 1) {
					 
					String edg = (i + 1) + "-" + (j + 1);

					System.out.println(edg);

					String vertice1 = "" + (i + 1);

					String vertice2 = "" + (j + 1);
					
					matriz[j][i] = 0; // faz isso para não gerar um erro.
					
					System.out.println("origem "+vertice1);
					
					System.out.println("destino "+vertice2);
									
					g.addEdge(edg, vertice1, vertice2);		
							
				}
			}
			System.out.println("");
		}
		
		
		g.getNode("1").addAttribute("ui.label", "1");
		g.getNode("2").addAttribute("ui.label", "2");
		g.getNode("3").addAttribute("ui.label", "3");
		g.getNode("4").addAttribute("ui.label", "4");
		g.getNode("5").addAttribute("ui.label", "5");
		
		g.display();

	}
	
}
