data class Node<T>(val value: T, val left: Node<T>? = null, val right: Node<T>? = null): Iterable<T> {
    override fun iterator(): Iterator<T> = inOrder()
}
