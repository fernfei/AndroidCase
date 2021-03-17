package com.banshion.uibestpractice

import java.lang.Exception

sealed class Result
class Success(val msg: String) : Result()
class Failure(val error: Exception) : Result()