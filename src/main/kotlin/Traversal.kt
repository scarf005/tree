fun <T> Node<T>.preOrder(): Iterator<T> = sequence {
    yield(value)
    left?.preOrder()?.forEach { yield(it) }
    right?.preOrder()?.forEach { yield(it) }
}.iterator()

fun<T> Node<T>.inOrder(): Iterator<T> = sequence {
    left?.inOrder()?.forEach { yield(it) }
    yield(value)
    right?.inOrder()?.forEach { yield(it) }
}.iterator()

fun<T> Node<T>.postOrder(): Iterator<T> = sequence {
    left?.postOrder()?.forEach { yield(it) }
    right?.postOrder()?.forEach { yield(it) }
    yield(value)
}.iterator()
