package dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dijkstra.Edge;
import dijkstra.Graph;
import dijkstra.Vertex;

public class DijkstraAlgorithm {

	private final List<Vertex> nodes;
	private final List<Edge> edges;
	private Set<Vertex> settledNodes;
	private Set<Vertex> unSettledNodes;
	private Map<Vertex, Vertex> predecessors;// 用来记录最短路径的节点信息，map实现
	private Map<Vertex, Integer> distance;// 用来记录每个顶点对应的最短路径长度

	public DijkstraAlgorithm(Graph graph) {
		// create a copy of the array so that we can operate on this array
		this.nodes = new ArrayList<Vertex>(graph.getVertexes());
		this.edges = new ArrayList<Edge>(graph.getEdges());
	}

	// 必须经过指定的节点demandNodes，按照题目要求
	public void execute(Vertex source, List<Vertex> demandNodes) {
		settledNodes = new HashSet<Vertex>();
		unSettledNodes = new HashSet<Vertex>();
		distance = new HashMap<Vertex, Integer>();
		predecessors = new HashMap<Vertex, Vertex>();
		distance.put(source, 0);// 从源节点开始
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			Vertex node = getMinimum(unSettledNodes);// 得到距离最小的顶点
			settledNodes.add(node);// 添加该节点为处理过的节点
			unSettledNodes.remove(node);// 从未处理的节点集中去除该节点
			findMinimalDistances(node, demandNodes);// 找出该节点邻居节点的最小距离节点
		}
	}
	
	// 必须经过指定的节点demandNodes，按照题目要求
	private void findMinimalDistances(Vertex node, List<Vertex> demandNodes) {
		List<Vertex> adjacentNodes = getNeighbors(node, demandNodes);
		for (Vertex target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
				distance.put(target, getShortestDistance(node) + getDistance(node, target));
				predecessors.put(target, node);// 记录最短距离路径
				unSettledNodes.add(target);// 添加未处理节点信息
			}
		}

	}
	
	// 必须经过指定的节点demandNodes，按照题目要求
	private List<Vertex> getNeighbors(Vertex node, List<Vertex> demandNodes) {
		List<Vertex> neighbors = new ArrayList<Vertex>();
		
		// 比较指定的邻居节点，如果存在指定节点，则不需要判断别的邻居节点
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
				// 比较是否存在邻居节点为指定的节点（可能为多个），如果存在，则将这些节点加入候选集，不选择其他节点
				for(int i = 0; i < demandNodes.size(); i++){
					Vertex demandNode = demandNodes.get(i);
					if(edge.getDestination().equals(demandNode)){
						neighbors.add(edge.getDestination());
						System.out.println("存在指定的邻居节点：" + edge.getDestination());
					} else {
						
					}
				}
			}
		}
		
		// 判断是否存在满足需求指定的邻居节点，若有，则不需要别的邻居节点，若无，则加上它的所有邻居节点
		if(neighbors.size() == 0){
			for (Edge edge : edges) {
				if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
					neighbors.add(edge.getDestination());
				}
			}
		}
		
		return neighbors;
	}
		
	public void execute(Vertex source) {
		settledNodes = new HashSet<Vertex>();
		unSettledNodes = new HashSet<Vertex>();
		distance = new HashMap<Vertex, Integer>();
		predecessors = new HashMap<Vertex, Vertex>();
		distance.put(source, 0);// 从源节点开始
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			Vertex node = getMinimum(unSettledNodes);// 得到距离最小的顶点
			settledNodes.add(node);// 添加该节点为处理过的节点
			unSettledNodes.remove(node);// 从未处理的节点集中去除该节点
			findMinimalDistances(node);// 找出该节点邻居节点的最小距离节点
		}
	}

	private void findMinimalDistances(Vertex node) {
		List<Vertex> adjacentNodes = getNeighbors(node);
		for (Vertex target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
				distance.put(target, getShortestDistance(node) + getDistance(node, target));
				predecessors.put(target, node);// 记录最短距离路径
				unSettledNodes.add(target);// 添加未处理节点信息
			}
		}

	}

	private int getDistance(Vertex node, Vertex target) {
		for (Edge edge : edges) {
			if (edge.getSource().equals(node)
					&& edge.getDestination().equals(target)) {
				return edge.getWeight();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<Vertex> getNeighbors(Vertex node) {
		List<Vertex> neighbors = new ArrayList<Vertex>();
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}

	private Vertex getMinimum(Set<Vertex> vertexes) {
		Vertex minimum = null;
		for (Vertex vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(Vertex vertex) {
		return settledNodes.contains(vertex);
	}

	private int getShortestDistance(Vertex destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	/*
	 * This method returns the path from the source to the selected target and
	 * NULL if no path exists
	 * 得到从 原始节点 到 选定目标节点 的最短路径，如果没有，返回NULL
	 */
	public LinkedList<Vertex> getPath(Vertex target) {
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex step = target;
		// check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}

}
