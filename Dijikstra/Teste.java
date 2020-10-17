package Dijikstra;

import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class Teste {
	public static Graph exampleGraph() {

		Graph g = new SingleGraph("example");

		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.addNode("d");
		g.addNode("e");
		g.addNode("f");
		g.addNode("g");
		g.addNode("h");

		g.addEdge("a - b", "a", "b").addAttribute("custo", 3);
		g.addEdge("a - c", "a", "c").addAttribute("custo", 5);
		g.addEdge("a - d", "a", "d").addAttribute("custo", 2);
		g.addEdge("a - h", "a", "h").addAttribute("custo",10);
		//

		g.addEdge("b - c", "b", "c").addAttribute("custo", 5);
		g.addEdge("b - d", "b", "d").addAttribute("custo", 8);
		g.addEdge("b - e", "b", "e").addAttribute("custo", 4);
		g.addEdge("b - g", "b", "g").addAttribute("custo", 6);
		g.addEdge("b - h", "b", "h").addAttribute("custo", 6);
		//
		g.addEdge("c - e", "c", "e").addAttribute("custo", 1);
		g.addEdge("c - f", "c", "f").addAttribute("custo", 7);
		g.addEdge("c - g", "c", "g").addAttribute("custo", 9);
		//
		g.addEdge("d - e", "d", "e").addAttribute("custo", 12);
		g.addEdge("d - h", "d", "h").addAttribute("custo", 14);
		//
		g.addEdge("e - g", "e", "g").addAttribute("custo", 15);
		//
		g.addEdge("f - h", "f", "h").addAttribute("custo", 9);
		//
		g.addEdge("g - h", "g", "h").addAttribute("custo", 3);


		for (Node n : g)
			n.addAttribute("label", n.getId());

		for (Edge e : g.getEachEdge())
			e.addAttribute("label", "" + (int) e.getNumber("custo"));

		return g;
	}

	public static void main(String[] args) {
		Graph g = exampleGraph();
		g.display(false);

		// Atributo "custo" tem o custo das arestas
		Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "custo");

		// O caminho mais curto partindo de A para todos os outros vértices
		dijkstra.init(g);
		dijkstra.setSource(g.getNode("a"));
		dijkstra.compute();

		// comprimento de todos os caminhos mais curtos
		for (Node node : g)
			System.out.printf("%s->%s:%10.2f%n", dijkstra.getSource(), node, dijkstra.getPathLength(node));

		// Pinte em azul todos os nós no caminho mais curto de A a B
		for (Node node : dijkstra.getPathNodes(g.getNode("g")))
			node.addAttribute("ui.style", "fill-color: blue;");

		// Color in red all the edges in the shortest path tree
//	for (Edge edge : dijkstra.getTreeEdges())
//		edge.addAttribute("ui.style", "fill-color: red;");

		// Print the shortest path from A to B
  	System.out.println(dijkstra.getPath(g.getNode("g")));

		// Build a list containing the nodes in the shortest path from A to B
		// Note that nodes are added at the beginning of the list
		// because the iterator traverses them in reverse order, from B to A
//	List<Node> list1 = new ArrayList<Node>();
//	for (Node node : dijkstra.getPathNodes(g.getNode("B")))
//     	list1.add(0, node);

		// A shorter but less efficient way to do the same thing
//	List<Node> list2 = dijkstra.getPath(g.getNode("B")).getNodePath();

		// cleanup to save memory if solutions are no longer needed
//	dijkstra.clear();

		// Now compute the shortest path from A to all the other nodes
		// but taking the number of nodes in the path as its length
//	dijkstra = new Dijkstra(Dijkstra.Element.NODE, null, null);
//	dijkstra.init(g);
//	dijkstra.setSource(g.getNode("A"));
//	dijkstra.compute();

		// Print the lengths of the new shortest paths
//	for (Node node : g)
//		System.out.printf("%s->%s:%10.2f%n", dijkstra.getSource(), node,
//				dijkstra.getPathLength(node));

		// Print all the shortest paths between A and F
//	Iterator<Path> pathIterator = dijkstra.getAllPathsIterator(g.getNode("F"));
//	while (pathIterator.hasNext())
//		System.out.println(pathIterator.next());
	}
}