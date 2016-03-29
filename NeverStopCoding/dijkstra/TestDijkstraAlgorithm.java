package dijkstra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import dijkstra.DijkstraAlgorithm;
import dijkstra.Edge;
import dijkstra.Graph;
import dijkstra.Vertex;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestDijkstraAlgorithm {

	private List<Vertex> nodes;
	private List<Vertex> demandNodes;
	private List<Edge> edges;

	@Test
	public void testExcute() {
		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		for (int i = 0; i < 11; i++) {
			Vertex location = new Vertex("Node_" + i, "Node_" + i);
			nodes.add(location);
		}

		addLane("Edge_0", 0, 1, 85);
		addLane("Edge_1", 0, 2, 217);
		addLane("Edge_2", 0, 4, 173);
		addLane("Edge_3", 2, 6, 186);
		addLane("Edge_4", 2, 7, 103);
		addLane("Edge_5", 3, 7, 183);
		addLane("Edge_6", 5, 8, 250);
		addLane("Edge_7", 8, 9, 84);
		addLane("Edge_8", 7, 9, 167);
		addLane("Edge_9", 4, 9, 502);
		addLane("Edge_10", 9, 10, 40);
		addLane("Edge_11", 1, 10, 600);

		// Lets check from location Loc_1 to Loc_10
		Graph graph = new Graph(nodes, edges);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		dijkstra.execute(nodes.get(0));
		LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));

		assertNotNull(path);
		assertTrue(path.size() > 0);

		for (Vertex vertex : path) {
			System.out.println(vertex);
		}

	}
	
	@Test
	public void testCase0() {
		nodes = new ArrayList<Vertex>();
		demandNodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		
		// 顶点集合：4个节点（0-3）
		for (int i = 0; i < 4; i++) {
			Vertex location = new Vertex("Node_" + i, "Node_" + i);
			nodes.add(location);
		}
		
		// 需求顶点集合：节点2和3
		demandNodes.add(new Vertex("Node_2", "Node_2"));
		demandNodes.add(new Vertex("Node_3", "Node_3"));
		
		// 边集合：6条边
		addLane("Edge_0", 0, 1, 1);
		addLane("Edge_1", 0, 2, 2);
		addLane("Edge_2", 0, 3, 1);
		addLane("Edge_3", 2, 1, 3);
		addLane("Edge_4", 3, 1, 1);
		addLane("Edge_5", 2, 3, 1);
		addLane("Edge_6", 3, 2, 1);

		// Lets check from location Loc_0 to Loc_1
		Graph graph = new Graph(nodes, edges);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		dijkstra.execute(nodes.get(0), demandNodes);
		LinkedList<Vertex> path = dijkstra.getPath(nodes.get(1));

		assertNotNull(path);
		assertTrue(path.size() > 0);

		for (Vertex vertex : path) {
			System.out.println(vertex);
		}

	}
	
	@Test
	public void testCase1_1() {
		nodes = new ArrayList<Vertex>();
		demandNodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		
		// 顶点集合：20个节点（0-19）
		for (int i = 0; i < 20; i++) {
			Vertex location = new Vertex("Node_" + i, "Node_" + i);
			nodes.add(location);
		}
		
		// 需求顶点集合：节点2和3
		demandNodes.add(new Vertex("Node_3", "Node_3"));
		demandNodes.add(new Vertex("Node_5", "Node_5"));
		demandNodes.add(new Vertex("Node_7", "Node_7"));
		demandNodes.add(new Vertex("Node_11", "Node_11"));
		demandNodes.add(new Vertex("Node_13", "Node_13"));
		demandNodes.add(new Vertex("Node_17", "Node_17"));
		
		// 45条边
		addLane("Edge_0", 0, 13, 15);
		addLane("Edge_1", 0, 8, 17);
		addLane("Edge_2", 0, 19, 1);
		addLane("Edge_3", 0, 4, 8);
		addLane("Edge_4", 1, 0, 4);
		addLane("Edge_5", 2, 9, 19);
		addLane("Edge_6", 2, 15, 8);
		addLane("Edge_7", 3, 0, 14);
		addLane("Edge_8", 3, 11, 12);
		addLane("Edge_9", 4, 1, 15);
		addLane("Edge_10", 4, 5, 17);
		addLane("Edge_11", 5, 8, 18);
		addLane("Edge_12", 5, 9, 14);
		addLane("Edge_13", 5, 6, 2);
		addLane("Edge_14", 6, 17, 4);
		addLane("Edge_15", 7, 13, 1);
		addLane("Edge_16", 7, 16, 19);
		addLane("Edge_17", 8, 6, 1);
		addLane("Edge_18", 8, 12, 17);
		addLane("Edge_19", 9, 14, 11);
		addLane("Edge_20", 10, 12, 1);
		addLane("Edge_21", 11, 7, 12);
		addLane("Edge_22", 11, 4, 7);
		addLane("Edge_23", 12, 14, 5);
		addLane("Edge_24", 13, 17, 12);
		addLane("Edge_25", 13, 4, 2);
		addLane("Edge_26", 14, 19, 9);
		addLane("Edge_27", 15, 10, 14);
		addLane("Edge_28", 15, 18, 2);
		addLane("Edge_29", 16, 18, 1);
		addLane("Edge_30", 17, 9, 14);
		addLane("Edge_31", 17, 19, 3);
		addLane("Edge_32", 17, 18, 10);
		addLane("Edge_33", 18, 15, 8);
		addLane("Edge_34", 18, 3, 8);
		addLane("Edge_35", 19, 18, 12);
		addLane("Edge_36", 2, 3, 20);
		addLane("Edge_37", 3, 5, 20);
		addLane("Edge_38", 5, 7, 20);
		addLane("Edge_39", 7, 11, 20);
		addLane("Edge_40", 11, 13, 20);
		addLane("Edge_41", 17, 11, 20);
		addLane("Edge_42", 11, 19, 20);
		addLane("Edge_43", 17, 5, 20);
		addLane("Edge_44", 5, 19, 20);

		// Lets check from location Loc_2 to Loc_19
		Graph graph = new Graph(nodes, edges);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		dijkstra.execute(nodes.get(2), demandNodes);
		LinkedList<Vertex> path = dijkstra.getPath(nodes.get(19));

		assertNotNull(path);
		assertTrue(path.size() > 0);

		for (Vertex vertex : path) {
			System.out.println(vertex);
		}

	}
	
	@Test
	public void testCase1_0() {
		nodes = new ArrayList<Vertex>();
		demandNodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		
		// 顶点集合：20个节点（0-19）
		for (int i = 0; i < 20; i++) {
			Vertex location = new Vertex("Node_" + i, "Node_" + i);
			nodes.add(location);
		}
		
		// 45条边
		addLane("Edge_0", 0, 13, 15);
		addLane("Edge_1", 0, 8, 17);
		addLane("Edge_2", 0, 19, 1);
		addLane("Edge_3", 0, 4, 8);
		addLane("Edge_4", 1, 0, 4);
		addLane("Edge_5", 2, 9, 19);
		addLane("Edge_6", 2, 15, 8);
		addLane("Edge_7", 3, 0, 14);
		addLane("Edge_8", 3, 11, 12);
		addLane("Edge_9", 4, 1, 15);
		addLane("Edge_10", 4, 5, 17);
		addLane("Edge_11", 5, 8, 18);
		addLane("Edge_12", 5, 9, 14);
		addLane("Edge_13", 5, 6, 2);
		addLane("Edge_14", 6, 17, 4);
		addLane("Edge_15", 7, 13, 1);
		addLane("Edge_16", 7, 16, 19);
		addLane("Edge_17", 8, 6, 1);
		addLane("Edge_18", 8, 12, 17);
		addLane("Edge_19", 9, 14, 11);
		addLane("Edge_20", 10, 12, 1);
		addLane("Edge_21", 11, 7, 12);
		addLane("Edge_22", 11, 4, 7);
		addLane("Edge_23", 12, 14, 5);
		addLane("Edge_24", 13, 17, 12);
		addLane("Edge_25", 13, 4, 2);
		addLane("Edge_26", 14, 19, 9);
		addLane("Edge_27", 15, 10, 14);
		addLane("Edge_28", 15, 18, 2);
		addLane("Edge_29", 16, 18, 1);
		addLane("Edge_30", 17, 9, 14);
		addLane("Edge_31", 17, 19, 3);
		addLane("Edge_32", 17, 18, 10);
		addLane("Edge_33", 18, 15, 8);
		addLane("Edge_34", 18, 3, 8);
		addLane("Edge_35", 19, 18, 12);
		addLane("Edge_36", 2, 3, 20);
		addLane("Edge_37", 3, 5, 20);
		addLane("Edge_38", 5, 7, 20);
		addLane("Edge_39", 7, 11, 20);
		addLane("Edge_40", 11, 13, 20);
		addLane("Edge_41", 17, 11, 20);
		addLane("Edge_42", 11, 19, 20);
		addLane("Edge_43", 17, 5, 20);
		addLane("Edge_44", 5, 19, 20);

		// Lets check from location Loc_2 to Loc_19
		Graph graph = new Graph(nodes, edges);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		dijkstra.execute(nodes.get(2));
		LinkedList<Vertex> path = dijkstra.getPath(nodes.get(3));
		dijkstra.execute(nodes.get(3));
		LinkedList<Vertex> path1 = dijkstra.getPath(nodes.get(5));
		dijkstra.execute(nodes.get(5));
		LinkedList<Vertex> path2 = dijkstra.getPath(nodes.get(7));
		dijkstra.execute(nodes.get(7));
		LinkedList<Vertex> path3 = dijkstra.getPath(nodes.get(11));
		dijkstra.execute(nodes.get(11));
		LinkedList<Vertex> path4 = dijkstra.getPath(nodes.get(13));
		dijkstra.execute(nodes.get(13));
		LinkedList<Vertex> path5 = dijkstra.getPath(nodes.get(17));
		dijkstra.execute(nodes.get(17));
		LinkedList<Vertex> path6 = dijkstra.getPath(nodes.get(19));

		assertNotNull(path);
		assertTrue(path.size() > 0);

		for (Vertex vertex : path) {
			System.out.println(vertex);
		}
		for (Vertex vertex : path1) {
			System.out.println(vertex);
		}
		for (Vertex vertex : path2) {
			System.out.println(vertex);
		}
		for (Vertex vertex : path3) {
			System.out.println(vertex);
		}
		for (Vertex vertex : path4) {
			System.out.println(vertex);
		}
		for (Vertex vertex : path5) {
			System.out.println(vertex);
		}
		for (Vertex vertex : path6) {
			System.out.println(vertex);
		}
		

	}

	private void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
		edges.add(lane);
	}
} 