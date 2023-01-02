import binarytree.toBinaryTree
import binarytree.toGraphviz
import guru.nidi.graphviz.engine.Format.SVG
import java.io.File

fun main() {
    val tree = listOf(5, 3, 7, 2, 4, 6, 8).toBinaryTree()
    println(tree.find(123))
    tree.toGraphviz().render(SVG).toFile(File("example/binary.svg"))
}
