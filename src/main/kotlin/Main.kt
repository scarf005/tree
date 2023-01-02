import binarytree.toBinaryTree
import binarytree.toGraphviz
import guru.nidi.graphviz.engine.Format.PNG
import java.io.File

fun main() {
    val node = listOf(5, 3, 7, 2, 4, 6, 8).toBinaryTree()
    node.toGraphviz().render(PNG).toFile(File("example/binary.png"))
}
