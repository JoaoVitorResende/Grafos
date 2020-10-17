package grafo1;

import org.graphstream.graph.BreadthFirstIterator;
import org.graphstream.graph.DepthFirstIterator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class GrafoProfundidade {

	public static void main(String[] args) throws InterruptedException {
		
		Graph g = new SingleGraph("Buscas");

		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.addNode("d");
		g.addNode("e");
		g.addNode("f");
		g.addNode("g");
		g.addNode("h");
		g.addNode("i");
		g.addNode("j");
		g.addNode("k");
		//
		g.addEdge("c - a", "c", "a",true);
		g.addEdge("c - d", "c", "d",true);
		g.addEdge("c - f", "c", "f",true);
		//
		g.addEdge("a - b", "a", "b",true);
		g.addEdge("a - g", "a", "g",true);
		//
		g.addEdge("d - e", "d", "e",true);
		//
		g.addEdge("g - k", "g", "k",true);
		//g.addEdge("g - f", "g", "f",true);
		//
		//g.addEdge("e - f", "e", "f",true);
		g.addEdge("e - h", "e", "h",true);
		
		//
		g.addEdge("h - i", "h", "i",true);
		//
		g.addEdge("i - j", "i", "j",true);
		//
		
		
		
		g.getNode("a").addAttribute("ui.label", "a");
		g.getNode("b").addAttribute("ui.label", "b");
		g.getNode("c").addAttribute("ui.label", "c");
		g.getNode("d").addAttribute("ui.label", "d");
		g.getNode("e").addAttribute("ui.label", "e");
		g.getNode("f").addAttribute("ui.label", "f");
		g.getNode("g").addAttribute("ui.label", "g");
		g.getNode("h").addAttribute("ui.label", "h");
		g.getNode("i").addAttribute("ui.label", "i");
		g.getNode("j").addAttribute("ui.label", "j");
		g.getNode("k").addAttribute("ui.label", "k");
	
		g.display();
		g.addAttribute("ui.stylesheet", estilos());

		/*
		 1- tubarao
		 2- capivari
		 3- jaguaruna
		 4- pindotila
		 5- gravatal
		 6- laguna
		 7- garopaba do sul
		 8- orleans
		 9- armazem
		 10- braço do norte
		 11- imbituba
		 12- são ludgero
		 13- lauro muller
		 14- aiurê
		 15- Paulo lopes
		 16- treviso
		 
		 */
		
		//DepthFirstIterator<Node> it = new DepthFirstIterator<Node>(g.getNode("b"));// profundidade
		BreadthFirstIterator<Node> it = new BreadthFirstIterator<Node>(g.getNode("c"));//largura
		while (it.hasNext()) {

			Node n = it.next();
			n.addAttribute("ui.class", "visitado");
			System.out.print(n.getLabel("ui.label") + "\t");
			
			/*if(n.getLabel("ui.label").equals("11")) {
				break;
			}*/
			

		/* for (Edge e : n.getEachEdge()) {
				
				e.addAttribute("ui.class", "percorrida");
				Thread.sleep(1000);
			}*/
		}
	}

	public static String estilos() {
	   return "edge {  " + "fill-color: black;" + "size: 4px;" + "}"

			+ "edge.percorrida {  " + "fill-color: rgb(200,39,65);" + "size: 5px;" + "}"

			+ "node{" + "fill-color: rgb(0,100,255);" + "size: 30px, 30px;" + "text-color: black;"
			+ "text-size: 30;" + "text-style:bold;" + "}"

			+ "node.visitado{" + "fill-color: red;" + "size: 30px, 30px;" + "text-color: black;" + "text-size: 30;"
			+ "text-style:bold;" + "}";
		}
}
