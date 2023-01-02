package binarytree

import guru.nidi.graphviz.attribute.Color
import guru.nidi.graphviz.attribute.Font
import guru.nidi.graphviz.attribute.Label
import guru.nidi.graphviz.attribute.Style
import guru.nidi.graphviz.engine.Graphviz
import guru.nidi.graphviz.graph
import guru.nidi.graphviz.invoke
import guru.nidi.graphviz.model.MutableGraph
import guru.nidi.graphviz.toGraphviz

private fun <T : Comparable<T>> MutableGraph.edgeTo(node: BinaryTree<T>, other: BinaryTree<T>, color: String) {
    invoke {
        edge["color" eq color]
        "${node.hashCode()}"[Label.of("${node.value}")] - "${other.hashCode()}"[Label.of("${other.value}")]
    }
    addNode(other)
}

private fun <T : Comparable<T>> MutableGraph.addNode(node: BinaryTree<T>): MutableGraph {
    invoke {
        "${node.hashCode()}"[Label.of("${node.value}")]
    }
    node.left?.let { edgeTo(node, it, "brown1") }
    node.right?.let { edgeTo(node, it, "darkturquoise") }
    return this
}

fun <T : Comparable<T>> BinaryTree<T>.toGraphviz(): Graphviz =
    graph(directed = true) {
        node[
            Color.DARKSLATEGRAY,
            "fillcolor" eq "azure2",
            Font.name("Ubuntu Mono"),
            Font.size(20),
            Style.FILLED,
        ]
    }
        .addNode(this)
        .toGraphviz()
