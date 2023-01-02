package binarytree

data class BinaryTree<T : Comparable<T>>(
    val value: T,
    val left: BinaryTree<T>? = null,
    val right: BinaryTree<T>? = null
) : Iterable<T> {
    override fun iterator(): Iterator<T> = inOrder()
    operator fun plus(other: T): BinaryTree<T> = when {
        value == other -> this
        value > other -> when (left) {
            null -> BinaryTree(value, BinaryTree(other), right)
            else -> BinaryTree(value, left + other, right)
        }

        else -> when (right) {
            null -> BinaryTree(value, left, BinaryTree(other))
            else -> BinaryTree(value, left, right + other)
        }
    }

    companion object {
        fun <T : Comparable<T>> of(vararg values: T): BinaryTree<T> =
            values.fold(BinaryTree(values.first())) { acc, value -> acc + value }
    }
}
