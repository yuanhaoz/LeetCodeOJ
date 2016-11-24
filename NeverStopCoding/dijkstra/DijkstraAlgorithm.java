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

	private final List<Edge> edges;
	private Set<Vertex> settledNodes;
	private Set<Vertex> unSettledNodes;
	private Map<Vertex, Vertex> predecessors;// ������¼���·���Ľڵ���Ϣ��mapʵ��
	private Map<Vertex, Integer> distance;// ������¼ÿ�������Ӧ�����·������

	public DijkstraAlgorithm(Graph graph) {
		new ArrayList<Vertex>(graph.getVertexes());
		this.edges = new ArrayList<Edge>(graph.getEdges());
	}

	// ���뾭��ָ���Ľڵ�demandNodes��������ĿҪ��
	public void execute(Vertex source, List<Vertex> demandNodes) {
		settledNodes = new HashSet<Vertex>();
		unSettledNodes = new HashSet<Vertex>();
		distance = new HashMap<Vertex, Integer>();
		predecessors = new HashMap<Vertex, Vertex>();
		distance.put(source, 0);// ��Դ�ڵ㿪ʼ
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			Vertex node = getMinimum(unSettledNodes);// �õ�������С�Ķ���
			settledNodes.add(node);// ��Ӹýڵ�Ϊ������Ľڵ�
			unSettledNodes.remove(node);// ��δ����Ľڵ㼯��ȥ���ýڵ�
			findMinimalDistances(node, demandNodes);// �ҳ��ýڵ��ھӽڵ����С����ڵ�
		}
	}
	
	// ���뾭��ָ���Ľڵ�demandNodes��������ĿҪ��
	private void findMinimalDistances(Vertex node, List<Vertex> demandNodes) {
		List<Vertex> adjacentNodes = getNeighbors(node, demandNodes);
		for (Vertex target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
				distance.put(target, getShortestDistance(node) + getDistance(node, target));
				predecessors.put(target, node);// ��¼��̾���·��
				unSettledNodes.add(target);// ���δ����ڵ���Ϣ
			}
		}

	}
	
	// ���뾭��ָ���Ľڵ�demandNodes��������ĿҪ��
	private List<Vertex> getNeighbors(Vertex node, List<Vertex> demandNodes) {
		List<Vertex> neighbors = new ArrayList<Vertex>();
		
		// �Ƚ�ָ�����ھӽڵ㣬�������ָ���ڵ㣬����Ҫ�жϱ���ھӽڵ�
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
				// �Ƚ��Ƿ�����ھӽڵ�Ϊָ���Ľڵ㣨����Ϊ�������������ڣ�����Щ�ڵ�����ѡ������ѡ�������ڵ�
				for(int i = 0; i < demandNodes.size(); i++){
					Vertex demandNode = demandNodes.get(i);
					if(edge.getDestination().equals(demandNode)){
						neighbors.add(edge.getDestination());
						System.out.println("����ָ�����ھӽڵ㣺" + edge.getDestination());
					} else {
						
					}
				}
			}
		}
		
		// �ж��Ƿ������������ָ�����ھӽڵ㣬���У�����Ҫ����ھӽڵ㣬���ޣ���������������ھӽڵ�
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
		distance.put(source, 0);// ��Դ�ڵ㿪ʼ
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			Vertex node = getMinimum(unSettledNodes);// �õ�������С�Ķ���
			settledNodes.add(node);// ��Ӹýڵ�Ϊ������Ľڵ�
			unSettledNodes.remove(node);// ��δ����Ľڵ㼯��ȥ���ýڵ�
			findMinimalDistances(node);// �ҳ��ýڵ��ھӽڵ����С����ڵ�
		}
	}

	private void findMinimalDistances(Vertex node) {
		List<Vertex> adjacentNodes = getNeighbors(node);
		for (Vertex target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
				distance.put(target, getShortestDistance(node) + getDistance(node, target));
				predecessors.put(target, node);// ��¼��̾���·��
				unSettledNodes.add(target);// ���δ����ڵ���Ϣ
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
	 * �õ��� ԭʼ�ڵ� �� ѡ��Ŀ��ڵ� �����·�������û�У�����NULL
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
