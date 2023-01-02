import guru.nidi.graphviz.attribute.Arrow
import guru.nidi.graphviz.attribute.Label
import guru.nidi.graphviz.attribute.Rank
import guru.nidi.graphviz.attribute.Rank.RankDir.TOP_TO_BOTTOM
import guru.nidi.graphviz.engine.Graphviz
import guru.nidi.graphviz.graph
import guru.nidi.graphviz.invoke
import guru.nidi.graphviz.model.MutableGraph
import guru.nidi.graphviz.toGraphviz

private fun <T> MutableGraph.edgeTo(node: Node<T>, other: Node<T>, color: String) {
    invoke {
        edge["color" eq color]
        "${node.hashCode()}"[Label.of("${node.value}")] - "${other.hashCode()}"[Label.of("${other.value}")]
    }
    addNode(other)
}

private fun <T> MutableGraph.addNode(node: Node<T>): MutableGraph {
    invoke {
        "${node.hashCode()}"[Label.of("${node.value}")]
    }
    node.left?.let { edgeTo(node, it, "brown1") }
    node.right?.let { edgeTo(node, it, "darkturquoise") }
    return this
}

fun <T> Node<T>.toGraphviz(): Graphviz =
    graph(directed = true) {
        edge[Arrow.NORMAL]
        graph[Rank.dir(TOP_TO_BOTTOM)]
    }
        .addNode(this)
        .toGraphviz()
