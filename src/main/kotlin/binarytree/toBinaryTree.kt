package binarytree

inline fun <reified T : Comparable<T>> List<T>.toBinaryTree(): BinaryTree<T> = when {
    isEmpty() -> throw IllegalArgumentException("Cannot create a binary tree from an empty list")
    else -> BinaryTree.of(*toTypedArray())
}
