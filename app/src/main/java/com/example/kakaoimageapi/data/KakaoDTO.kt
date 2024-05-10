package com.example.kakaoimageapi.data

import com.google.gson.annotations.SerializedName

data class KakaoDTO(val response: KakaoResponse)

data class KakaoResponse(
    @SerializedName("meta")
    val metaData: MetaData?,
    @SerializedName("documents")
    val documents: MutableList<documents>?
)

data class MetaData(
    val total_count: Int,
    val pageable_count: Int,
    val is_end: Boolean
)


data class documents(
    val collection: String,
    val thumbnail_url: String,
    val image_url: String,
    val width: Int,
    val height: Int,
    val display_sitename: String,
    val doc_url: String,
    val datetime: String
)
