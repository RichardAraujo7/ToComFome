package com.example.constrastoque.service

data class Response (val status:String, val msg:String) {
    fun isOK() = "OK".equals(status, ignoreCase = true)
}