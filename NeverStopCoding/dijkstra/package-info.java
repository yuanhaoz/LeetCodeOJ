/**
 * Dijkstra's shortest path algorithm in Java - Tutorial 
 *  The idea of Dijkstra is simple.
 *  Dijkstra partitions all nodes into two distinct sets. Unsettled and settled. Initially all nodes are in the unsettled sets, e.g. they must be still evaluated. A node is moved to the settled set if a shortest path from the source to this node has been found.
 *  Initially the distance of each node to the source is set to a very high value.
 *  First only the source is in the set of unsettledNodes.
 *  The algorithms runs until the unsettledNodes are empty. In earch iteration it selects the node with the lowest distance from the source out the unsettled nodes. If reads all edges which are outgoing from the source and evaluates for each destination node in these edges which is not yet settled if the known distance from the source to this node can be reduced if the selected edge is used. If this can be done then the distance is updated and the node is added to the nodes which need evaluation.
 *  In pseudocode the algorithm can be described as follows. Please note that Dijkstra also determines the pre-successor of each node on its way to the source. I leave that out of the pseudo code to simplify it. 
 */
/**
 * @author yuanhao
 *
 */
package dijkstra;