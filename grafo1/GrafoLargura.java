package grafo1;

import org.graphstream.graph.DepthFirstIterator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;



public class GrafoLargura {

	public static void main(String[] args) throws InterruptedException {
		Graph g = new SingleGraph("Buscas");

		g.addNode("1");
		g.addNode("2");
		g.addNode("3");
		g.addNode("4");
		g.addNode("5");
		g.addNode("6");
		g.addNode("7");

//		GRAFO 1
		/*
		g.addEdge("1-2", "1", "2");
		g.addEdge("1-3", "1", "3");
		g.addEdge("1-4", "1", "4");
		g.addEdge("2-4", "2", "4");
		g.addEdge("2-6", "2", "6");
		g.addEdge("3-4", "3", "4");
		g.addEdge("4-7", "4", "7");
		g.addEdge("5-6", "5", "6");
		g.addEdge("5-7", "5", "7");
		g.addEdge("6-7", "6", "7");
*/
//		GRAFO 2
//		g.addEdge("1-2", "1", "2");
//		g.addEdge("1-5", "1", "5");
//		g.addEdge("1-6", "1", "6");
//		g.addEdge("2-7", "2", "7");
//		g.addEdge("5-4", "5", "4");
//		g.addEdge("7-3", "7", "3");
//		g.addEdge("7-4", "7", "4");

//		GRAFO 3
//		g.addEdge("1-2", "1", "2");
//		g.addEdge("1-4", "1", "4");
//		g.addEdge("2-3", "2", "3");
//		g.addEdge("2-6", "2", "6");
//		g.addEdge("4-5", "4", "5");
//		g.addEdge("5-6", "5", "6");
//		g.addEdge("6-7", "6", "7");

		g.getNode("1").addAttribute("ui.label", "1");
		g.getNode("2").addAttribute("ui.label", "2");
		g.getNode("3").addAttribute("ui.label", "3");
		g.getNode("4").addAttribute("ui.label", "4");
		g.getNode("5").addAttribute("ui.label", "5");
		g.getNode("6").addAttribute("ui.label", "6");
		g.getNode("7").addAttribute("ui.label", "7");

		g.display();
		g.addAttribute("ui.stylesheet", estilos());

		DepthFirstIterator<Node> it = new DepthFirstIterator<Node>(g.getNode("7"));// profundidade
		// BreadthFirstIterator<Node> it = new
		// BreadthFirstIterator<Node>(g.getNode("7"));//largura
		while (it.hasNext()) {

			Node n = it.next();
			n.addAttribute("ui.class", "visitado");
			System.out.print(n.getLabel("ui.label") + "\t");
			
			for (Edge e : n.getEachEdge()) {
				e.addAttribute("ui.class", "percorrida");
				Thread.sleep(1000);
			}

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
