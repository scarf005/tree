import guru.nidi.graphviz.engine.Format.PNG
import java.io.File

fun main() {
    val node = Node(3, Node(1, Node(4), Node(15)), Node(6, Node(5)))
    node.toGraphviz().render(PNG).toFile(File("example/binary.png"))
}
