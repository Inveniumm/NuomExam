package com.nuom.nuomtest.di

/**
 * Data class "Post" model for the api requests
 */
data class Post(
    val id: Int?,
    val userId: Int?,
    val title: String?,
    val body: String?
)