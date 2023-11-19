package com.xayah.core.model.util

import com.xayah.core.model.CompressionType
import com.xayah.core.model.LZ4_SUFFIX
import com.xayah.core.model.OpType
import com.xayah.core.model.SortType
import com.xayah.core.model.TAR_SUFFIX
import com.xayah.core.model.ZSTD_SUFFIX

fun CompressionType.Companion.of(name: String?): CompressionType =
    runCatching { CompressionType.valueOf(name!!.uppercase()) }.getOrDefault(CompressionType.ZSTD)

fun OpType.Companion.of(name: String?): OpType =
    runCatching { OpType.valueOf(name!!.uppercase()) }.getOrDefault(OpType.BACKUP)

fun SortType.Companion.of(name: String?): SortType =
    runCatching { SortType.valueOf(name!!.uppercase()) }.getOrDefault(SortType.ASCENDING)

fun CompressionType.Companion.suffixOf(suffix: String): CompressionType? = when (suffix) {
    TAR_SUFFIX -> CompressionType.TAR
    ZSTD_SUFFIX -> CompressionType.ZSTD
    LZ4_SUFFIX -> CompressionType.LZ4
    else -> null
}
