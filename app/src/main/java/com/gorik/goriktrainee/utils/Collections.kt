package com.gorik.goriktrainee.utils



inline fun<T> List<T>.updateAsMutable(block: MutableList<T>.() -> Unit):List<T>{
    return toMutableList()
        .apply(block).toList()
        .toList()
}
